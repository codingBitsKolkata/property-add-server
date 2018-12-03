package com.orastays.property.propertyadd.service;

import java.util.List;

import com.orastays.property.propertyadd.model.PropertyTypeModel;

public interface PropertyService {

	List<PropertyTypeModel> fetchAllPropertyTypeByLanguage(String languageId);
}