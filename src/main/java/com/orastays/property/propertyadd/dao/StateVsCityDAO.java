package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.StateVsCityEntity;

@Repository
public class StateVsCityDAO extends GenericDAO<StateVsCityEntity, Long>{


	private static final long serialVersionUID = 1349708224691598471L;

	public StateVsCityDAO() {
		super(StateVsCityEntity.class);
	}
}
