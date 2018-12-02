package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.PropertyVsNearbyEntity;
import com.orastays.property.propertyadd.model.PropertyVsNearbyModel;

@Component
public class PropertyVsNearbyConverter extends CommonConverter
		implements BaseConverter<PropertyVsNearbyEntity, PropertyVsNearbyModel> {

	private static final long serialVersionUID = -5052826047073738394L;
	private static final Logger logger = LogManager.getLogger(PropertyVsNearbyConverter.class);

	@Override
	public PropertyVsNearbyEntity modelToEntity(PropertyVsNearbyModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyVsNearbyModel entityToModel(PropertyVsNearbyEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyVsNearbyModel> entityListToModelList(List<PropertyVsNearbyEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
