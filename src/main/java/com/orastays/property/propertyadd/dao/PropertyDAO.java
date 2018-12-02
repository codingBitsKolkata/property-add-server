package com.orastays.property.propertyadd.dao;

import com.orastays.property.propertyadd.entity.PropertyEntity;

public class PropertyDAO extends GenericDAO<PropertyEntity, Long>{

	private static final long serialVersionUID = -7671486148453498082L;

	public PropertyDAO() {
		super(PropertyEntity.class);
	}
}
