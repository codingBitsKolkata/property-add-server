package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.StateVsCityEntity;
import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.StateVsCityModel;

@Component
public class StateVsCityConverter extends CommonConverter implements
		BaseConverter<StateVsCityEntity, StateVsCityModel> {

	private static final long serialVersionUID = 131775959894638735L;
	private static final Logger logger = LogManager.getLogger(StateVsCityConverter.class);

	@Override
	public StateVsCityEntity modelToEntity(StateVsCityModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		StateVsCityEntity stateVsCityEntity = new StateVsCityEntity();
		stateVsCityEntity = (StateVsCityEntity) Util.transform(modelMapper, m, stateVsCityEntity);
		stateVsCityEntity.setStatus(Status.ACTIVE.ordinal());
		stateVsCityEntity.setCreatedBy(Long.parseLong(String.valueOf(Status.ZERO.ordinal())));
		stateVsCityEntity.setCreatedDate(Util.getCurrentDateTime());
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return stateVsCityEntity;
	}

	@Override
	public StateVsCityModel entityToModel(StateVsCityEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		StateVsCityModel stateVsCityModel = null;
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			stateVsCityModel = new StateVsCityModel();
			stateVsCityModel = (StateVsCityModel) Util.transform(modelMapper, e, stateVsCityModel);
		}
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return stateVsCityModel;
	}

	@Override
	public List<StateVsCityModel> entityListToModelList(List<StateVsCityEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<StateVsCityModel> stateVsCityModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			stateVsCityModels = new ArrayList<>();
			for(StateVsCityEntity stateVsCityEntity:es) {
				stateVsCityModels.add(entityToModel(stateVsCityEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return stateVsCityModels;
	}

}
