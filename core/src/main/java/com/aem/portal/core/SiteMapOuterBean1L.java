package com.aem.portal.core;

import java.util.List;

public class SiteMapOuterBean1L {
	
	private String title;
	private List<SiteMapInnerBean2L> innerPage;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<SiteMapInnerBean2L> getInnerPage() {
		return innerPage;
	}
	public void setInnerPage(List<SiteMapInnerBean2L> innerPage) {
		this.innerPage = innerPage;
	}
	
}
