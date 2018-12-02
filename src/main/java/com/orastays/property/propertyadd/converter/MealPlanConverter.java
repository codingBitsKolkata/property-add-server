package com.orastays.property.propertyadd.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.MealPlanEntity;
import com.orastays.property.propertyadd.model.MealPlanModel;

@Component
public class MealPlanConverter extends CommonConverter implements BaseConverter<MealPlanEntity, MealPlanModel> {

	private static final long serialVersionUID = 438732824960909879L;
	private static final Logger logger = LogManager.getLogger(MealPlanConverter.class);

	@Override
	public MealPlanEntity modelToEntity(MealPlanModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MealPlanModel entityToModel(MealPlanEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MealPlanModel> entityListToModelList(List<MealPlanEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

}