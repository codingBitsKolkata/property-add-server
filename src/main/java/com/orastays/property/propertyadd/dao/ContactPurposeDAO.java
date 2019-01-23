package com.orastays.property.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.entity.ContactPurposeEntity;

@Repository
public class ContactPurposeDAO extends GenericDAO<ContactPurposeEntity, Long> {

	private static final long serialVersionUID = -244559235960090533L;

	public ContactPurposeDAO() {
		super(ContactPurposeEntity.class);
	}
}
