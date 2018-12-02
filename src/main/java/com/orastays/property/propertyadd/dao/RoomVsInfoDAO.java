package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.RoomVsInfoEntity;

@Repository
public class RoomVsInfoDAO extends GenericDAO<RoomVsInfoEntity, Long>{

	private static final long serialVersionUID = -4041918638841158305L;

	public RoomVsInfoDAO() {
		super(RoomVsInfoEntity.class);
	}
}
