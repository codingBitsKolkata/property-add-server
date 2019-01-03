package com.orastays.property.propertyadd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orastays.property.propertyadd.helper.DbConnection;

@Repository
public class BaseDAO {

	@Autowired
	protected DbConnection dbConnection;
}
