package com.orastays.property.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.property.propertyadd.entity.MealCategoryEntity;
import com.orastays.property.propertyadd.helper.Util;
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
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		MealCategoryModel mealCategoryModel = null;
		
		if(Objects.nonNull(e)) {
			mealCategoryModel = new MealCategoryModel();
			mealCategoryModel = (MealCategoryModel) Util.transform(modelMapper, e, mealCategoryModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return mealCategoryModel;
	}

	@Override
	public List<MealCategoryModel> entityListToModelList(List<MealCategoryEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<MealCategoryModel> mealCategoryModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			mealCategoryModels = new ArrayList<>();
			for(MealCategoryEntity mealCategoryEntity:es) {
				mealCategoryModels.add(entityToModel(mealCategoryEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return mealCategoryModels;
	}

}