package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomEntity;
import com.orastays.property.propertyadd.model.RoomModel;

@Component
public class RoomConverter extends CommonConverter
		implements BaseConverter<RoomEntity, RoomModel> {

	
	private static final long serialVersionUID = -6532505845959859730L;
	private static final Logger logger = LogManager.getLogger(RoomConverter.class);

	@Override
	public RoomEntity modelToEntity(RoomModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomModel entityToModel(RoomEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomModel> entityListToModelList(List<RoomEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
