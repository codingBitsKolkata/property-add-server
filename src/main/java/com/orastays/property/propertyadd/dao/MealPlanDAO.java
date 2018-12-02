package com.orastays.property.propertyadd.dao;

import com.orastays.property.propertyadd.entity.MealPlanEntity;

public class MealPlanDAO extends GenericDAO<MealPlanEntity, Long>{

	private static final long serialVersionUID = -1053659675187967291L;

	public MealPlanDAO() {
		super(MealPlanEntity.class);
	}
}
