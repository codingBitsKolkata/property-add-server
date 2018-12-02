package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.PropertyVsPriceDropEntity;
import com.orastays.property.propertyadd.model.PropertyVsPriceDropModel;

@Component
public class PropertyVsPriceDropConverter extends CommonConverter
		implements BaseConverter<PropertyVsPriceDropEntity, PropertyVsPriceDropModel> {

	private static final long serialVersionUID = -3079477860269369413L;
	private static final Logger logger = LogManager.getLogger(PropertyVsPriceDropConverter.class);

	@Override
	public PropertyVsPriceDropEntity modelToEntity(PropertyVsPriceDropModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyVsPriceDropModel entityToModel(PropertyVsPriceDropEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyVsPriceDropModel> entityListToModelList(List<PropertyVsPriceDropEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
