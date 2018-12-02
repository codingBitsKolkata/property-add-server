package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.PropertyVsStayTypeEntity;

@Repository
public class PropertyVsStayTypeDAO extends GenericDAO<PropertyVsStayTypeEntity, Long>{

	private static final long serialVersionUID = -7212073762458870880L;

	public PropertyVsStayTypeDAO() {
		super(PropertyVsStayTypeEntity.class);
	}
}
