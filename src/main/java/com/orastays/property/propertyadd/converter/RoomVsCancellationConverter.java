package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomVsCancellationEntity;
import com.orastays.property.propertyadd.model.RoomVsCancellationModel;

@Component
public class RoomVsCancellationConverter extends CommonConverter
		implements BaseConverter<RoomVsCancellationEntity, RoomVsCancellationModel> {

	private static final long serialVersionUID = 5826695203338063494L;
	private static final Logger logger = LogManager.getLogger(RoomVsCancellationConverter.class);

	@Override
	public RoomVsCancellationEntity modelToEntity(RoomVsCancellationModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomVsCancellationModel entityToModel(RoomVsCancellationEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomVsCancellationModel> entityListToModelList(List<RoomVsCancellationEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
