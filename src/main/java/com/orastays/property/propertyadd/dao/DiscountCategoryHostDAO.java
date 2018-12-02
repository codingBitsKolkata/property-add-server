package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.DiscountCategoryHostEntity;

@Repository
public class DiscountCategoryHostDAO extends GenericDAO<DiscountCategoryHostEntity, Long>{
	
	private static final long serialVersionUID = 2324954236102901285L;

	public DiscountCategoryHostDAO() {
		super(DiscountCategoryHostEntity.class);
	}
}
