package com.aem.portal.core.models;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ConsumerType;

import com.aem.portal.core.SiteMapOuterBean1L;

@ConsumerType
public interface SitemapModel {
	Map<String, List<Map<String, String>>> getSitemapSites();
	
	List<SiteMapOuterBean1L> getSitemapDetails();
}
