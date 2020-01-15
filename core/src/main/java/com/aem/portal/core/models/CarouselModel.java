package com.aem.portal.core.models;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.aem.portal.core.CarouselBean;

@ConsumerType
public interface CarouselModel {
	List<CarouselBean> getCarouselElements();
}
