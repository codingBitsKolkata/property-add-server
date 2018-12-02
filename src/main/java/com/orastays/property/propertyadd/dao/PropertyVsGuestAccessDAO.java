package com.orastays.property.propertyadd.dao;

import com.orastays.property.propertyadd.entity.PropertyVsGuestAccessEntity;

public class PropertyVsGuestAccessDAO extends GenericDAO<PropertyVsGuestAccessEntity, Long>{

	private static final long serialVersionUID = -204920984856521903L;

	public PropertyVsGuestAccessDAO() {
		super(PropertyVsGuestAccessEntity.class);
	}
}
