package com.aem.portal.core;

import java.util.List;

public class HeaderNavBean {
	
	/**
	 * The navigationTab
	 */
	private HeaderNavLinkModel			navigationTab;

	/**
	 * The subNavList
	 */
	private List<HeaderNavLinkModel>	subNavList;
	
	private List<HeaderNavBean>	subSubNavList;

	public HeaderNavLinkModel getNavigationTab() {
		return navigationTab;
	}

	public void setNavigationTab(HeaderNavLinkModel navigationTab) {
		this.navigationTab = navigationTab;
	}

	public List<HeaderNavLinkModel> getSubNavList() {
		return subNavList;
	}

	public void setSubNavList(List<HeaderNavLinkModel> subNavList) {
		this.subNavList = subNavList;
	}

	public HeaderNavBean(HeaderNavLinkModel navigationTab, List<HeaderNavLinkModel> subNavList) {
		this.navigationTab = navigationTab;
		this.subNavList = subNavList;
	}

	
	public HeaderNavBean( List<HeaderNavBean> subSubNavList,HeaderNavLinkModel navigationTab) {
		this.navigationTab = navigationTab;
		this.subSubNavList = subSubNavList;
	}

	@Override
	public String toString() {
		return "HeaderNavBean [navigationTab=" + navigationTab.getJcrTitle() + ", subNavList=" + subNavList + "]";
	}

	public List<HeaderNavBean> getSubSubNavList() {
		return subSubNavList;
	}

	public void setSubSubNavList(List<HeaderNavBean> subSubNavList) {
		this.subSubNavList = subSubNavList;
	}
	
	
}
