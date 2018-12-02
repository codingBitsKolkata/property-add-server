package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.PropertyVsPgcsEntity;

@Repository
public class PropertyVsPgcsDAO extends GenericDAO<PropertyVsPgcsEntity, Long>{

	private static final long serialVersionUID = -3138262702126933128L;

	public PropertyVsPgcsDAO() {
		super(PropertyVsPgcsEntity.class);
	}
}
