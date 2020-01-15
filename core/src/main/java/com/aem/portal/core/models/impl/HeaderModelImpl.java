package com.aem.portal.core.models.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.portal.core.HeaderNavBean;
import com.aem.portal.core.HeaderNavLinkModel;
import com.aem.portal.core.constant.ResourceConstants;
import com.aem.portal.core.models.HeaderModel;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Model(adaptables = { SlingHttpServletRequest.class, Resource.class }, adapters = HeaderModel.class, resourceType = HeaderModelImpl.RESOURCE_TYPE,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json")
public class HeaderModelImpl implements HeaderModel {
	private static final Logger LOGGER = LoggerFactory.getLogger(HeaderModelImpl.class);
	protected static final String RESOURCE_TYPE = "portal/components/content/header";
	
	/**
	 * The ResourceResolver.
	 */
	@Inject
	private ResourceResolver			resourceResolver;
	
	/**
	 * The navPath property as authored by the user.
	 */
	@Inject
	@Via("resource")
	private String							navPath;

	

	private Boolean isHideInNav(Page page) {
		Resource pageContent = page.getContentResource();
		Boolean hideInNav = Boolean.FALSE;
		if (null != pageContent) {
			ValueMap pageVMap = pageContent.adaptTo(ValueMap.class);
			if (null != pageVMap && pageVMap.containsKey(ResourceConstants.HIDE_IN_NAVIGATION)
					&& pageVMap.get(ResourceConstants.HIDE_IN_NAVIGATION).toString()
							.equalsIgnoreCase(Boolean.TRUE.toString())) {
				hideInNav = Boolean.TRUE;
			}
		}
		
		return hideInNav;
	}
	
	/**
	 * The getSubNavList method returns a list of sub-navigation links as the
	 * value
	 * 
	 * @param subNavPagesIterator
	 * @return a List of sub-navigation titles & links.
	 */
	private List<HeaderNavLinkModel> getSubNavList(Iterator<Page> subNavPagesIterator) {
		List<HeaderNavLinkModel> subNavList;
		HeaderNavLinkModel subNavPageModel = null;
		subNavList = new ArrayList<>();
		while (null != subNavPagesIterator && subNavPagesIterator.hasNext()) {	
			Page childPage = subNavPagesIterator.next();
			if (!(isHideInNav(childPage))) {
				subNavPageModel = childPage.getContentResource().adaptTo(HeaderNavLinkModel.class);
				subNavPageModel.setRedirectTarget(childPage.getPath());
				subNavList.add(subNavPageModel);
			}
		}
		return subNavList;
	}
	
	private List<HeaderNavBean> getSubSubNavList(Iterator<Page> subNavPagesIterator) {
		List<HeaderNavBean> navList = new ArrayList<>();
		List<HeaderNavLinkModel> subNavList;
		HeaderNavLinkModel subNavPageModel = null;
		subNavList = new ArrayList<>();
		while (null != subNavPagesIterator && subNavPagesIterator.hasNext()) {	
			Page childPage = subNavPagesIterator.next();
			if (!(isHideInNav(childPage))) {
				Iterator<Page> subSubNavPagesIterator = childPage.listChildren();
				subNavList = getSubNavList(subSubNavPagesIterator);
				subNavPageModel = childPage.getContentResource().adaptTo(HeaderNavLinkModel.class);
				subNavPageModel.setRedirectTarget(childPage.getPath());
				
				navList.add(new HeaderNavBean(subNavPageModel, subNavList));
			}
		}
	return navList;	
	}
	
	@Override
	public List<HeaderNavBean> getHeaderNavigation() {
		
		List<HeaderNavBean> navList = new ArrayList<>();
		List<HeaderNavLinkModel> subNavList = null;
		List<HeaderNavBean> subSubNavList = new ArrayList<>();
		ResourceResolver resolver = this.resourceResolver;

		if (null != resolver.adaptTo(PageManager.class)) {
			Page rootPage = resolver.adaptTo(PageManager.class).getPage(this.navPath);
			Page navigationPage = null;
			Iterator<Page> rootPageIterator = null != rootPage ? rootPage.listChildren() : null;
			try {
				while (null != rootPageIterator && rootPageIterator.hasNext()) {
					navigationPage = rootPageIterator.next();
					if (!(isHideInNav(navigationPage))) {
						Iterator<Page> subNavPagesIterator = navigationPage.listChildren();
						subNavList = getSubNavList(subNavPagesIterator);
//						subSubNavList = getSubSubNavList(subNavPagesIterator);
						HeaderNavLinkModel headerNavModel = navigationPage.getContentResource().adaptTo(HeaderNavLinkModel.class);
						headerNavModel.setRedirectTarget(navigationPage.getPath());
						navList.add(new HeaderNavBean( headerNavModel, subNavList));
//						navList.add(new HeaderNavBean( subSubNavList, headerNavModel));
					}
				}
			} catch (Exception e) {
				LOGGER.error("Error in headerNavigation" + e.getMessage());
			}
		}

		return navList;
	}

}
