package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.RoomEntity;
import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.RoomModel;

@Component
public class RoomConverter extends CommonConverter
		implements BaseConverter<RoomEntity, RoomModel> {

	
	private static final long serialVersionUID = -6532505845959859730L;
	private static final Logger logger = LogManager.getLogger(RoomConverter.class);

	@Override
	public RoomEntity modelToEntity(RoomModel m) {

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		RoomEntity roomEntity = new RoomEntity();
		roomEntity = (RoomEntity) Util.transform(modelMapper, m, roomEntity);
		roomEntity.setStatus(Status.ACTIVE.ordinal());
		roomEntity.setCreatedDate(Util.getCurrentDateTime());
		
		roomEntity.setAccommodationEntity(accommodationDAO.find(Long.valueOf(m.getAccommodationModel().getAccommodationId())));
		roomEntity.setRoomCategoryEntity(roomCategoryDAO.find(Long.valueOf(m.getRoomCategoryModel().getRoomCatId())));
		roomEntity.setRoomStandardEntity(roomStandardDAO.find(Long.valueOf(m.getRoomStandardModel().getRoomStandardId())));

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return roomEntity;
		
	}

	@Override
	public RoomModel entityToModel(RoomEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		RoomModel roomModel = null;
		
		if(Objects.nonNull(e)){
			roomModel = new RoomModel();
			roomModel = (RoomModel) Util.transform(modelMapper, e, roomModel);
			roomModel.setAccommodationModel(accommodationConverter.entityToModel(e.getAccommodationEntity()));
			
			roomModel.setRoomCategoryModel(roomCategoryConverter.entityToModel(e.getRoomCategoryEntity()));
			roomModel.setRoomStandardModel(roomStandardConverter.entityToModel(e.getRoomStandardEntity()));
			roomModel.setRoomVsBedModel(roomVsBedConverter.entityToModel(e.getRoomVsBedEntity()));
			roomModel.setRoomVsAmenitiesModels(roomVsAmenitiesConverter.entityListToModelList(e.getRoomVsAmenitiesEntities()));
			roomModel.setRoomVsCancellationModels(roomVsCancellationConverter.entityListToModelList(e.getRoomVsCancellationEntities()));
			roomModel.setRoomVsImageModels(roomVsImageConverter.entityListToModelList(e.getRoomVsImageEntities()));
			roomModel.setRoomVsPriceModels(roomVsPriceConverter.entityListToModelList(e.getRoomVsPriceEntities()));
			roomModel.setRoomVsHostDiscountModels(roomVsHostDiscountConverter.entityListToModelList(e.getRoomVsHostDiscountEntities()));
			roomModel.setRoomVsOraDiscountModels(roomVsOraDiscountConverter.entityListToModelList(e.getRoomVsOraDiscountEntities()));
			roomModel.setRoomVsOrapricePercModels(roomVsOraPricePercentageConverter.entityListToModelList(e.getRoomVsOraPricePercentageEntities()));
			roomModel.setRoomVsSpecialitiesModels(roomVsSpecialitiesConverter.entityListToModelList(e.getRoomVsSpecialitiesEntities()));
			roomModel.setRoomVsMealModels(roomVsMealConverter.entityListToModelList(e.getRoomVsMealEntities()));
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return roomModel;
	}

	@Override
	public List<RoomModel> entityListToModelList(List<RoomEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<RoomModel> roomModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			roomModels = new ArrayList<>();
			for(RoomEntity roomEntity:es) {
				roomModels.add(entityToModel(roomEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return roomModels;
	}

	

}
