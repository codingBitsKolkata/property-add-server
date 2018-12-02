package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.PGCategorySexEntity;
import com.orastays.property.propertyadd.model.PGCategorySexModel;

@Component
public class PropertyVsGuestAccessConverter extends CommonConverter
		implements BaseConverter<PGCategorySexEntity, PGCategorySexModel> {

	private static final long serialVersionUID = 4517963113550272759L;
	private static final Logger logger = LogManager.getLogger(PropertyVsGuestAccessConverter.class);

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
		// TODO Auto-generated method stub
		return null;
	}

}
