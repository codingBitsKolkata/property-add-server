package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.CountryEntity;

@Repository
public class CountryDAO extends GenericDAO<CountryEntity, Long>{

	private static final long serialVersionUID = -2499320089097062624L;

	public CountryDAO() {
		super(CountryEntity.class);
	}
}
