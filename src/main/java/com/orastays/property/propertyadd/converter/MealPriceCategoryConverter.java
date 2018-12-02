package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.MealPriceCategoryEntity;
import com.orastays.property.propertyadd.model.MealPriceCategoryModel;

@Component
public class MealPriceCategoryConverter extends CommonConverter
		implements BaseConverter<MealPriceCategoryEntity, MealPriceCategoryModel> {

	private static final long serialVersionUID = -8505391246907782099L;
	private static final Logger logger = LogManager.getLogger(MealPriceCategoryConverter.class);

	@Override
	public MealPriceCategoryEntity modelToEntity(MealPriceCategoryModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MealPriceCategoryModel entityToModel(MealPriceCategoryEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MealPriceCategoryModel> entityListToModelList(List<MealPriceCategoryEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<MealPriceCategoryModel> mealPriceCategoryModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			mealPriceCategoryModels = new ArrayList<>();
			for(MealPriceCategoryEntity mealPriceCategoryEntity:es) {
				mealPriceCategoryModels.add(entityToModel(mealPriceCategoryEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return mealPriceCategoryModels;
	}
}
