package com.orastays.property.propertyadd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.orastays.property.propertyadd.converter.PropertyTypeConverter;
import com.orastays.property.propertyadd.dao.PropertyTypeDAO;

public abstract class BaseServiceImpl {

	@Value("${entitymanager.packagesToScan}")
	protected String entitymanagerPackagesToScan;
	
	@Autowired
	protected PropertyTypeDAO propertyTypeDAO;
	
	@Autowired
	protected PropertyTypeConverter propertyTypeConverter;
}
