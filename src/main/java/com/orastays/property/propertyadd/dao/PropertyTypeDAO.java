package com.orastays.property.propertyadd.dao;

import com.orastays.property.propertyadd.entity.PropertyTypeEntity;

public class PropertyTypeDAO extends GenericDAO<PropertyTypeEntity, Long>{

	private static final long serialVersionUID = 484373964101928009L;

	public PropertyTypeDAO() {
		super(PropertyTypeEntity.class);
	}
}
