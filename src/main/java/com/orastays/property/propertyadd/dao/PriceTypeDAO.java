package com.orastays.property.propertyadd.dao;

import com.orastays.property.propertyadd.entity.PriceTypeEntity;

public class PriceTypeDAO extends GenericDAO<PriceTypeEntity, Long>{

	private static final long serialVersionUID = -5065952725512145982L;

	public PriceTypeDAO() {
		super(PriceTypeEntity.class);
	}
}
