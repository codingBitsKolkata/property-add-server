package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.MealCategoryEntity;
import com.orastays.property.propertyadd.model.MealCategoryModel;

@Component
public class MealCategoryConverter extends CommonConverter
		implements BaseConverter<MealCategoryEntity, MealCategoryModel> {

	private static final long serialVersionUID = 6155847824377920903L;
	private static final Logger logger = LogManager.getLogger(MealCategoryConverter.class);

	@Override
	public MealCategoryEntity modelToEntity(MealCategoryModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MealCategoryModel entityToModel(MealCategoryEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MealCategoryModel> entityListToModelList(List<MealCategoryEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}