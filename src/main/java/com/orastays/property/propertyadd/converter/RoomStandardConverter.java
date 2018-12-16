package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.RoomStandardEntity;
import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.RoomStandardModel;

@Component
public class RoomStandardConverter extends CommonConverter
		implements BaseConverter<RoomStandardEntity, RoomStandardModel> {

	private static final long serialVersionUID = 8126896890217765710L;
	private static final Logger logger = LogManager.getLogger(RoomStandardConverter.class);

	@Override
	public RoomStandardEntity modelToEntity(RoomStandardModel m) {

		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		RoomStandardEntity roomStandardEntity = new RoomStandardEntity();
		roomStandardEntity = (RoomStandardEntity) Util.transform(modelMapper, m, roomStandardEntity);
		roomStandardEntity.setStatus(Status.INACTIVE.ordinal());
		roomStandardEntity.setCreatedBy(Long.parseLong(String.valueOf(Status.ZERO.ordinal())));
		roomStandardEntity.setCreatedDate(Util.getCurrentDateTime());

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return roomStandardEntity;
		
	}

	@Override
	public RoomStandardModel entityToModel(RoomStandardEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		RoomStandardModel roomStandardModel = new RoomStandardModel();
		roomStandardModel = (RoomStandardModel) Util.transform(modelMapper, e, roomStandardModel);
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return roomStandardModel;
	}

	@Override
	public List<RoomStandardModel> entityListToModelList(List<RoomStandardEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<RoomStandardModel> roomStandardModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			roomStandardModels = new ArrayList<>();
			for(RoomStandardEntity roomStandardEntity:es) {
				roomStandardModels.add(entityToModel(roomStandardEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return roomStandardModels;
	}

}
