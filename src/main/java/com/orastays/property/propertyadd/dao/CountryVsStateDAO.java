package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.CountryVsStateEntity;

@Repository
public class CountryVsStateDAO extends GenericDAO<CountryVsStateEntity, Long>{

	private static final long serialVersionUID = 4740229874513219167L;

	public CountryVsStateDAO() {
		super(CountryVsStateEntity.class);
	}
}
