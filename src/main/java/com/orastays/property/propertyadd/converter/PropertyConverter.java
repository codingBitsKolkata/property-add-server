package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.PropertyEntity;
import com.orastays.property.propertyadd.model.PropertyModel;

@Component
public class PropertyConverter extends CommonConverter implements BaseConverter<PropertyEntity, PropertyModel> {

	private static final long serialVersionUID = 1937719597880236169L;
	private static final Logger logger = LogManager.getLogger(PropertyConverter.class);

	@Override
	public PropertyEntity modelToEntity(PropertyModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyModel entityToModel(PropertyEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyModel> entityListToModelList(List<PropertyEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
