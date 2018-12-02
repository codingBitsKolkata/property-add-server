package com.orastays.property.propertyadd.dao;

import com.orastays.property.propertyadd.entity.PriceDropEntity;

public class PriceDropDAO extends GenericDAO<PriceDropEntity, Long>{

	private static final long serialVersionUID = -7008495150227852367L;

	public PriceDropDAO() {
		super(PriceDropEntity.class);
	}
}
