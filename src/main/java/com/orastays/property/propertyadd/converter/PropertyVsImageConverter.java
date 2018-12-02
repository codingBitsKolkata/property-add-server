package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.PropertyVsImageEntity;
import com.orastays.property.propertyadd.model.PropertyVsImageModel;

@Component
public class PropertyVsImageConverter extends CommonConverter
		implements BaseConverter<PropertyVsImageEntity, PropertyVsImageModel> {

	private static final long serialVersionUID = -67953202535609461L;
	private static final Logger logger = LogManager.getLogger(PropertyVsImageConverter.class);

	@Override
	public PropertyVsImageEntity modelToEntity(PropertyVsImageModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyVsImageModel entityToModel(PropertyVsImageEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyVsImageModel> entityListToModelList(List<PropertyVsImageEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
