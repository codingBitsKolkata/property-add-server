package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.RoomVsHostDiscountEntity;
import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.RoomVsHostDiscountModel;

@Component
public class RoomVsHostDiscountConverter extends CommonConverter
		implements BaseConverter<RoomVsHostDiscountEntity, RoomVsHostDiscountModel> {

	private static final long serialVersionUID = -4000646452448985112L;
	private static final Logger logger = LogManager.getLogger(RoomVsHostDiscountConverter.class);

	@Override
	public RoomVsHostDiscountEntity modelToEntity(RoomVsHostDiscountModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		RoomVsHostDiscountEntity roomVsHostDiscountEntity = new RoomVsHostDiscountEntity();
		roomVsHostDiscountEntity = (RoomVsHostDiscountEntity) Util.transform(modelMapper, m, roomVsHostDiscountEntity);
		roomVsHostDiscountEntity.setStatus(Status.INACTIVE.ordinal());
		roomVsHostDiscountEntity.setCreatedBy(Long.parseLong(String.valueOf(Status.ZERO.ordinal())));
		roomVsHostDiscountEntity.setCreatedDate(Util.getCurrentDateTime());
		roomVsHostDiscountEntity.setDiscountCategoryHostEntity(discountCategoryHostDAO.find(Long.valueOf(m.getDiscountCategoryHostModel().getDchId())));

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return roomVsHostDiscountEntity;
	}

	@Override
	public RoomVsHostDiscountModel entityToModel(RoomVsHostDiscountEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		RoomVsHostDiscountModel roomVsHostDiscountModel = new RoomVsHostDiscountModel();
		roomVsHostDiscountModel = (RoomVsHostDiscountModel) Util.transform(modelMapper, e, roomVsHostDiscountModel);
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return roomVsHostDiscountModel;
	}

	@Override
	public List<RoomVsHostDiscountModel> entityListToModelList(List<RoomVsHostDiscountEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<RoomVsHostDiscountModel> roomVsHostDiscountModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			roomVsHostDiscountModels = new ArrayList<>();
			for(RoomVsHostDiscountEntity roomVsHostDiscountEntity:es) {
				roomVsHostDiscountModels.add(entityToModel(roomVsHostDiscountEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return roomVsHostDiscountModels;
	}

}
