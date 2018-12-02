package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.AmenitiesEntity;
import com.orastays.property.propertyadd.model.AmenitiesModel;

@Component
public class AmenitiesConverter extends CommonConverter implements BaseConverter<AmenitiesEntity, AmenitiesModel> {

	private static final long serialVersionUID = 2386241926454947717L;
	private static final Logger logger = LogManager.getLogger(AmenitiesConverter.class);

	@Override
	public AmenitiesEntity modelToEntity(AmenitiesModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AmenitiesModel entityToModel(AmenitiesEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AmenitiesModel> entityListToModelList(List<AmenitiesEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
