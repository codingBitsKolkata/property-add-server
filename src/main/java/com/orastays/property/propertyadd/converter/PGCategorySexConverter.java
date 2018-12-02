package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.PGCategorySexEntity;
import com.orastays.property.propertyadd.model.PGCategorySexModel;

@Component
public class PGCategorySexConverter extends CommonConverter
		implements BaseConverter<PGCategorySexEntity, PGCategorySexModel> {

	private static final long serialVersionUID = 4517963113550272759L;
	private static final Logger logger = LogManager.getLogger(PGCategorySexConverter.class);

	@Override
	public PGCategorySexEntity modelToEntity(PGCategorySexModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PGCategorySexModel entityToModel(PGCategorySexEntity e) {
		// TODO Auto-generated method stub
		return null;
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
