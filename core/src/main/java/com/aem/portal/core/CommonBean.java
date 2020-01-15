package com.aem.portal.core;

import org.apache.sling.api.resource.ValueMap;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

public class CommonBean extends WCMUsePojo{
	String redirectTarget;
	
	
	
	@Override
	public void activate() throws Exception {
		/*
		Node currentNode = getResource().adaptTo(Node.class);
		System.out.println("currentNode -> "+currentNode);
		String createdBy = currentNode.getProperty("jcr:createdBy").getString();
		System.out.println("creatd By  -> "+createdBy);
//		redirectTarget = getProperties().get("jcr:createdBy", "").toString();
		*/
		Page page = getCurrentPage();
		System.out.println("Page --> "+page.getPath());
		System.out.println("ComponentContext Root --> "+getComponentContext().getRoot().toString());
		System.out.println("ComponentContext Component --> "+getComponentContext().getComponent().getName());
		String pTitle = page.getPageTitle();
		System.out.println("pTitle -> " +pTitle);
		PageManager pageManager = getPageManager();
		Page currentPage = pageManager.getContainingPage(getResource());
		
		String pagePath = currentPage.getPath();
		System.out.println("pagePath -> "+pagePath );
		
		ValueMap valueMap = getProperties();
		valueMap.forEach((k,v) -> System.out.println(k +"\t"+ v));
	}

	public String getRedirectTarget() {
		return redirectTarget;
	}
	
	public void setRedirectTarget(String redirectTarget){
		this.redirectTarget= redirectTarget;
	}

}
