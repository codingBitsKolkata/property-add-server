package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.AmenitiesTypeEntity;
import com.orastays.property.propertyadd.model.AmenitiesTypeModel;

@Component
public class AmenitiesTypeConverter extends CommonConverter implements BaseConverter<AmenitiesTypeEntity, AmenitiesTypeModel> {

	private static final long serialVersionUID = -5497668039041430153L;
	private static final Logger logger = LogManager.getLogger(AmenitiesTypeConverter.class);

	@Override
	public AmenitiesTypeEntity modelToEntity(AmenitiesTypeModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AmenitiesTypeModel entityToModel(AmenitiesTypeEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AmenitiesTypeModel> entityListToModelList(List<AmenitiesTypeEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
