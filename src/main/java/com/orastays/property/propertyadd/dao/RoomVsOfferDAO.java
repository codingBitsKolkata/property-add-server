package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.RoomVsOfferEntity;

@Repository
public class RoomVsOfferDAO extends GenericDAO<RoomVsOfferEntity, Long> {

	private static final long serialVersionUID = -8551172866673213126L;

	public RoomVsOfferDAO() {
		super(RoomVsOfferEntity.class);
	}
}
