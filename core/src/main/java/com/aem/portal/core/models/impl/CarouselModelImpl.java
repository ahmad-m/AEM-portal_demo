package com.aem.portal.core.models.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.portal.core.CarouselBean;
import com.aem.portal.core.models.CarouselModel;
import org.apache.sling.models.annotations.Exporter;

@Model(adaptables = Resource.class, adapters = CarouselModel.class, resourceType = CarouselModelImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json")
public class CarouselModelImpl implements CarouselModel {

	protected static final String RESOURCE_TYPE = "portal/components/content/carousel";

	/**
	 * The static logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarouselModelImpl.class);

	/**
	 * The iconCarouselElements Property as authored by the user.
	 */
	@Inject
	private Resource carouselElements;

	@Override
	public List<CarouselBean> getCarouselElements() {
		List<CarouselBean> carouselElementList = new ArrayList<>();
		try {
			if (null != carouselElements) {
				Iterator<Resource> linkResources = carouselElements.listChildren();
				while (linkResources.hasNext()) {
					CarouselBean dataResource = linkResources.next().adaptTo(CarouselBean.class);
					if (null != dataResource) {
						carouselElementList.add(dataResource);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.debug(e.toString());
		}
		return carouselElementList;
	}

}
