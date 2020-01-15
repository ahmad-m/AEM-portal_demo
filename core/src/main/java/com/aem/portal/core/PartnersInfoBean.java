package com.aem.portal.core;

import javax.inject.Inject;

public class PartnersInfoBean {

	@Inject
	private String pfName;
	@Inject
	private String plName;
	@Inject
	private String pGender;
	
	public String getpCurrentAddress() {
		return pCurrentAddress;
	}
	public void setpCurrentAddress(String pCurrentAddress) {
		this.pCurrentAddress = pCurrentAddress;
	}
	public String getpPmntAddress() {
		return pPmntAddress;
	}
	public void setpPmntAddress(String pPmntAddress) {
		this.pPmntAddress = pPmntAddress;
	}
	@Inject
	private String pCurrentAddress;
	@Inject 
	private String pPmntAddress;
	
	public String getPfName() {
		return pfName;
	}
	public void setPfName(String pfName) {
		this.pfName = pfName;
	}
	public String getPlName() {
		return plName;
	}
	public void setPlName(String plName) {
		this.plName = plName;
	}
	public String getpGender() {
		return pGender;
	}
	public void setpGender(String pGender) {
		this.pGender = pGender;
	}
	
	@Override
	public String toString() {
		return "PartnersInfoBean [pfName=" + pfName + ", plName=" + plName + ", pGender=" + pGender
				+ ", pCurrentAddress=" + pCurrentAddress + ", pPmntAddress=" + pPmntAddress + "]";
	}
	
	
}
