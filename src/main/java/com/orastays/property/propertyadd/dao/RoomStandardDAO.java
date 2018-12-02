package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.RoomStandardEntity;

@Repository
public class RoomStandardDAO extends GenericDAO<RoomStandardEntity, Long>{

	private static final long serialVersionUID = -911289984806899894L;

	public RoomStandardDAO() {
		super(RoomStandardEntity.class);
	}
}
