package com.orastays.property.propertyadd.service;

import java.util.List;

import com.orastays.property.propertyadd.exceptions.FormExceptions;
import com.orastays.property.propertyadd.model.AccommodationModel;
import com.orastays.property.propertyadd.model.AmenitiesModel;
import com.orastays.property.propertyadd.model.AmenitiesTypeModel;
import com.orastays.property.propertyadd.model.CancellationSlabModel;
import com.orastays.property.propertyadd.model.CommonModel;
import com.orastays.property.propertyadd.model.PGCategorySexModel;
import com.orastays.property.propertyadd.model.PriceTypeModel;
import com.orastays.property.propertyadd.model.PropertyTypeModel;
import com.orastays.property.propertyadd.model.RoomCategoryModel;
import com.orastays.property.propertyadd.model.SpaceRuleModel;
import com.orastays.property.propertyadd.model.SpecialExperienceModel;
import com.orastays.property.propertyadd.model.SpecialtiesModel;
import com.orastays.property.propertyadd.model.StayTypeModel;

public interface PropertyService {

	List<PropertyTypeModel> fetchPropertyTypes(CommonModel commonModel) throws FormExceptions;
	List<StayTypeModel> fetchStayTypeList(String languageId);
	List<AccommodationModel> fetchAccommodationByLanguage(String languageId);
	List<PGCategorySexModel> fetchPgCategorySexListByLanguage(String languageId);
	List<AmenitiesTypeModel> fetchAmenitiesTypeList();
	List<AmenitiesModel> fetchAmenitiesList(String languageId);
	List<SpecialExperienceModel> fetchSpecialExperienceList(String languageId);
	List<SpaceRuleModel> fetchSpaceRuleList(String languageId);
	List<SpecialtiesModel> fetchSpecialtiesList(String languageId);
	List<RoomCategoryModel> fetchRoomCategoryList(String languageId);
	List<PriceTypeModel> fetchPriceTypeList(String languageId);
	List<CancellationSlabModel> fetchCancellationSlabList();
}