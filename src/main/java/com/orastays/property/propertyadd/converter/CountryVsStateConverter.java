package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.CountryVsStateEntity;
import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.CountryVsStateModel;

@Component
public class CountryVsStateConverter extends CommonConverter implements
		BaseConverter<CountryVsStateEntity, CountryVsStateModel> {

	private static final long serialVersionUID = 7484543161542099221L;
	private static final Logger logger = LogManager.getLogger(CountryVsStateConverter.class);

	@Override
	public CountryVsStateEntity modelToEntity(CountryVsStateModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		CountryVsStateEntity countryVsStateEntity = new CountryVsStateEntity();
		countryVsStateEntity = (CountryVsStateEntity) Util.transform(modelMapper, m, countryVsStateEntity);
		countryVsStateEntity.setStatus(Status.ACTIVE.ordinal());
		countryVsStateEntity.setCreatedBy(Long.parseLong(String.valueOf(Status.ZERO.ordinal())));
		countryVsStateEntity.setCreatedDate(Util.getCurrentDateTime());
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return countryVsStateEntity;
	}

	@Override
	public CountryVsStateModel entityToModel(CountryVsStateEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		CountryVsStateModel countryVsStateModel = null;
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			countryVsStateModel = new CountryVsStateModel();
			countryVsStateModel = (CountryVsStateModel) Util.transform(modelMapper, e, countryVsStateModel);
		}
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return countryVsStateModel;
	}

	@Override
	public List<CountryVsStateModel> entityListToModelList(List<CountryVsStateEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<CountryVsStateModel> countryVsStateModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			countryVsStateModels = new ArrayList<>();
			for(CountryVsStateEntity countryVsStateEntity:es) {
				countryVsStateModels.add(entityToModel(countryVsStateEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return countryVsStateModels;
	}

}
