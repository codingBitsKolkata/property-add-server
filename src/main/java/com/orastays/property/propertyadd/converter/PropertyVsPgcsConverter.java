package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.PropertyVsPgcsEntity;
import com.orastays.property.propertyadd.model.PropertyVsPgcsModel;

@Component
public class PropertyVsPgcsConverter extends CommonConverter
		implements BaseConverter<PropertyVsPgcsEntity, PropertyVsPgcsModel> {

	private static final long serialVersionUID = -549724460872810295L;
	private static final Logger logger = LogManager.getLogger(PropertyVsPgcsConverter.class);

	@Override
	public PropertyVsPgcsEntity modelToEntity(PropertyVsPgcsModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyVsPgcsModel entityToModel(PropertyVsPgcsEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyVsPgcsModel> entityListToModelList(List<PropertyVsPgcsEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
