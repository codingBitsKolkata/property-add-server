package com.orastays.property.propertyadd.dao;

import com.orastays.property.propertyadd.entity.MealPriceCategoryEntity;

public class MealPriceCategoryDAO extends GenericDAO<MealPriceCategoryEntity, Long>{

	private static final long serialVersionUID = 1585242654830887252L;

	public MealPriceCategoryDAO() {
		super(MealPriceCategoryEntity.class);
	}
}
