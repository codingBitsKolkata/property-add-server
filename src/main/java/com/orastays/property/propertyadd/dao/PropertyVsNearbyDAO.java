package com.orastays.property.propertyadd.dao;

import com.orastays.property.propertyadd.entity.PropertyVsNearbyEntity;

public class PropertyVsNearbyDAO extends GenericDAO<PropertyVsNearbyEntity, Long>{

	private static final long serialVersionUID = 8277658716493876351L;

	public PropertyVsNearbyDAO() {
		super(PropertyVsNearbyEntity.class);
	}
}
