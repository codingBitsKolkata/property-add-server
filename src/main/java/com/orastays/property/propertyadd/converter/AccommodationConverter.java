package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.AccommodationEntity;
import com.orastays.property.propertyadd.model.AccommodationModel;

@Component
public class AccommodationConverter extends CommonConverter implements BaseConverter<AccommodationEntity, AccommodationModel>{

	private static final long serialVersionUID = 3737221202978877997L;
	private static final Logger logger = LogManager.getLogger(AccommodationConverter.class);
	
	@Override
	public AccommodationEntity modelToEntity(AccommodationModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccommodationModel entityToModel(AccommodationEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccommodationModel> entityListToModelList(List<AccommodationEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
