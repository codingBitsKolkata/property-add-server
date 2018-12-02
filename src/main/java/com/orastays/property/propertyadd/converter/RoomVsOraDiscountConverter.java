package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.RoomVsOraDiscountEntity;
import com.orastays.property.propertyadd.model.RoomVsOraDiscountModel;

@Component
public class RoomVsOraDiscountConverter extends CommonConverter
		implements BaseConverter<RoomVsOraDiscountEntity, RoomVsOraDiscountModel> {

	private static final long serialVersionUID = 2117334663641665760L;
	private static final Logger logger = LogManager.getLogger(RoomVsOraDiscountConverter.class);

	@Override
	public RoomVsOraDiscountEntity modelToEntity(RoomVsOraDiscountModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomVsOraDiscountModel entityToModel(RoomVsOraDiscountEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomVsOraDiscountModel> entityListToModelList(List<RoomVsOraDiscountEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
