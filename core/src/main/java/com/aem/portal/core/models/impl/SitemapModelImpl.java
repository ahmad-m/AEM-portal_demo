package com.aem.portal.core.models.impl;

import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;

import com.aem.portal.core.HeaderNavLinkModel;
import com.aem.portal.core.SiteMapBean;
import com.aem.portal.core.SiteMapInnerBean2L;
import com.aem.portal.core.SiteMapOuterBean1L;
import com.aem.portal.core.models.HeaderModel;
import com.aem.portal.core.models.SitemapModel;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.foundation.Sitemap;
import com.day.cq.wcm.foundation.Sitemap.Link;

import org.apache.sling.models.annotations.Exporter;

@Model(adaptables = { SlingHttpServletRequest.class, Resource.class }, adapters = SitemapModel.class, resourceType = SitemapModelImpl.RESOURCE_TYPE,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json")
public class SitemapModelImpl implements SitemapModel {
	protected static final String RESOURCE_TYPE = "portal/components/content/sitemap";
	
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
	private String							siteRootPath;


	@Override
	public Map<String, List<Map<String, String>>> getSitemapSites() {
		List<SiteMapBean> siteMapList = new ArrayList<SiteMapBean>();
		List<SiteMapBean> subSiteMapList = new ArrayList<SiteMapBean>();
		Page rootPage0L = this.resourceResolver.adaptTo(PageManager.class).getPage(this.siteRootPath);
		Map<String, List<Map<String, String>>> finalMap = null;
		
		Sitemap stm = new Sitemap(rootPage0L);
		System.out.println("SiteMap size "+stm.getLinks().size());
		List<String> titleList1L = new ArrayList<String>();
		for (Link link : stm.getLinks()) {
			if(null != link & link.getLevel() == 1){
				
				System.out.println("Link Title: "+link.getTitle()+"\t Path: "+link.getPath()+"\t Level: "+link.getLevel());
				titleList1L.add(link.getTitle());
			}
			for(String title : titleList1L){
				finalMap = new HashMap<>();
				List<Map<String, String>> listofMap = new ArrayList<>();
				Map<String, String> title2L = new HashMap<>();
				if(link.getPath().toLowerCase().contains(title.toLowerCase())){
					title2L.put(link.getTitle(), link.getPath());
					listofMap.add(title2L);
					}
				finalMap.put(title, listofMap);
			}
		System.out.println(finalMap);
		}
		/*
		Iterator<Page> childrenPage = rootPage0L.listChildren();
		while(null != childrenPage && childrenPage.hasNext()){
			Page subPage1L = childrenPage.next();
			
//			System.out.println("PageTitle : "+subPage1L.getPageTitle());
			Iterator<Page> childrenPage2l = subPage1L.listChildren();
				while(null!= childrenPage2l && childrenPage2l.hasNext()){
					Page subPage2l = childrenPage2l.next();
					SiteMapBean siteMapBean2l = subPage2l.getContentResource().adaptTo(SiteMapBean.class);
					subSiteMapList.add(siteMapBean2l);
				}
			
			SiteMapBean siteMapBean1L = subPage1L.getContentResource().adaptTo(SiteMapBean.class);
			siteMapList.add(siteMapBean1L);
			
		}*/
		
		return finalMap;
	}
	
	
	@Override
	public List<SiteMapOuterBean1L> getSitemapDetails() {
		List<SiteMapOuterBean1L> siteMap1l = new ArrayList<>();
		List<SiteMapInnerBean2L> siteMap2l = null;
		
		Page rootPage0L = this.resourceResolver.adaptTo(PageManager.class).getPage(this.siteRootPath);
		
		Sitemap stm = new Sitemap(rootPage0L);
		System.out.println("SiteMap size "+stm.getLinks().size());
		List<String> titleList1L = new ArrayList<String>();
		for (Link link : stm.getLinks()) {
			if(null != link & link.getLevel() == 1){
				
				System.out.println("Link Title: "+link.getTitle()+"\t Path: "+link.getPath()+"\t Level: "+link.getLevel());
				titleList1L.add(link.getTitle());
			}
			SiteMapOuterBean1L siteMapOutterObj = new SiteMapOuterBean1L();
			for(String title : titleList1L){
				siteMap2l = new ArrayList<>();
				if(link.getPath().toLowerCase().contains(title.toLowerCase())){
					SiteMapInnerBean2L siteMapInnerObj =  new SiteMapInnerBean2L();
					siteMapInnerObj.setPageTitle(link.getTitle());
					siteMapInnerObj.setPagePath(link.getPath());
					siteMapInnerObj.setPageLevel(""+link.getLevel());
					siteMap2l.add(siteMapInnerObj);
					}
				siteMapOutterObj.setInnerPage(siteMap2l);
				siteMapOutterObj.setTitle(link.getTitle());
			}
			siteMap1l.add(siteMapOutterObj);
		}
		System.out.println("SIteMap1L size: "+siteMap1l.size());
		System.out.println("SIteMap1L : "+siteMap1l);
		return siteMap1l;
	}

}
