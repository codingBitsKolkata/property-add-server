package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomStandardEntity;
import com.orastays.property.propertyadd.model.RoomStandardModel;

@Component
public class RoomStandardConverter extends CommonConverter
		implements BaseConverter<RoomStandardEntity, RoomStandardModel> {

	private static final long serialVersionUID = 8126896890217765710L;
	private static final Logger logger = LogManager.getLogger(RoomStandardConverter.class);

	@Override
	public RoomStandardEntity modelToEntity(RoomStandardModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomStandardModel entityToModel(RoomStandardEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomStandardModel> entityListToModelList(List<RoomStandardEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
