package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.PGCategorySexEntity;

@Repository
public class PGCategorySexDAO extends GenericDAO<PGCategorySexEntity, Long>{

	private static final long serialVersionUID = 813591451422499177L;

	public PGCategorySexDAO() {
		super(PGCategorySexEntity.class);
	}
}
