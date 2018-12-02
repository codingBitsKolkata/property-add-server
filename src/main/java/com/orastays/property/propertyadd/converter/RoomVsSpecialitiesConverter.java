package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomVsSpecialitiesEntity;

@Component
public class RoomVsSpecialitiesConverter extends CommonConverter
		implements BaseConverter<RoomVsSpecialitiesEntity, RoomVsSpecialitiesModel> {

	
	private static final Logger logger = LogManager.getLogger(RoomVsSpecialitiesConverter.class);

	@Override
	public RoomVsSpecialitiesEntity modelToEntity(RoomVsSpecialitiesModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomVsSpecialitiesModel entityToModel(RoomVsSpecialitiesEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomVsSpecialitiesModel> entityListToModelList(List<RoomVsSpecialitiesEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
