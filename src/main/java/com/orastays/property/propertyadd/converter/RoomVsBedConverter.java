package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomVsBedEntity;
import com.orastays.property.propertyadd.model.RoomVsBedModel;

@Component
public class RoomVsBedConverter extends CommonConverter implements BaseConverter<RoomVsBedEntity, RoomVsBedModel> {

	private static final long serialVersionUID = -710429158752467664L;
	private static final Logger logger = LogManager.getLogger(RoomVsBedConverter.class);

	@Override
	public RoomVsBedEntity modelToEntity(RoomVsBedModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomVsBedModel entityToModel(RoomVsBedEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomVsBedModel> entityListToModelList(List<RoomVsBedEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
