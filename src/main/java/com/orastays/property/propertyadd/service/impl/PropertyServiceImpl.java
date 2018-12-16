package com.orastays.property.propertyadd.service.impl;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orastays.property.propertyadd.entity.DiscountCategoryOraEntity;
import com.orastays.property.propertyadd.entity.PropertyEntity;
import com.orastays.property.propertyadd.entity.PropertyVsDescriptionEntity;
import com.orastays.property.propertyadd.entity.PropertyVsDocumentEntity;
import com.orastays.property.propertyadd.entity.PropertyVsGuestAccessEntity;
import com.orastays.property.propertyadd.entity.PropertyVsImageEntity;
import com.orastays.property.propertyadd.entity.PropertyVsNearbyEntity;
import com.orastays.property.propertyadd.entity.PropertyVsPriceDropEntity;
import com.orastays.property.propertyadd.entity.PropertyVsSpaceRuleEntity;
import com.orastays.property.propertyadd.entity.PropertyVsSpecialExperienceEntity;
import com.orastays.property.propertyadd.entity.RoomEntity;
import com.orastays.property.propertyadd.entity.RoomVsAmenitiesEntity;
import com.orastays.property.propertyadd.entity.RoomVsCancellationEntity;
import com.orastays.property.propertyadd.entity.RoomVsHostDiscountEntity;
import com.orastays.property.propertyadd.entity.RoomVsImageEntity;
import com.orastays.property.propertyadd.entity.RoomVsMealEntity;
import com.orastays.property.propertyadd.entity.RoomVsOraDiscountEntity;
import com.orastays.property.propertyadd.entity.RoomVsOraPricePercentageEntity;
import com.orastays.property.propertyadd.entity.RoomVsPriceEntity;
import com.orastays.property.propertyadd.entity.RoomVsSpecialitiesEntity;
import com.orastays.property.propertyadd.entity.UserVsAccountEntity;
import com.orastays.property.propertyadd.exceptions.FormExceptions;
import com.orastays.property.propertyadd.helper.PropertyAddConstant;
import com.orastays.property.propertyadd.helper.Status;
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
import com.orastays.property.propertyadd.model.PropertyVsDescriptionModel;
import com.orastays.property.propertyadd.model.PropertyVsDocumentModel;
import com.orastays.property.propertyadd.model.PropertyVsGuestAccessModel;
import com.orastays.property.propertyadd.model.PropertyVsImageModel;
import com.orastays.property.propertyadd.model.PropertyVsNearbyModel;
import com.orastays.property.propertyadd.model.PropertyVsPriceDropModel;
import com.orastays.property.propertyadd.model.PropertyVsSpaceRuleModel;
import com.orastays.property.propertyadd.model.PropertyVsSpecialExperienceModel;
import com.orastays.property.propertyadd.model.RoomCategoryModel;
import com.orastays.property.propertyadd.model.RoomModel;
import com.orastays.property.propertyadd.model.RoomVsAmenitiesModel;
import com.orastays.property.propertyadd.model.RoomVsCancellationModel;
import com.orastays.property.propertyadd.model.RoomVsHostDiscountModel;
import com.orastays.property.propertyadd.model.RoomVsImageModel;
import com.orastays.property.propertyadd.model.RoomVsMealModel;
import com.orastays.property.propertyadd.model.RoomVsOraDiscountModel;
import com.orastays.property.propertyadd.model.RoomVsOrapricePercModel;
import com.orastays.property.propertyadd.model.RoomVsPriceModel;
import com.orastays.property.propertyadd.model.RoomVsSpecialitiesModel;
import com.orastays.property.propertyadd.model.SpaceRuleModel;
import com.orastays.property.propertyadd.model.SpecialExperienceModel;
import com.orastays.property.propertyadd.model.SpecialtiesModel;
import com.orastays.property.propertyadd.model.StayTypeModel;
import com.orastays.property.propertyadd.service.PropertyService;

@Service
@Transactional
public class PropertyServiceImpl extends BaseServiceImpl implements PropertyService {

