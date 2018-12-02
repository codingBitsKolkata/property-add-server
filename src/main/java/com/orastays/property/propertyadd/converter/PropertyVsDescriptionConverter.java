package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.PropertyVsHomestayEntity;
import com.orastays.property.propertyadd.model.PropertyVsHomestayModel;

@Component
public class PropertyVsDescriptionConverter extends CommonConverter
		implements BaseConverter<PropertyVsHomestayEntity, PropertyVsHomestayModel> {

	private static final long serialVersionUID = 450326924626216300L;
	private static final Logger logger = LogManager.getLogger(PropertyVsDescriptionConverter.class);

	@Override
	public PropertyVsHomestayEntity modelToEntity(PropertyVsHomestayModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyVsHomestayModel entityToModel(PropertyVsHomestayEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyVsHomestayModel> entityListToModelList(List<PropertyVsHomestayEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
