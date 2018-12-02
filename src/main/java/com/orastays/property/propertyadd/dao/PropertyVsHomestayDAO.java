package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.PropertyVsHomestayEntity;

@Repository
public class PropertyVsHomestayDAO extends GenericDAO<PropertyVsHomestayEntity, Long>{

	private static final long serialVersionUID = 8537909831573776286L;

	public PropertyVsHomestayDAO() {
		super(PropertyVsHomestayEntity.class);
	}
}
