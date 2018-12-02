package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomVsHostDiscountEntity;
import com.orastays.property.propertyadd.model.RoomVsHostDiscountModel;

@Component
public class RoomVsHostDiscountConverter extends CommonConverter
		implements BaseConverter<RoomVsHostDiscountEntity, RoomVsHostDiscountModel> {

	private static final long serialVersionUID = -4000646452448985112L;
	private static final Logger logger = LogManager.getLogger(RoomVsHostDiscountConverter.class);

	@Override
	public RoomVsHostDiscountEntity modelToEntity(RoomVsHostDiscountModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomVsHostDiscountModel entityToModel(RoomVsHostDiscountEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomVsHostDiscountModel> entityListToModelList(List<RoomVsHostDiscountEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
