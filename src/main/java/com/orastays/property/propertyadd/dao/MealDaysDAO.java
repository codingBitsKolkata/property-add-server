package com.orastays.property.propertyadd.dao;

import com.orastays.property.propertyadd.entity.MealDaysEntity;

public class MealDaysDAO extends GenericDAO<MealDaysEntity, Long>{
	
	private static final long serialVersionUID = -1526682345148661343L;

	public MealDaysDAO() {
		super(MealDaysEntity.class);
	}
}
