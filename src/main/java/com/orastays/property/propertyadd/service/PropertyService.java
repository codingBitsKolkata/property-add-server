package com.orastays.property.propertyadd.service;

import java.util.List;

import com.orastays.property.propertyadd.exceptions.FormExceptions;
import com.orastays.property.propertyadd.model.AmenitiesModel;
import com.orastays.property.propertyadd.model.CancellationSlabModel;
import com.orastays.property.propertyadd.model.CommonModel;
import com.orastays.property.propertyadd.model.ImageUpload;
import com.orastays.property.propertyadd.model.PriceDropModel;
import com.orastays.property.propertyadd.model.PropertyModel;
import com.orastays.property.propertyadd.model.PropertyTypeModel;
import com.orastays.property.propertyadd.model.RoomCategoryModel;
import com.orastays.property.propertyadd.model.SpaceRuleModel;
import com.orastays.property.propertyadd.model.SpecialExperienceModel;
import com.orastays.property.propertyadd.model.SpecialtiesModel;
import com.orastays.property.propertyadd.model.StayTypeModel;
import com.orastays.property.propertyadd.model.booking.BookingModel;
import com.orastays.property.propertyadd.model.booking.CancellationModel;

public interface PropertyService {

	List<PropertyTypeModel> fetchPropertyTypes() throws FormExceptions;
	List<StayTypeModel> fetchStayTypeList(CommonModel commonModel) throws FormExceptions;
	List<String> fetchAccommodationByLanguage(CommonModel commonModel) throws FormExceptions;
	List<String> fetchPgCategorySexListByLanguage(CommonModel commonModel) throws FormExceptions;
	List<String> fetchAmenitiesTypeList(CommonModel commonModel) throws FormExceptions;
	List<AmenitiesModel> fetchAmenitiesList(CommonModel commonModel) throws FormExceptions;
	List<SpecialExperienceModel> fetchSpecialExperienceList(CommonModel commonModel) throws FormExceptions;
	List<SpaceRuleModel> fetchSpaceRuleList(CommonModel commonModel) throws FormExceptions;
	List<SpecialtiesModel> fetchSpecialtiesList(CommonModel commonModel) throws FormExceptions;
	List<RoomCategoryModel> fetchRoomCategoryList(CommonModel commonModel) throws FormExceptions;
	List<CancellationSlabModel> fetchCancellationSlabList() throws FormExceptions;
	List<PriceDropModel> fetchPriceDropList() throws FormExceptions;
	void saveProperty(PropertyModel propertyModel) throws FormExceptions;
	List<PropertyModel> fetchActivePropertyList(CommonModel commonModel) throws FormExceptions;
	PropertyModel fetchPropertyById(PropertyModel propertyModel) throws FormExceptions;
	void updateProperty(PropertyModel propertyModel) throws FormExceptions;
	List<BookingModel> viewPropertyBookingList(PropertyModel propertyModel) throws FormExceptions;
	List<BookingModel> viewUserBookingList(CommonModel commonModel) throws FormExceptions;
	List<CancellationModel> viewPropertyCancellationList(BookingModel bookingModel) throws FormExceptions;
	List<CancellationModel> viewUserCancellationList(BookingModel bookingModel) throws FormExceptions;
	List<AmenitiesModel> fetchAmenitiesForFilter() throws FormExceptions;
	void uploadImageByAzure(ImageUpload imageUpload); 
}