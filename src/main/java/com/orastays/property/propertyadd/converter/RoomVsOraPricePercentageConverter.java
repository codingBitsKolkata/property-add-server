package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.RoomVsOraPricePercentageEntity;
import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.RoomVsOrapricePercModel;

@Component
public class RoomVsOraPricePercentageConverter extends CommonConverter
		implements BaseConverter<RoomVsOraPricePercentageEntity, RoomVsOrapricePercModel> {

	private static final long serialVersionUID = -1100382970490875823L;
	
	private static final Logger logger = LogManager.getLogger(RoomVsOraPricePercentageConverter.class);

	@Override
	public RoomVsOraPricePercentageEntity modelToEntity(RoomVsOrapricePercModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		RoomVsOraPricePercentageEntity roomVsOraPricePercentageEntity = new RoomVsOraPricePercentageEntity();
		roomVsOraPricePercentageEntity = (RoomVsOraPricePercentageEntity) Util.transform(modelMapper, m, roomVsOraPricePercentageEntity);
		roomVsOraPricePercentageEntity.setStatus(Status.INACTIVE.ordinal());
		roomVsOraPricePercentageEntity.setCreatedBy(Long.parseLong(String.valueOf(Status.ZERO.ordinal())));
		roomVsOraPricePercentageEntity.setCreatedDate(Util.getCurrentDateTime());

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return roomVsOraPricePercentageEntity;
	}

	@Override
	public RoomVsOrapricePercModel entityToModel(RoomVsOraPricePercentageEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		RoomVsOrapricePercModel roomVsOrapricePercModel = new RoomVsOrapricePercModel();
		roomVsOrapricePercModel = (RoomVsOrapricePercModel) Util.transform(modelMapper, e, roomVsOrapricePercModel);
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return roomVsOrapricePercModel;
	}

	@Override
	public List<RoomVsOrapricePercModel> entityListToModelList(List<RoomVsOraPricePercentageEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<RoomVsOrapricePercModel> roomVsOrapricePercModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			roomVsOrapricePercModels = new ArrayList<>();
			for(RoomVsOraPricePercentageEntity roomVsOraPricePercentageEntity:es) {
				roomVsOrapricePercModels.add(entityToModel(roomVsOraPricePercentageEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return roomVsOrapricePercModels;
	}
}
