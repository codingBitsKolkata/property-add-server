package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.PropertyTypeEntity;
import com.orastays.property.propertyadd.model.PropertyTypeModel;

@Component
public class PropertyTypeConverter extends CommonConverter
		implements BaseConverter<PropertyTypeEntity, PropertyTypeModel> {

	private static final long serialVersionUID = 7470863919139179518L;
	private static final Logger logger = LogManager.getLogger(PropertyTypeConverter.class);

	@Override
	public PropertyTypeEntity modelToEntity(PropertyTypeModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyTypeModel entityToModel(PropertyTypeEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyTypeModel> entityListToModelList(List<PropertyTypeEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
