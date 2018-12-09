package com.orastays.property.propertyadd.service;

import java.util.List;

import com.orastays.property.propertyadd.exceptions.FormExceptions;
import com.orastays.property.propertyadd.model.AccommodationModel;
import com.orastays.property.propertyadd.model.AmenitiesModel;
import com.orastays.property.propertyadd.model.AmenitiesTypeModel;
import com.orastays.property.propertyadd.model.CancellationSlabModel;
import com.orastays.property.propertyadd.model.CommonModel;
import com.orastays.property.propertyadd.model.PGCategorySexModel;
import com.orastays.property.propertyadd.model.PriceDropModel;
import com.orastays.property.propertyadd.model.PriceTypeModel;
import com.orastays.property.propertyadd.model.PropertyModel;
import com.orastays.property.propertyadd.model.PropertyTypeModel;
import com.orastays.property.propertyadd.model.RoomCategoryModel;
import com.orastays.property.propertyadd.model.SpaceRuleModel;
import com.orastays.property.propertyadd.model.SpecialExperienceModel;
import com.orastays.property.propertyadd.model.SpecialtiesModel;
import com.orastays.property.propertyadd.model.StayTypeModel;

public interface PropertyService {

	List<PropertyTypeModel> fetchPropertyTypes(CommonModel commonModel) throws FormExceptions;
	List<StayTypeModel> fetchStayTypeList(CommonModel commonModel) throws FormExceptions;
	List<AccommodationModel> fetchAccommodationByLanguage(CommonModel commonModel) throws FormExceptions;
	List<PGCategorySexModel> fetchPgCategorySexListByLanguage(CommonModel commonModel) throws FormExceptions;
	List<AmenitiesTypeModel> fetchAmenitiesTypeList() throws FormExceptions;
	List<AmenitiesModel> fetchAmenitiesList(CommonModel commonModel) throws FormExceptions;
	List<SpecialExperienceModel> fetchSpecialExperienceList(CommonModel commonModel) throws FormExceptions;
	List<SpaceRuleModel> fetchSpaceRuleList(CommonModel commonModel) throws FormExceptions;
	List<SpecialtiesModel> fetchSpecialtiesList(CommonModel commonModel) throws FormExceptions;
	List<RoomCategoryModel> fetchRoomCategoryList(CommonModel commonModel) throws FormExceptions;
	List<PriceTypeModel> fetchPriceTypeList(CommonModel commonModel) throws FormExceptions;
	List<CancellationSlabModel> fetchCancellationSlabList() throws FormExceptions;
	List<PriceDropModel> fetchPriceDropList() throws FormExceptions;
	PropertyModel saveProperty(PropertyModel propertyModel) throws FormExceptions;
	
}