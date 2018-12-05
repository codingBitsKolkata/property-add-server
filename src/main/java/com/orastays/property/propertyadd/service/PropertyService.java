package com.orastays.property.propertyadd.service;

import java.util.List;

import com.orastays.property.propertyadd.exceptions.FormExceptions;
import com.orastays.property.propertyadd.model.AccommodationModel;
import com.orastays.property.propertyadd.model.CommonModel;
import com.orastays.property.propertyadd.model.PropertyTypeModel;
import com.orastays.property.propertyadd.model.StayTypeModel;

public interface PropertyService {

	List<PropertyTypeModel> fetchPropertyTypes(CommonModel commonModel) throws FormExceptions;
	List<StayTypeModel> fetchStayTypeList(String languageId);
	List<AccommodationModel> fetchAllAccommodationTypeByLanguage(String languageId);
}