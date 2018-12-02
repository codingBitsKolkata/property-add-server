package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomVsOraPricePercentageEntity;

@Component
public class RoomVsOraPricePercentageConverter extends CommonConverter
		implements BaseConverter<RoomVsOraPricePercentageEntity, RoomVsOraPricePercentageModel> {


	private static final Logger logger = LogManager.getLogger(RoomVsOraPricePercentageConverter.class);

	@Override
	public RoomVsOraPricePercentageEntity modelToEntity(RoomVsOraPricePercentageModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomVsOraPricePercentageModel entityToModel(RoomVsOraPricePercentageEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomVsOraPricePercentageModel> entityListToModelList(List<RoomVsOraPricePercentageEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}



}
