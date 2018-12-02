package com.orastays.property.propertyadd.dao;

import com.orastays.property.propertyadd.entity.MealCategoryEntity;

public class MealCategoryDAO extends GenericDAO<MealCategoryEntity, Long>{
	
	private static final long serialVersionUID = 1128420205132398487L;

	public MealCategoryDAO() {
		super(MealCategoryEntity.class);
	}

}
