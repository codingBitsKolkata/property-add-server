package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.SpecialtiesEntity;
import com.orastays.property.propertyadd.model.SpecialtiesModel;

@Component
public class SpecialExperienceConverter extends CommonConverter
		implements BaseConverter<SpecialtiesEntity, SpecialtiesModel> {

	private static final long serialVersionUID = -5794757932589577355L;
	private static final Logger logger = LogManager.getLogger(SpecialExperienceConverter.class);

	@Override
	public SpecialtiesEntity modelToEntity(SpecialtiesModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpecialtiesModel entityToModel(SpecialtiesEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpecialtiesModel> entityListToModelList(List<SpecialtiesEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
