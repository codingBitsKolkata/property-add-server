package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomVsImageEntity;
import com.orastays.property.propertyadd.model.RoomVsImageModel;

@Component
public class RoomVsImageConverter extends CommonConverter
		implements BaseConverter<RoomVsImageEntity, RoomVsImageModel> {

	private static final long serialVersionUID = 6202228879748998556L;
	private static final Logger logger = LogManager.getLogger(RoomVsImageConverter.class);

	@Override
	public RoomVsImageEntity modelToEntity(RoomVsImageModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomVsImageModel entityToModel(RoomVsImageEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomVsImageModel> entityListToModelList(List<RoomVsImageEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
