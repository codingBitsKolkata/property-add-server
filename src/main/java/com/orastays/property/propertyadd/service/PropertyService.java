package com.orastays.property.propertyadd.service;

import java.util.List;

import com.orastays.property.propertyadd.model.AccommodationModel;
import com.orastays.property.propertyadd.model.PropertyTypeModel;
import com.orastays.property.propertyadd.model.StayTypeModel;

public interface PropertyService {

	List<PropertyTypeModel> fetchAllPropertyTypeByLanguage(String languageId);
	List<StayTypeModel> fetchStayTypeList(String languageId);
	List<AccommodationModel> fetchAllAccommodationTypeByLanguage(String languageId);
}