package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.MealPlanCatVsMealPlanEntity;
import com.orastays.property.propertyadd.model.MealPlanCategoryVsMealPlanModel;

@Component
public class MealPlanCatVsMealPlanConverter extends CommonConverter
		implements BaseConverter<MealPlanCatVsMealPlanEntity, MealPlanCategoryVsMealPlanModel> {

	private static final long serialVersionUID = 5446873681124249282L;
	private static final Logger logger = LogManager.getLogger(MealPlanCatVsMealPlanConverter.class);

	@Override
	public MealPlanCatVsMealPlanEntity modelToEntity(MealPlanCategoryVsMealPlanModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MealPlanCategoryVsMealPlanModel entityToModel(MealPlanCatVsMealPlanEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MealPlanCategoryVsMealPlanModel> entityListToModelList(List<MealPlanCatVsMealPlanEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}
