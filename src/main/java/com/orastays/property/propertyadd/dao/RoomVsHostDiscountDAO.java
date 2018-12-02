package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.RoomVsHostDiscountEntity;

@Repository
public class RoomVsHostDiscountDAO extends GenericDAO<RoomVsHostDiscountEntity, Long>{

	private static final long serialVersionUID = -2769761413488892581L;

	public RoomVsHostDiscountDAO() {
		super(RoomVsHostDiscountEntity.class);
	}
}