	private static final Logger logger = LogManager.getLogger(PropertyServiceImpl.class);
	
	@Override
	public List<PropertyTypeModel> fetchPropertyTypes(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyTypes -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel,"Fetch Property Type");
		List<PropertyTypeModel> propertyTypeModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".PropertyTypeEntity", outerMap1);
			
			propertyTypeModels = propertyTypeConverter.entityListToModelList(propertyTypeDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyTypes -- END");
		}
		
		return propertyTypeModels;
	}
	
	@Override
	public List<StayTypeModel> fetchStayTypeList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchStayTypeList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel,"Fetch Stay Type");
		List<StayTypeModel> stayTypeModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".StayTypeEntity", outerMap1);
	
			stayTypeModels = stayTypeConverter.entityListToModelList(stayTypeDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchStayTypeList -- END");
		}
		
		return stayTypeModels;
	}
	
	@Override
	public List<AccommodationModel> fetchAccommodationByLanguage(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAccommodationByLanguage -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel,"Fetch Accomodation");
		List<AccommodationModel> accommodationModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".AccommodationEntity", outerMap1);
	
			accommodationModels = accommodationConverter.entityListToModelList(accommodationDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAccommodationByLanguage -- END");
		}
		
		return accommodationModels;
	}
	
	@Override
	public List<PGCategorySexModel> fetchPgCategorySexListByLanguage(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPgCategorySexListByLanguage -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel,"Fetch PG Category Sex");
		List<PGCategorySexModel> pgCategorySexModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".PGCategorySexEntity", outerMap1);
	
			pgCategorySexModels = pgCategorySexConverter.entityListToModelList(pgCategorySexDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPgCategorySexListByLanguage -- END");
		}
		
		return pgCategorySexModels;
	}
	
	@Override
	public List<AmenitiesTypeModel> fetchAmenitiesTypeList() throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesTypeList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(null,"Fetch Amenities Type");
		List<AmenitiesTypeModel> amenitiesTypeModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".AmenitiesTypeEntity", outerMap1);
	
			amenitiesTypeModels = amenitiesTypeConverter.entityListToModelList(amenitiesTypeDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesTypeList -- END");
		}
		
		return amenitiesTypeModels;
	}
	
	@Override
	public List<AmenitiesModel> fetchAmenitiesList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel,"Fetch Amenities List");
		List<AmenitiesModel> amenitiesModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".AmenitiesEntity", outerMap1);
	
			amenitiesModels = amenitiesConverter.entityListToModelList(amenitiesDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesList -- END");
		}
		
		return amenitiesModels;
	}
	
	@Override
	public List<SpecialExperienceModel> fetchSpecialExperienceList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpecialExperienceList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel,"Fetch Special Experience");
		List<SpecialExperienceModel> specialExperienceModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".SpecialExperienceEntity", outerMap1);
	
			specialExperienceModels = specialExperienceConverter.entityListToModelList(specialExperienceDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpecialExperienceList -- END");
		}
		
		return specialExperienceModels;
	}
	
	@Override
	public List<SpaceRuleModel> fetchSpaceRuleList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpaceRuleList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel,"Fetch Space Rule");
		List<SpaceRuleModel> spaceRuleModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".SpaceRuleEntity", outerMap1);
	
			spaceRuleModels = spaceRuleConverter.entityListToModelList(spaceRuleDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpaceRuleList -- END");
		}
		
		return spaceRuleModels;
	}
	
	@Override
	public List<SpecialtiesModel> fetchSpecialtiesList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpecialtiesList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel,"Fetch Specialties");
		List<SpecialtiesModel> specialtiesModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".SpecialtiesEntity", outerMap1);
	
			specialtiesModels = specialtiesConverter.entityListToModelList(specialtiesDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpecialtiesList -- END");
		}
		
		return specialtiesModels;
	}
	
	@Override
	public List<RoomCategoryModel> fetchRoomCategoryList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchRoomCategoryList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel,"Fetch Room Category");
		List<RoomCategoryModel> roomCategoryModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".RoomCategoryEntity", outerMap1);
	
			roomCategoryModels = roomCategoryConverter.entityListToModelList(roomCategoryDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchRoomCategoryList -- END");
		}
		
		return roomCategoryModels;
	}
	
	@Override
	public List<PriceTypeModel> fetchPriceTypeList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPriceTypeList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel,"Fetch Price Type");
		List<PriceTypeModel> priceTypeModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".PriceTypeEntity", outerMap1);
	
			priceTypeModels = priceTypeConverter.entityListToModelList(priceTypeDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPriceTypeList -- END");
		}
		
		return priceTypeModels;
	}
	
	@Override
	public List<CancellationSlabModel> fetchCancellationSlabList() throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchCancellationSlabList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(null,"Fetch Cancellation Slab");
		List<CancellationSlabModel> cancellationSlabModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".CancellationSlabEntity", outerMap1);
	
			cancellationSlabModels = cancellationSlabConverter.entityListToModelList(cancellationSlabDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchCancellationSlabList -- END");
		}
		
		return cancellationSlabModels;
	}
	
	@Override
	public List<PriceDropModel> fetchPriceDropList() throws FormExceptions{
		
		if (logger.isDebugEnabled()) {
			logger.debug("fetchPriceDropList -- Start");
		}
		
		List<PriceDropModel> priceDropModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".PriceDropEntity", outerMap1);
	
			priceDropModels = priceDropConverter.entityListToModelList(priceDropDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("fetchPriceDropList -- End");
		}
		
		return priceDropModels;
	}

	@Override
	public PropertyModel saveProperty(PropertyModel propertyModel) throws FormExceptions {
		
		propertyValidation.validatePropertyAdd(propertyModel);
		
		// User vs Account
		UserVsAccountEntity userVsAccountEntity = userVsAccountConverter.modelToEntity(propertyModel.getUserVsAccountModel());
		userVsAccountDAO.save(userVsAccountEntity);
		
		//Property
		PropertyEntity propertyEntity = propertyConverter.modelToEntity(propertyModel);
		propertyEntity.setUserVsAccountEntity(userVsAccountEntity);
		propertyDAO.save(propertyEntity);
		
		//Property Vs Description
		for(PropertyVsDescriptionModel propertyVsDescriptionModel:propertyModel.getPropertyVsDescriptionModels()){
			PropertyVsDescriptionEntity propertyVsDescriptionEntity = new PropertyVsDescriptionEntity();
			propertyVsDescriptionEntity = propertyVsDescriptionConverter.modelToEntity(propertyVsDescriptionModel);
			propertyVsDescriptionEntity.setPropertyEntity(propertyEntity);			
			propertyVsDescriptionDAO.save(propertyVsDescriptionEntity);
		}
		
		//Property Vs Document
		for(PropertyVsDocumentModel propertyvsDocumentModel:propertyModel.getPropertyVsDocumentModels()){
			PropertyVsDocumentEntity propertyVsDocumentEntity = new PropertyVsDocumentEntity();
			propertyVsDocumentEntity = propertyVsDocumentConverter.modelToEntity(propertyvsDocumentModel);
			propertyVsDocumentEntity.setPropertyEntity(propertyEntity);
			propertyVsDocumentDAO.save(propertyVsDocumentEntity);
		}
		
		//Property Vs Special Experience
		for(PropertyVsSpecialExperienceModel specialExperienceModel:propertyModel.getPropertyVsSpecialExperienceModels()){
			PropertyVsSpecialExperienceEntity propertyVsSpecialExperienceEntity = new PropertyVsSpecialExperienceEntity();
			propertyVsSpecialExperienceEntity = pVsSpecialExperienceConverter.modelToEntity(specialExperienceModel);
			propertyVsSpecialExperienceEntity.setPropertyEntity(propertyEntity);
			propertyVsSpecialExperienceDAO.save(propertyVsSpecialExperienceEntity);
		}
		
		//Property Vs Guest Access
		for(PropertyVsGuestAccessModel guestAccessModel:propertyModel.getPropertyVsGuestAccessModels()){
			PropertyVsGuestAccessEntity propertyVsGuestAccessEntity = new PropertyVsGuestAccessEntity();
			propertyVsGuestAccessEntity = propertyVsGuestAccessConverter.modelToEntity(guestAccessModel);
			propertyVsGuestAccessEntity.setPropertyEntity(propertyEntity);
			propertyVsGuestAccessDAO.save(propertyVsGuestAccessEntity);
		}
		
		//Property Vs Image 
		for(PropertyVsImageModel propertyVsImageModel:propertyModel.getPropertyVsImageModels()){
			PropertyVsImageEntity propertyVsImageEntity = new PropertyVsImageEntity();
			propertyVsImageEntity = propertyVsImageConverter.modelToEntity(propertyVsImageModel);
			propertyVsImageEntity.setPropertyEntity(propertyEntity);
			propertyVsImageDAO.save(propertyVsImageEntity);
		}
		
		//Property Vs NearBy
		for(PropertyVsNearbyModel propertyVsNearbyModel:propertyModel.getPropertyVsNearbyModels()){
			PropertyVsNearbyEntity propertyVsNearbyEntity = new PropertyVsNearbyEntity();
			propertyVsNearbyEntity = propertyVsNearbyConverter.modelToEntity(propertyVsNearbyModel);
			propertyVsNearbyEntity.setPropertyEntity(propertyEntity);
			propertyVsNearbyDAO.save(propertyVsNearbyEntity);
		}
		
		//Property Vs PriceDrop
		if(propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_Y)){
			List<PriceDropModel> priceDropModels = fetchPriceDropList();
			for(PriceDropModel priceDropModel:priceDropModels){
				PropertyVsPriceDropEntity propertyVsPriceDropEntity = new PropertyVsPriceDropEntity();
				PropertyVsPriceDropModel propertyVsPriceDropModel = new PropertyVsPriceDropModel();
				propertyVsPriceDropModel.setPriceDropModel(priceDropModel);
				propertyVsPriceDropModel.setPercentage(PropertyAddConstant.STR_ZERO);
				propertyVsPriceDropEntity = propertyVsPriceDropConverter.modelToEntity(propertyVsPriceDropModel);
				propertyVsPriceDropEntity.setPropertyEntity(propertyEntity);
				propertyVsPriceDropDAO.save(propertyVsPriceDropEntity);
			}
		}
		
		//Property Vs SpaceRule
		for(PropertyVsSpaceRuleModel propertyVsSpaceRuleModel:propertyModel.getPropertyVsSpaceRuleModels()){
			PropertyVsSpaceRuleEntity propertyVsSpaceRuleEntity = new PropertyVsSpaceRuleEntity();
			propertyVsSpaceRuleEntity = propertyVsSpaceRuleConverter.modelToEntity(propertyVsSpaceRuleModel);
			propertyVsSpaceRuleEntity.setPropertyEntity(propertyEntity);
			propertyVsSpaceRuleDAO.save(propertyVsSpaceRuleEntity);
		}
		
		///////////////// Room Data Insert Code ///////////////////////////
		//Room 
		for(RoomModel roomModel:propertyModel.getRoomModels()){
			RoomEntity roomEntity = new RoomEntity();
			roomEntity = roomConverter.modelToEntity(roomModel);
			roomEntity.setPropertyEntity(propertyEntity);
			roomDAO.save(roomEntity);
			
			//Room vs Amenities
			for(RoomVsAmenitiesModel roomVsAmenitiesModel:roomModel.getRoomVsAmenitiesModels()){
				RoomVsAmenitiesEntity roomVsAmenitiesEntity = new RoomVsAmenitiesEntity();
				roomVsAmenitiesEntity = roomVsAmenitiesConverter.modelToEntity(roomVsAmenitiesModel);
				roomVsAmenitiesEntity.setRoomEntity(roomEntity);
				roomVsAmenitiesDAO.save(roomVsAmenitiesEntity);
			}
			
			//Room Vs Image
			for(RoomVsImageModel roomVsImageModel:roomModel.getRoomVsImageModels()){
				RoomVsImageEntity roomVsImageEntity = new RoomVsImageEntity();
				roomVsImageEntity = roomVsImageConverter.modelToEntity(roomVsImageModel);
				roomVsImageEntity.setRoomEntity(roomEntity);
				roomVsImageDAO.save(roomVsImageEntity);
			}
			
			//Room Vs Host Discount
			for(RoomVsHostDiscountModel roomVsHostDiscountModel:roomModel.getRoomVsHostDiscountModels()){
				RoomVsHostDiscountEntity roomVsHostDiscountEntity = new RoomVsHostDiscountEntity();
				roomVsHostDiscountEntity = roomVsHostDiscountConverter.modelToEntity(roomVsHostDiscountModel);
				roomVsHostDiscountEntity.setRoomEntity(roomEntity);
				roomVsHostDiscountDAO.save(roomVsHostDiscountEntity);
			}
			
			//Room Vs Ora Discount
			RoomVsOraDiscountEntity roomVsOraDiscountEntity = new RoomVsOraDiscountEntity();
			DiscountCategoryOraEntity discountCategoryOraEntity= discountCategoryOraDAO.find(Long.valueOf(1));
			roomVsOraDiscountEntity.setDiscountCategoryOraEntity(discountCategoryOraEntity);
			roomVsOraDiscountEntity.setRoomEntity(roomEntity);
			roomVsOraDiscountEntity.setDiscount(PropertyAddConstant.STR_ZERO);
			roomVsOraDiscountDAO.save(roomVsOraDiscountEntity);
			
			//Room Vs Ora Price Percentage
			RoomVsOraPricePercentageEntity roomVsOraPricePercentageEntity = new RoomVsOraPricePercentageEntity();
			roomVsOraPricePercentageEntity.setPercentage(PropertyAddConstant.STR_ZERO);
			roomVsOraPricePercentageEntity.setRoomEntity(roomEntity);
			roomVsOraPricePercentageDAO.save(roomVsOraPricePercentageEntity);
			
			// Room Vs Price
			for(RoomVsPriceModel roomVsPriceModel:roomModel.getRoomVsPriceModels()){
				RoomVsPriceEntity roomVsPriceEntity = new RoomVsPriceEntity();
				roomVsPriceEntity = roomVsPriceConverter.modelToEntity(roomVsPriceModel);
				roomVsPriceEntity.setRoomEntity(roomEntity);
				roomVsPriceDAO.save(roomVsPriceEntity);
			}
			
			// Room vs Specilities
			for(RoomVsSpecialitiesModel roomVsSpecialitiesModel:roomModel.getRoomVsSpecialitiesModels()){
				RoomVsSpecialitiesEntity roomVsSpecialitiesEntity = new RoomVsSpecialitiesEntity();
				roomVsSpecialitiesEntity = roomVsSpecialitiesConverter.modelToEntity(roomVsSpecialitiesModel);
				roomVsSpecialitiesEntity.setRoomEntity(roomEntity);
				roomVsSpecialitiesDAO.save(roomVsSpecialitiesEntity);
			}
			
			//Room Vs Meal
			for(RoomVsMealModel roomVsMeal:roomModel.getRoomVsMealModels()){
				RoomVsMealEntity roomVsMealEntity = new RoomVsMealEntity();
				roomVsMealEntity = roomVsMealConverter.modelToEntity(roomVsMeal);
				roomVsMealEntity.setRoomEntity(roomEntity);
				roomVsMealDAO.save(roomVsMealEntity);
			}
			
			//Room vs Cancellation
			for(RoomVsCancellationModel roomVsCancellationModel:roomModel.getRoomVsCancellationModels()){
				RoomVsCancellationEntity roomVsCancellationEntity = new RoomVsCancellationEntity();
				roomVsCancellationEntity = roomVsCancellationConverter.modelToEntity(roomVsCancellationModel);
				roomVsCancellationEntity.setRoomEntity(roomEntity);
				roomVsCancellationDAO.save(roomVsCancellationEntity);
			}
		}
		
		
		
		return propertyModel;
	}
}
