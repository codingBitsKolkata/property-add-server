package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomCategoryEntity;
import com.orastays.property.propertyadd.model.RoomCategoryModel;

@Component
public class RoomCategoryConverter extends CommonConverter
		implements BaseConverter<RoomCategoryEntity, RoomCategoryModel> {

	private static final long serialVersionUID = 6255959173759896724L;
	private static final Logger logger = LogManager.getLogger(RoomCategoryConverter.class);

	@Override
	public RoomCategoryEntity modelToEntity(RoomCategoryModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomCategoryModel entityToModel(RoomCategoryEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomCategoryModel> entityListToModelList(List<RoomCategoryEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
