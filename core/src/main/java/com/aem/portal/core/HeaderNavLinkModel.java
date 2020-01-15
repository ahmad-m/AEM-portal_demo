package com.aem.portal.core;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import org.apache.sling.models.annotations.Exporter;


@Model(adaptables = Resource.class, adapters = HeaderNavLinkModel.class,
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json")

public class HeaderNavLinkModel {
	
	/**
	 * The Resource.
	 */
	@Self
	private Resource								resource;

	/**
	 * The jcr:title property authored in pageProperties.
	 */
	@Inject
	@Named("jcr:title")
	private String									jcrTitle;
	
	/**
	 * The navTitle property authored in pageProperties.
	 */
	@Inject
	@Named("navTitle")
	private String									navTitle;
	
	/**
	 * The pageTitle property authored in pageProperties.
	 */
	@Inject
	@Named("pageTitle")
	private String									pageTitle;
	
	/**
	 * The subtitle property authored in pageProperties.
	 */
	@Inject
	@Named("subtitle")
	private String									subTitle;

	/**
	 * The redirectTarget property authored in pageProperties.
	 */
	@Inject
	@Named("redirectTarget")
	private String									redirectTarget;
	
	boolean isExternal;
	
	/**
	 * @return the isExternal
	 */
	public boolean isExternal() {
		return isExternal;
	}
	

	public void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}


	public String getJcrTitle() {
		return jcrTitle;
	}

	public void setJcrTitle(String jcrTitle) {
		this.jcrTitle = jcrTitle;
	}

	public String getNavTitle() {
		return navTitle;
	}

	public void setNavTitle(String navTitle) {
		this.navTitle = navTitle;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	/**
	 * @return the redirectTarget
	 */
	public String getRedirectTarget() {
		/*if (this.resource.getValueMap().containsKey("redirectTarget")) {
			redirectTarget = this.resource.getValueMap().get("redirectTarget").toString();
			System.out.println("redirectTarget --> "+redirectTarget);
		}*/
		return redirectTarget;
	}


	public void setRedirectTarget(String redirectTarget) {
		this.redirectTarget = redirectTarget;
	}
	
	
}
