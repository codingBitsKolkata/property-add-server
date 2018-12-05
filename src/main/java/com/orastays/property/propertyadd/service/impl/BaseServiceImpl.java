package com.orastays.property.propertyadd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.orastays.property.propertyadd.converter.AccommodationConverter;
import com.orastays.property.propertyadd.converter.PropertyTypeConverter;
import com.orastays.property.propertyadd.converter.StayTypeConverter;
import com.orastays.property.propertyadd.dao.AccommodationDAO;
import com.orastays.property.propertyadd.dao.PropertyTypeDAO;
import com.orastays.property.propertyadd.dao.StayTypeDAO;
import com.orastays.property.propertyadd.validation.PropertyValidation;

public abstract class BaseServiceImpl {

	@Value("${entitymanager.packagesToScan}")
	protected String entitymanagerPackagesToScan;
	
	@Autowired
	protected PropertyValidation propertyValidation;
	
	@Autowired
	protected PropertyTypeDAO propertyTypeDAO;
	
	@Autowired
	protected PropertyTypeConverter propertyTypeConverter;
	
	@Autowired
	protected StayTypeConverter stayTypeConverter;
	
	@Autowired
	protected StayTypeDAO stayTypeDAO;
	
	@Autowired
	protected AccommodationConverter accommodationConverter;
	
	@Autowired
	protected AccommodationDAO accommodationDAO;
}
