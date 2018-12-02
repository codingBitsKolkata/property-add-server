package com.orastays.property.propertyadd.dao;

import com.orastays.property.propertyadd.entity.MealPlanCategoryEntity;

public class MealPlanCategoryDAO extends GenericDAO<MealPlanCategoryEntity, Long>{

	private static final long serialVersionUID = 2378674047575583918L;

	public MealPlanCategoryDAO() {
		super(MealPlanCategoryEntity.class);
	}
}
