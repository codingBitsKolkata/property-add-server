package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.MealPlanEntity;
import com.orastays.property.propertyadd.helper.Util;
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
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		MealPlanModel mealPlanModel = new MealPlanModel();
		mealPlanModel = (MealPlanModel) Util.transform(modelMapper, e, mealPlanModel);
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return mealPlanModel;
	}

	@Override
	public List<MealPlanModel> entityListToModelList(List<MealPlanEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<MealPlanModel> mealPlanModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			mealPlanModels = new ArrayList<>();
			for(MealPlanEntity mealPlanEntity:es) {
				mealPlanModels.add(entityToModel(mealPlanEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return mealPlanModels;
	}

}