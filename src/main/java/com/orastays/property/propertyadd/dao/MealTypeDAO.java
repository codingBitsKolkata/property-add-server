package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.MealTypeEntity;

@Repository
public class MealTypeDAO extends GenericDAO<MealTypeEntity, Long>{

	private static final long serialVersionUID = -5667892235760448650L;

	public MealTypeDAO() {
		super(MealTypeEntity.class);
	}
}
