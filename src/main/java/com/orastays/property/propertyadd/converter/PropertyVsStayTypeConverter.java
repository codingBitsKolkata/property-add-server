package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.PropertyVsStayTypeEntity;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.PropertyVsStayTypeModel;

@Component
public class PropertyVsStayTypeConverter extends CommonConverter
		implements BaseConverter<PropertyVsStayTypeEntity, PropertyVsStayTypeModel> {

	private static final Logger logger = LogManager.getLogger(PropertyVsStayTypeConverter.class);

	@Override
	public PropertyVsStayTypeEntity modelToEntity(PropertyVsStayTypeModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyVsStayTypeModel entityToModel(PropertyVsStayTypeEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyVsStayTypeModel propertyVsStayTypeModel = new PropertyVsStayTypeModel();
		propertyVsStayTypeModel = (PropertyVsStayTypeModel) Util.transform(modelMapper, e, propertyVsStayTypeModel);
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyVsStayTypeModel;
	}

	@Override
	public List<PropertyVsStayTypeModel> entityListToModelList(List<PropertyVsStayTypeEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<PropertyVsStayTypeModel> propertyVsStayTypeModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			propertyVsStayTypeModels = new ArrayList<>();
			for(PropertyVsStayTypeEntity propertyVsStayTypeEntity:es) {
				propertyVsStayTypeModels.add(entityToModel(propertyVsStayTypeEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return propertyVsStayTypeModels;
	}

}
