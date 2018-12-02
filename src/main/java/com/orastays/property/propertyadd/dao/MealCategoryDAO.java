package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.MealCategoryEntity;

@Repository
public class MealCategoryDAO extends GenericDAO<MealCategoryEntity, Long>{
	
	private static final long serialVersionUID = 1128420205132398487L;

	public MealCategoryDAO() {
		super(MealCategoryEntity.class);
	}

}
