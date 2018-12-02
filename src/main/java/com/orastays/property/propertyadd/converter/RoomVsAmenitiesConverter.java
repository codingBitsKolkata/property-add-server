package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomVsAmenitiesEntity;
import com.orastays.property.propertyadd.model.RoomVsAmenitiesModel;

@Component
public class RoomVsAmenitiesConverter extends CommonConverter
		implements BaseConverter<RoomVsAmenitiesEntity, RoomVsAmenitiesModel> {

	private static final long serialVersionUID = -4858154515911634790L;
	private static final Logger logger = LogManager.getLogger(RoomVsAmenitiesConverter.class);

	@Override
	public RoomVsAmenitiesEntity modelToEntity(RoomVsAmenitiesModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomVsAmenitiesModel entityToModel(RoomVsAmenitiesEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomVsAmenitiesModel> entityListToModelList(List<RoomVsAmenitiesEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
