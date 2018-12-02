package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.RoomVsPriceEntity;

@Repository
public class RoomVsPriceDAO extends GenericDAO<RoomVsPriceEntity, Long>{

	private static final long serialVersionUID = -4292513296439901249L;

	public RoomVsPriceDAO() {
		super(RoomVsPriceEntity.class);
	}
}
