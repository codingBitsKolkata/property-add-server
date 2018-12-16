package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.RoomVsOraDiscountEntity;
import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.RoomVsOraDiscountModel;

@Component
public class RoomVsOraDiscountConverter extends CommonConverter
		implements BaseConverter<RoomVsOraDiscountEntity, RoomVsOraDiscountModel> {

	private static final long serialVersionUID = 2117334663641665760L;
	private static final Logger logger = LogManager.getLogger(RoomVsOraDiscountConverter.class);

	@Override
	public RoomVsOraDiscountEntity modelToEntity(RoomVsOraDiscountModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		RoomVsOraDiscountEntity roomVsOraDiscountEntity = new RoomVsOraDiscountEntity();
		roomVsOraDiscountEntity = (RoomVsOraDiscountEntity) Util.transform(modelMapper, m, roomVsOraDiscountEntity);
		roomVsOraDiscountEntity.setStatus(Status.INACTIVE.ordinal());
		roomVsOraDiscountEntity.setCreatedBy(Long.parseLong(String.valueOf(Status.ZERO.ordinal())));
		roomVsOraDiscountEntity.setCreatedDate(Util.getCurrentDateTime());
		roomVsOraDiscountEntity.setDiscountCategoryOraEntity(discountCategoryOraDAO.find(Long.valueOf(m.getDiscountCategoryOraModel().getDcoId())));

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return roomVsOraDiscountEntity;
	}

	@Override
	public RoomVsOraDiscountModel entityToModel(RoomVsOraDiscountEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		RoomVsOraDiscountModel roomVsOraDiscountModel = new RoomVsOraDiscountModel();
		roomVsOraDiscountModel = (RoomVsOraDiscountModel) Util.transform(modelMapper, e, roomVsOraDiscountModel);
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return roomVsOraDiscountModel;
	}

	@Override
	public List<RoomVsOraDiscountModel> entityListToModelList(List<RoomVsOraDiscountEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<RoomVsOraDiscountModel> roomVsOraDiscountModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			roomVsOraDiscountModels = new ArrayList<>();
			for(RoomVsOraDiscountEntity roomVsOraDiscountEntity:es) {
				roomVsOraDiscountModels.add(entityToModel(roomVsOraDiscountEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return roomVsOraDiscountModels;
	}
}
