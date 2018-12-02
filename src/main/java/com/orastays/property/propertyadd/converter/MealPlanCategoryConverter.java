package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.MealPlanCategoryEntity;
import com.orastays.property.propertyadd.model.MealPlanCategoryModel;

@Component
public class MealPlanCategoryConverter extends CommonConverter
		implements BaseConverter<MealPlanCategoryEntity, MealPlanCategoryModel> {

	private static final long serialVersionUID = 5711677835864341929L;
	private static final Logger logger = LogManager.getLogger(MealPlanCategoryConverter.class);

	@Override
	public MealPlanCategoryEntity modelToEntity(MealPlanCategoryModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MealPlanCategoryModel entityToModel(MealPlanCategoryEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MealPlanCategoryModel> entityListToModelList(List<MealPlanCategoryEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
