package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.AmenitiesTypeEntity;

@Repository
public class AmenitiesTypeDAO extends GenericDAO<AmenitiesTypeEntity, Long> {

	private static final long serialVersionUID = 169737871391607836L;

	public AmenitiesTypeDAO() {
		super(AmenitiesTypeEntity.class);

	}
}
