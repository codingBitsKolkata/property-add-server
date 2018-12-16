package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.RoomVsSpecialitiesEntity;
import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.RoomVsSpecialitiesModel;

@Component
public class RoomVsSpecialitiesConverter extends CommonConverter
		implements BaseConverter<RoomVsSpecialitiesEntity, RoomVsSpecialitiesModel> {

	private static final long serialVersionUID = -74840772349731968L;
	
	private static final Logger logger = LogManager.getLogger(RoomVsSpecialitiesConverter.class);

	@Override
	public RoomVsSpecialitiesEntity modelToEntity(RoomVsSpecialitiesModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		RoomVsSpecialitiesEntity roomVsSpecialitiesEntity = new RoomVsSpecialitiesEntity();
		roomVsSpecialitiesEntity = (RoomVsSpecialitiesEntity) Util.transform(modelMapper, m, roomVsSpecialitiesEntity);
		roomVsSpecialitiesEntity.setStatus(Status.INACTIVE.ordinal());
		roomVsSpecialitiesEntity.setCreatedBy(Long.parseLong(String.valueOf(Status.ZERO.ordinal())));
		roomVsSpecialitiesEntity.setCreatedDate(Util.getCurrentDateTime());
		roomVsSpecialitiesEntity.setSpecialtiesEntity(specialtiesDAO.find(Long.valueOf(m.getSpecialtiesModel().getSpecialtiesId())));

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return roomVsSpecialitiesEntity;
	}

	@Override
	public RoomVsSpecialitiesModel entityToModel(RoomVsSpecialitiesEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		RoomVsSpecialitiesModel roomVsSpecialitiesModel = new RoomVsSpecialitiesModel();
		roomVsSpecialitiesModel = (RoomVsSpecialitiesModel) Util.transform(modelMapper, e, roomVsSpecialitiesModel);
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return roomVsSpecialitiesModel;
	}

	@Override
	public List<RoomVsSpecialitiesModel> entityListToModelList(List<RoomVsSpecialitiesEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<RoomVsSpecialitiesModel> roomVsSpecialitiesModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			roomVsSpecialitiesModels = new ArrayList<>();
			for(RoomVsSpecialitiesEntity roomVsSpecialitiesEntity:es) {
				roomVsSpecialitiesModels.add(entityToModel(roomVsSpecialitiesEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return roomVsSpecialitiesModels;
	}
}
