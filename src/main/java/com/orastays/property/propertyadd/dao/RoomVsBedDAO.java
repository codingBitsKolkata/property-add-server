package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.RoomVsBedEntity;

@Repository
public class RoomVsBedDAO extends GenericDAO<RoomVsBedEntity, Long>{

	private static final long serialVersionUID = 1255629871540161577L;

	public RoomVsBedDAO() {
		super(RoomVsBedEntity.class);
	}
}
