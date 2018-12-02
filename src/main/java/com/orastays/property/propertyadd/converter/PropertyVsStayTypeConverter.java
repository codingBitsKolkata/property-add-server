package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.PropertyVsStayTypeEntity;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyVsStayTypeModel> entityListToModelList(List<PropertyVsStayTypeEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
