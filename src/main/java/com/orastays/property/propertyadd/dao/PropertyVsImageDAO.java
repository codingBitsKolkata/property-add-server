package com.orastays.property.propertyadd.dao;

import com.orastays.property.propertyadd.entity.PropertyVsImageEntity;

public class PropertyVsImageDAO extends GenericDAO<PropertyVsImageEntity, Long>{

	private static final long serialVersionUID = 6621661402386620619L;

	public PropertyVsImageDAO() {
		super(PropertyVsImageEntity.class);
	}
}
