package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomVsInfoEntity;
import com.orastays.property.propertyadd.model.RoomVsInfoModel;

@Component
public class RoomVsInfoConverter extends CommonConverter implements BaseConverter<RoomVsInfoEntity, RoomVsInfoModel> {

	private static final long serialVersionUID = -6875617161053014130L;
	private static final Logger logger = LogManager.getLogger(RoomVsInfoConverter.class);

	@Override
	public RoomVsInfoEntity modelToEntity(RoomVsInfoModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomVsInfoModel entityToModel(RoomVsInfoEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomVsInfoModel> entityListToModelList(List<RoomVsInfoEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
