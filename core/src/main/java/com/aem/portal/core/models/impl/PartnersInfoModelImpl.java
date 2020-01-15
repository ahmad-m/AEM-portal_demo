package com.aem.portal.core.models.impl;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.portal.core.PartnersInfoBean;
import com.aem.portal.core.models.PartnersInfoModel;



@Model(adaptables={Resource.class}, adapters=PartnersInfoModel.class, resourceType=PartnersInfoModelImpl.resourceType, defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
@Exporter(name="partnerInfo", extensions="json")
public class PartnersInfoModelImpl implements PartnersInfoModel{
	protected static final String resourceType = "portal/components/content/partnersinfo";
	
	private static final Logger log = LoggerFactory.getLogger(PartnersInfoModelImpl.class);
	
	@Inject
	private String pfName;
	
	
	@Inject
	private String plName;
	@Inject
	private String pGender;
	@Inject
	private String pCurrentAddress;
	@Inject 
	private String pPmntAddress;
	
	@Inject
	private String isCurrentAndPermanentSame;
	
	
	public String getIsCurrentAndPermanentSame() {
		return isCurrentAndPermanentSame;
	}

	public String getPlName() {
		return plName;
	}

	public String getpGender() {
		return pGender;
	}

	public String getpCurrentAddress() {
		return pCurrentAddress;
	}

	private PartnersInfoBean pBean;
	
	@Override
	public PartnersInfoBean getPartnersInfo() {
		if(null == pBean){
			pBean = new PartnersInfoBean();
			pBean.setPfName(pfName);
			pBean.setPlName(plName);
			pBean.setpGender(pGender);
			pBean.setpCurrentAddress(pCurrentAddress);
			if(null != isCurrentAndPermanentSame & isCurrentAndPermanentSame.equalsIgnoreCase("true")){
				pBean.setpPmntAddress(pCurrentAddress);
			}else{
			pBean.setpPmntAddress(pPmntAddress);
			}
			log.info(pBean.toString());
		}
		return pBean;
	}

	@Override
	public String getPfName() {
		return pfName;
	}

	public String getpPmntAddress() {
		return pPmntAddress;
	}

}
