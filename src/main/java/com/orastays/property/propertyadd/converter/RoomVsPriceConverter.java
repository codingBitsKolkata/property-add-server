package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.RoomVsPriceEntity;
import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.RoomVsPriceModel;

@Component
public class RoomVsPriceConverter extends CommonConverter
		implements BaseConverter<RoomVsPriceEntity, RoomVsPriceModel> {

	private static final long serialVersionUID = -6987883354674730631L;
	private static final Logger logger = LogManager.getLogger(RoomVsPriceConverter.class);

	@Override
	public RoomVsPriceEntity modelToEntity(RoomVsPriceModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		RoomVsPriceEntity roomVsPriceEntity = new RoomVsPriceEntity();
		roomVsPriceEntity = (RoomVsPriceEntity) Util.transform(modelMapper, m, roomVsPriceEntity);
		roomVsPriceEntity.setStatus(Status.ACTIVE.ordinal());
		roomVsPriceEntity.setCreatedDate(Util.getCurrentDateTime());
		roomVsPriceEntity.setPriceTypeEntity(priceTypeDAO.find(Long.valueOf(m.getPriceTypeModel().getPriceTypeId())));

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return roomVsPriceEntity;
	}

	@Override
	public RoomVsPriceModel entityToModel(RoomVsPriceEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		RoomVsPriceModel roomVsPriceModel = new RoomVsPriceModel();
		roomVsPriceModel = (RoomVsPriceModel) Util.transform(modelMapper, e, roomVsPriceModel);
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return roomVsPriceModel;
	}

	@Override
	public List<RoomVsPriceModel> entityListToModelList(List<RoomVsPriceEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<RoomVsPriceModel> roomVsPriceModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			roomVsPriceModels = new ArrayList<>();
			for(RoomVsPriceEntity roomVsPriceEntity:es) {
				roomVsPriceModels.add(entityToModel(roomVsPriceEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return roomVsPriceModels;
	}
}
