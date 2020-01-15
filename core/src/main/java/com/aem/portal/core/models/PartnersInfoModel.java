package com.aem.portal.core.models;

import org.osgi.annotation.versioning.ConsumerType;

import com.aem.portal.core.PartnersInfoBean;


@ConsumerType
public interface PartnersInfoModel {
	PartnersInfoBean getPartnersInfo();
	String getPfName();
}
