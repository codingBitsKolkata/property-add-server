package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.PGCategorySexEntity;
import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.PGCategorySexModel;

@Component
public class PGCategorySexConverter extends CommonConverter
		implements BaseConverter<PGCategorySexEntity, PGCategorySexModel> {

	private static final long serialVersionUID = 4517963113550272759L;
	private static final Logger logger = LogManager.getLogger(PGCategorySexConverter.class);

	@Override
	public PGCategorySexEntity modelToEntity(PGCategorySexModel m) {
		
		PGCategorySexEntity categorySexEntity = new PGCategorySexEntity();
		categorySexEntity = (PGCategorySexEntity) Util.transform(modelMapper, m, categorySexEntity);
		categorySexEntity.setStatus(Status.ACTIVE.ordinal());
		categorySexEntity.setCreatedBy(Long.parseLong(String.valueOf(Status.ZERO.ordinal())));
		categorySexEntity.setCreatedDate(Util.getCurrentDateTime());
		
		return categorySexEntity;
	}

	@Override
	public PGCategorySexModel entityToModel(PGCategorySexEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PGCategorySexModel pgCategorySexModel = null;
		
		if(Objects.nonNull(e)) {
			pgCategorySexModel = new PGCategorySexModel();
			pgCategorySexModel = (PGCategorySexModel) Util.transform(modelMapper, e, pgCategorySexModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return pgCategorySexModel;
	}

	@Override
	public List<PGCategorySexModel> entityListToModelList(List<PGCategorySexEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<PGCategorySexModel> pgCategorySexModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			pgCategorySexModels = new ArrayList<>();
			for(PGCategorySexEntity pgCategorySexEntity:es) {
				pgCategorySexModels.add(entityToModel(pgCategorySexEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return pgCategorySexModels;
	}

}
