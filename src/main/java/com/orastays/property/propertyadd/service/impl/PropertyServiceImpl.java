package com.orastays.property.propertyadd.service.impl;

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
import com.orastays.property.propertyadd.entity.RoomVsBedEntity;
import com.orastays.property.propertyadd.entity.RoomVsCancellationEntity;
import com.orastays.property.propertyadd.entity.RoomVsImageEntity;
import com.orastays.property.propertyadd.entity.RoomVsMealEntity;
import com.orastays.property.propertyadd.entity.RoomVsOraDiscountEntity;
import com.orastays.property.propertyadd.entity.RoomVsSpecialitiesEntity;
import com.orastays.property.propertyadd.entity.UserVsAccountEntity;
import com.orastays.property.propertyadd.exceptions.FormExceptions;
import com.orastays.property.propertyadd.helper.PropertyAddConstant;
import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.AccommodationModel;
import com.orastays.property.propertyadd.model.AmenitiesModel;
import com.orastays.property.propertyadd.model.AmenitiesTypeModel;
import com.orastays.property.propertyadd.model.BookingModel;
import com.orastays.property.propertyadd.model.CancellationModel;
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
import com.orastays.property.propertyadd.model.RoomVsBedModel;
import com.orastays.property.propertyadd.model.RoomVsCancellationModel;
import com.orastays.property.propertyadd.model.RoomVsImageModel;
import com.orastays.property.propertyadd.model.RoomVsMealModel;
import com.orastays.property.propertyadd.model.RoomVsOraDiscountModel;
import com.orastays.property.propertyadd.model.RoomVsSpecialitiesModel;
import com.orastays.property.propertyadd.model.SpaceRuleModel;
import com.orastays.property.propertyadd.model.SpecialExperienceModel;
import com.orastays.property.propertyadd.model.SpecialtiesModel;
import com.orastays.property.propertyadd.model.StayTypeModel;
import com.orastays.property.propertyadd.model.UserModel;
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
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
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
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchPropertyTypes -- "+Util.errorToString(e));
			}
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
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
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
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchStayTypeList -- "+Util.errorToString(e));
			}
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
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
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
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchAccommodationByLanguage -- "+Util.errorToString(e));
			}
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
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
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
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchPgCategorySexListByLanguage -- "+Util.errorToString(e));
			}
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
		
		propertyValidation.validateLanguageWithUserToken(null);
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
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchAmenitiesTypeList -- "+Util.errorToString(e));
			}
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
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
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
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchAmenitiesList -- "+Util.errorToString(e));
			}
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
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
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
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchSpecialExperienceList -- "+Util.errorToString(e));
			}
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
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
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
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchSpaceRuleList -- "+Util.errorToString(e));
			}
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
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
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
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchSpecialtiesList -- "+Util.errorToString(e));
			}
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
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
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
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchRoomCategoryList -- "+Util.errorToString(e));
			}
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
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
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
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchPriceTypeList -- "+Util.errorToString(e));
			}
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
		
		propertyValidation.validateLanguageWithUserToken(null);
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
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchCancellationSlabList -- "+Util.errorToString(e));
			}
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
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchPriceDropList -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("fetchPriceDropList -- End");
		}
		
		return priceDropModels;
	}

	@Override
	public void saveProperty(PropertyModel propertyModel) throws FormExceptions {
		
		if (logger.isDebugEnabled()) {
			logger.debug("saveProperty -- Start");
		}
		
		UserModel userModel = propertyValidation.validatePropertyAdd(propertyModel);
		Long userId = Long.valueOf(userModel.getUserId());
		// User vs Account
		propertyModel.getUserVsAccountModel().setCreatedBy(userId);
		propertyModel.getUserVsAccountModel().setUserId(userModel.getUserId());
		UserVsAccountEntity userVsAccountEntity = userVsAccountConverter.modelToEntity(propertyModel.getUserVsAccountModel());
		userVsAccountDAO.save(userVsAccountEntity);
		
		//Property
		propertyModel.setCreatedBy(userId);
		propertyModel.setAdvancePercentage(PropertyAddConstant.ADVPERCENTAGE);
		PropertyEntity propertyEntity = propertyConverter.modelToEntity(propertyModel);
		propertyEntity.setUserVsAccountEntity(userVsAccountEntity);
		propertyDAO.save(propertyEntity);
		
		//Property Vs Description
		for(PropertyVsDescriptionModel propertyVsDescriptionModel:propertyModel.getPropertyVsDescriptionModels()){
			propertyVsDescriptionModel.setCreatedBy(userId);
			PropertyVsDescriptionEntity propertyVsDescriptionEntity = propertyVsDescriptionConverter.modelToEntity(propertyVsDescriptionModel);
			propertyVsDescriptionEntity.setPropertyEntity(propertyEntity);			
			propertyVsDescriptionDAO.save(propertyVsDescriptionEntity);
		}
		
		//Property Vs Document
		for(PropertyVsDocumentModel propertyvsDocumentModel:propertyModel.getPropertyVsDocumentModels()){
			propertyvsDocumentModel.setCreatedBy(userId);
			PropertyVsDocumentEntity propertyVsDocumentEntity = propertyVsDocumentConverter.modelToEntity(propertyvsDocumentModel);
			propertyVsDocumentEntity.setPropertyEntity(propertyEntity);
			propertyVsDocumentDAO.save(propertyVsDocumentEntity);
		}
		
		//Property Vs Special Experience
		for(PropertyVsSpecialExperienceModel specialExperienceModel:propertyModel.getPropertyVsSpecialExperienceModels()){
			specialExperienceModel.setCreatedBy(userId);
			PropertyVsSpecialExperienceEntity propertyVsSpecialExperienceEntity = pVsSpecialExperienceConverter.modelToEntity(specialExperienceModel);
			propertyVsSpecialExperienceEntity.setPropertyEntity(propertyEntity);
			propertyVsSpecialExperienceDAO.save(propertyVsSpecialExperienceEntity);
		}
		
		//Property Vs Guest Access
		for(PropertyVsGuestAccessModel guestAccessModel:propertyModel.getPropertyVsGuestAccessModels()){
			guestAccessModel.setCreatedBy(userId);
			PropertyVsGuestAccessEntity propertyVsGuestAccessEntity = propertyVsGuestAccessConverter.modelToEntity(guestAccessModel);
			propertyVsGuestAccessEntity.setPropertyEntity(propertyEntity);
			propertyVsGuestAccessDAO.save(propertyVsGuestAccessEntity);
		}
		
		//Property Vs Image 
		for(PropertyVsImageModel propertyVsImageModel:propertyModel.getPropertyVsImageModels()){
			propertyVsImageModel.setCreatedBy(userId);
			PropertyVsImageEntity propertyVsImageEntity = propertyVsImageConverter.modelToEntity(propertyVsImageModel);
			propertyVsImageEntity.setPropertyEntity(propertyEntity);
			propertyVsImageDAO.save(propertyVsImageEntity);
		}
		
		//Property Vs NearBy
		for(PropertyVsNearbyModel propertyVsNearbyModel:propertyModel.getPropertyVsNearbyModels()){
			propertyVsNearbyModel.setCreatedBy(userId);
			PropertyVsNearbyEntity propertyVsNearbyEntity = propertyVsNearbyConverter.modelToEntity(propertyVsNearbyModel);
			propertyVsNearbyEntity.setPropertyEntity(propertyEntity);
			propertyVsNearbyDAO.save(propertyVsNearbyEntity);
		}
		
		//Property Vs PriceDrop
		if(propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_Y)){
			List<PriceDropModel> priceDropModels = fetchPriceDropList();
			for(PriceDropModel priceDropModel:priceDropModels){
				PropertyVsPriceDropModel propertyVsPriceDropModel = new PropertyVsPriceDropModel();
				propertyVsPriceDropModel.setPriceDropModel(priceDropModel);
				propertyVsPriceDropModel.setPercentage(PropertyAddConstant.STR_ZERO);
				propertyVsPriceDropModel.setCreatedBy(userId);
				PropertyVsPriceDropEntity propertyVsPriceDropEntity = propertyVsPriceDropConverter.modelToEntity(propertyVsPriceDropModel);
				propertyVsPriceDropEntity.setPropertyEntity(propertyEntity);
				propertyVsPriceDropDAO.save(propertyVsPriceDropEntity);
			}
		}
		
		//Property Vs SpaceRule
		for(PropertyVsSpaceRuleModel propertyVsSpaceRuleModel:propertyModel.getPropertyVsSpaceRuleModels()){
			propertyVsSpaceRuleModel.setCreatedBy(userId);
			PropertyVsSpaceRuleEntity propertyVsSpaceRuleEntity = propertyVsSpaceRuleConverter.modelToEntity(propertyVsSpaceRuleModel);
			propertyVsSpaceRuleEntity.setPropertyEntity(propertyEntity);
			propertyVsSpaceRuleDAO.save(propertyVsSpaceRuleEntity);
		}
		
		///////////////// Room Data Insert Code ///////////////////////////
		//Room 
		for(RoomModel roomModel:propertyModel.getRoomModels()){
			roomModel.setCreatedBy(userId);
			roomModel.setOraPercentage(PropertyAddConstant.STR_ZERO);
			RoomEntity roomEntity = roomConverter.modelToEntity(roomModel);
			roomEntity.setPropertyEntity(propertyEntity);
			roomDAO.save(roomEntity);
			
			//Room vs Amenities
			for(RoomVsAmenitiesModel roomVsAmenitiesModel:roomModel.getRoomVsAmenitiesModels()){
				roomVsAmenitiesModel.setCreatedBy(userId);
				RoomVsAmenitiesEntity roomVsAmenitiesEntity = roomVsAmenitiesConverter.modelToEntity(roomVsAmenitiesModel);
				roomVsAmenitiesEntity.setRoomEntity(roomEntity);
				roomVsAmenitiesDAO.save(roomVsAmenitiesEntity);
			}
			
			//Room Vs Image
			for(RoomVsImageModel roomVsImageModel:roomModel.getRoomVsImageModels()){
				roomVsImageModel.setCreatedBy(userId);
				RoomVsImageEntity roomVsImageEntity = roomVsImageConverter.modelToEntity(roomVsImageModel);
				roomVsImageEntity.setRoomEntity(roomEntity);
				roomVsImageDAO.save(roomVsImageEntity);
			}
			
		
			//Room Vs Host Discount
			/*for(RoomVsHostDiscountModel roomVsHostDiscountModel:roomModel.getRoomVsHostDiscountModels()){
				roomVsHostDiscountModel.setCreatedBy(userId);
				RoomVsHostDiscountEntity roomVsHostDiscountEntity = roomVsHostDiscountConverter.modelToEntity(roomVsHostDiscountModel);
				roomVsHostDiscountEntity.setRoomEntity(roomEntity);
				roomVsHostDiscountDAO.save(roomVsHostDiscountEntity);
			}*/
			
			//Room Vs Ora Discount
			RoomVsOraDiscountEntity roomVsOraDiscountEntity = new RoomVsOraDiscountEntity();
			DiscountCategoryOraEntity discountCategoryOraEntity= discountCategoryOraDAO.find(Long.valueOf(1));
			roomVsOraDiscountEntity.setDiscountCategoryOraEntity(discountCategoryOraEntity);
			roomVsOraDiscountEntity.setRoomEntity(roomEntity);
			roomVsOraDiscountEntity.setDiscount(PropertyAddConstant.STR_ZERO);
			roomVsOraDiscountEntity.setCreatedBy(userId);
			roomVsOraDiscountDAO.save(roomVsOraDiscountEntity);
			
			//Room Vs Ora Price Percentage
			/*RoomVsOraPricePercentageEntity roomVsOraPricePercentageEntity = new RoomVsOraPricePercentageEntity();
			roomVsOraPricePercentageEntity.setPercentage(PropertyAddConstant.STR_ZERO);
			roomVsOraPricePercentageEntity.setRoomEntity(roomEntity);
			roomVsOraPricePercentageEntity.setCreatedBy(userId);
			roomVsOraPricePercentageDAO.save(roomVsOraPricePercentageEntity);*/
			
			// Room Vs Price
			/*for(RoomVsPriceModel roomVsPriceModel:roomModel.getRoomVsPriceModels()){
				roomVsPriceModel.setCreatedBy(userId);
				RoomVsPriceEntity roomVsPriceEntity = roomVsPriceConverter.modelToEntity(roomVsPriceModel);
				roomVsPriceEntity.setRoomEntity(roomEntity);
				roomVsPriceDAO.save(roomVsPriceEntity);
			}*/
			
			// Room vs Specilities
			for(RoomVsSpecialitiesModel roomVsSpecialitiesModel:roomModel.getRoomVsSpecialitiesModels()){
				roomVsSpecialitiesModel.setCreatedBy(userId);
				RoomVsSpecialitiesEntity roomVsSpecialitiesEntity = roomVsSpecialitiesConverter.modelToEntity(roomVsSpecialitiesModel);
				roomVsSpecialitiesEntity.setRoomEntity(roomEntity);
				roomVsSpecialitiesDAO.save(roomVsSpecialitiesEntity);
			}
			
			//Room Vs Meal
			for(RoomVsMealModel roomVsMeal:roomModel.getRoomVsMealModels()){
				roomVsMeal.setCreatedBy(userId);
				RoomVsMealEntity roomVsMealEntity = roomVsMealConverter.modelToEntity(roomVsMeal);
				roomVsMealEntity.setRoomEntity(roomEntity);
				roomVsMealDAO.save(roomVsMealEntity);
			}
			
			//Room vs Cancellation
			for(RoomVsCancellationModel roomVsCancellationModel:roomModel.getRoomVsCancellationModels()){
				roomVsCancellationModel.setCreatedBy(userId);
				RoomVsCancellationEntity roomVsCancellationEntity = roomVsCancellationConverter.modelToEntity(roomVsCancellationModel);
				roomVsCancellationEntity.setRoomEntity(roomEntity);
				roomVsCancellationDAO.save(roomVsCancellationEntity);
			}
			
			//// Room Vs Bed
			RoomVsBedModel roomVsBedModel = roomModel.getRoomVsBedModel();
			roomVsBedModel.setCreatedBy(userId);
			RoomVsBedEntity roomVsBedEntity = roomVsBedConverter.modelToEntity(roomVsBedModel);
			roomVsBedEntity.setRoomEntity(roomEntity);
			roomVsBedDAO.save(roomVsBedEntity);	
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("saveProperty -- End");
		}
	}

	@Override
	public List<PropertyModel> fetchActivePropertyList(CommonModel commonModel) throws FormExceptions {
			
			if (logger.isInfoEnabled()) {
				logger.info("fetchActivePropertyList -- START");
			}
			
			UserModel userModel = propertyValidation.validateUserToken(commonModel);
			List<PropertyModel> propertyModels = null;
			
			try {
				Map<String, String> innerMap1 = new LinkedHashMap<>();
				innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
				innerMap1.put(PropertyAddConstant.CREATEDBY, String.valueOf(userModel.getUserId()));
		
				Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
				outerMap1.put("eq", innerMap1);
		
				Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
				alliasMap.put(entitymanagerPackagesToScan+".PropertyEntity", outerMap1);
				
				propertyModels = propertyConverter.entityListToModelList(propertyDAO.fetchListBySubCiteria(alliasMap));

			} catch (Exception e) {
				if (logger.isInfoEnabled()) {
					logger.info("Exception in fetchActivePropertyList -- "+Util.errorToString(e));
				}
			}
			
			if (logger.isInfoEnabled()) {
				logger.info("fetchActivePropertyList -- END");
			}
			
		return propertyModels;
	}

	@Override
	public PropertyModel fetchPropertyById(PropertyModel propertyModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyById -- START");
		}
		
		propertyValidation.validateFetchPropertyById(propertyModel);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyById -- END");
		}
		
		return propertyConverter.entityToModel(propertyDAO.find(propertyModel.getPropertyId()));
	}
	
	@Override
	public void updateProperty(PropertyModel propertyModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("updateProperty -- START");
		}

		UserModel userModel = propertyValidation.validatePropertyUpdate(propertyModel);
		Long userId = Long.valueOf(userModel.getUserId());
		// User vs Account Delete
		
		UserVsAccountEntity userVsAccountEntity = userVsAccountDAO.find(propertyModel.getUserVsAccountModel().getUserVsAccountId());
		userVsAccountEntity.setModifiedDate(Util.getCurrentDateTime());
		userVsAccountEntity.setModifiedBy(userId);
		userVsAccountEntity.setStatus(Status.DELETE.ordinal());
		userVsAccountDAO.update(userVsAccountEntity);
		
		//Property Delete
		PropertyEntity propertyEntity = propertyDAO.find(propertyModel.getPropertyId());
		propertyEntity.setModifiedDate(Util.getCurrentDateTime());
		propertyEntity.setModifiedBy(userId);
		propertyEntity.setStatus(Status.DELETE.ordinal());
		propertyDAO.update(propertyEntity);
		
				//Property Vs Description Delete
				for(PropertyVsDescriptionModel propertyVsDescriptionModel:propertyModel.getPropertyVsDescriptionModels()){
					PropertyVsDescriptionEntity propertyVsDescriptionEntity = propertyVsDescriptionDAO.find(Long.valueOf(propertyVsDescriptionModel.getPropertyDescId()));
					propertyVsDescriptionEntity.setModifiedBy(userId);
					propertyVsDescriptionEntity.setModifiedDate(Util.getCurrentDateTime());
					propertyVsDescriptionEntity.setStatus(Status.DELETE.ordinal());
					propertyVsDescriptionDAO.update(propertyVsDescriptionEntity);
				}
				
				//Property Vs Document Delete
				for(PropertyVsDocumentModel propertyvsDocumentModel:propertyModel.getPropertyVsDocumentModels()){
					PropertyVsDocumentEntity propertyVsDocumentEntity = propertyVsDocumentDAO.find(propertyvsDocumentModel.getUserVsDocumentId());
					propertyVsDocumentEntity.setModifiedDate(Util.getCurrentDateTime());
					propertyVsDocumentEntity.setModifiedBy(userId);
					propertyVsDocumentEntity.setStatus(Status.DELETE.ordinal());
					propertyVsDocumentDAO.update(propertyVsDocumentEntity);
				}
				
				//Property Vs Special Experience Delete
				for(PropertyVsSpecialExperienceModel specialExperienceModel:propertyModel.getPropertyVsSpecialExperienceModels()){
					PropertyVsSpecialExperienceEntity propertyVsSpecialExperienceEntity = propertyVsSpecialExperienceDAO.find(Long.valueOf(specialExperienceModel.getPropertyExpId()));
					propertyVsSpecialExperienceEntity.setModifiedBy(userId);
					propertyVsSpecialExperienceEntity.setModifiedDate(Util.getCurrentDateTime());
					propertyVsSpecialExperienceEntity.setStatus(Status.DELETE.ordinal());
					propertyVsSpecialExperienceDAO.update(propertyVsSpecialExperienceEntity);
				}
				
				//Property Vs Guest Access Delete
				for(PropertyVsGuestAccessModel guestAccessModel:propertyModel.getPropertyVsGuestAccessModels()){
					PropertyVsGuestAccessEntity propertyVsGuestAccessEntity = propertyVsGuestAccessDAO.find(Long.valueOf(guestAccessModel.getPropertyGAccessId()));
					propertyVsGuestAccessEntity.setModifiedBy(userId);
					propertyVsGuestAccessEntity.setModifiedDate(Util.getCurrentDateTime());
					propertyVsGuestAccessEntity.setStatus(Status.DELETE.ordinal());
					propertyVsGuestAccessDAO.update(propertyVsGuestAccessEntity);
				}
				
				//Property Vs Image  Delete
				for(PropertyVsImageModel propertyVsImageModel:propertyModel.getPropertyVsImageModels()){
					PropertyVsImageEntity propertyVsImageEntity = propertyVsImageDAO.find(Long.valueOf(propertyVsImageModel.getPropertyImageId()));
					propertyVsImageEntity.setModifiedBy(userId);
					propertyVsImageEntity.setModifiedDate(Util.getCurrentDateTime());
					propertyVsImageEntity.setStatus(Status.DELETE.ordinal());
					propertyVsImageDAO.save(propertyVsImageEntity);
				}
				
				//Property Vs NearBy Delete
				for(PropertyVsNearbyModel propertyVsNearbyModel:propertyModel.getPropertyVsNearbyModels()){
					PropertyVsNearbyEntity propertyVsNearbyEntity = propertyVsNearbyDAO.find(Long.valueOf(propertyVsNearbyModel.getPropertyNearbyId()));
					propertyVsNearbyEntity.setModifiedBy(userId);
					propertyVsNearbyEntity.setModifiedDate(Util.getCurrentDateTime());
					propertyVsNearbyEntity.setStatus(Status.DELETE.ordinal());
					propertyVsNearbyDAO.update(propertyVsNearbyEntity);
				}
				
				//Property Vs PriceDrop Delete
				if(propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_Y)){
					
					for(PropertyVsPriceDropModel propertyVsPriceDropModel : propertyModel.getPropertyVsPriceDropModels()){
						PropertyVsPriceDropEntity propertyVsPriceDropEntity = propertyVsPriceDropDAO.find(Long.valueOf(propertyVsPriceDropModel.getPropertyPDropId()));
						propertyVsPriceDropEntity.setModifiedBy(userId);
						propertyVsPriceDropEntity.setModifiedDate(Util.getCurrentDateTime());
						propertyVsPriceDropEntity.setStatus(Status.DELETE.ordinal());
						propertyVsPriceDropDAO.update(propertyVsPriceDropEntity);
					}
					
						
				}
				
				//Property Vs SpaceRule Delete
				for(PropertyVsSpaceRuleModel propertyVsSpaceRuleModel:propertyModel.getPropertyVsSpaceRuleModels()){
					
					PropertyVsSpaceRuleEntity propertyVsSpaceRuleEntity = propertyVsSpaceRuleDAO.find(Long.valueOf(propertyVsSpaceRuleModel.getPropertySpaceId()));
					propertyVsSpaceRuleEntity.setModifiedBy(userId);
					propertyVsSpaceRuleEntity.setModifiedDate(Util.getCurrentDateTime());
					propertyVsSpaceRuleEntity.setStatus(Status.DELETE.ordinal());
					propertyVsSpaceRuleDAO.update(propertyVsSpaceRuleEntity);
				}
				
				///////////////// Room Data Delete Code ///////////////////////////
				//Room  Delete
				for(RoomModel roomModel:propertyModel.getRoomModels()){
					RoomEntity roomEntity = roomDAO.find(Long.valueOf(roomModel.getRoomId()));
					roomEntity.setModifiedBy(userId);
					roomEntity.setModifiedDate(Util.getCurrentDateTime());
					roomEntity.setStatus(Status.DELETE.ordinal());
					roomDAO.update(roomEntity);
					
					//Room vs Amenities Delete
					for(RoomVsAmenitiesModel roomVsAmenitiesModel:roomModel.getRoomVsAmenitiesModels()){
						RoomVsAmenitiesEntity roomVsAmenitiesEntity = roomVsAmenitiesDAO.find(Long.valueOf(roomVsAmenitiesModel.getRoomVsAminitiesId()));
						roomVsAmenitiesEntity.setModifiedBy(userId);
						roomVsAmenitiesEntity.setModifiedDate(Util.getCurrentDateTime());
						roomVsAmenitiesEntity.setStatus(Status.DELETE.ordinal());
						roomVsAmenitiesDAO.save(roomVsAmenitiesEntity);
					}
					
					//Room Vs Image Delete
					for(RoomVsImageModel roomVsImageModel:roomModel.getRoomVsImageModels()){
						RoomVsImageEntity roomVsImageEntity = roomVsImageDAO.find(Long.valueOf(roomVsImageModel.getRoomVsImageId()));
						roomVsImageEntity.setModifiedBy(userId);
						roomVsImageEntity.setModifiedDate(Util.getCurrentDateTime());
						roomVsImageEntity.setStatus(Status.DELETE.ordinal());
						roomVsImageDAO.update(roomVsImageEntity);
					}
					
					//Room Vs Host Discount Delete
					/*for(RoomVsHostDiscountModel roomVsHostDiscountModel:roomModel.getRoomVsHostDiscountModels()){
						RoomVsHostDiscountEntity roomVsHostDiscountEntity = roomVsHostDiscountDAO.find(Long.valueOf(roomVsHostDiscountModel.getRhdId()));
						roomVsHostDiscountEntity.setModifiedBy(userId);
						roomVsHostDiscountEntity.setStatus(Status.DELETE.ordinal());
						roomVsHostDiscountEntity.setModifiedDate(Util.getCurrentDateTime());
						roomVsHostDiscountDAO.update(roomVsHostDiscountEntity);
					}*/
					
					//Room Vs Ora Discount Delete
					for(RoomVsOraDiscountModel roomVsOraDiscountModel:roomModel.getRoomVsOraDiscountModels()) {
						
						RoomVsOraDiscountEntity roomVsOraDiscountEntity = roomVsOraDiscountDAO.find(Long.valueOf(roomVsOraDiscountModel.getRodId()));
						roomVsOraDiscountEntity.setModifiedBy(userId);
						roomVsOraDiscountEntity.setModifiedDate(Util.getCurrentDateTime());
						roomVsOraDiscountEntity.setStatus(Status.DELETE.ordinal());
						roomVsOraDiscountDAO.update(roomVsOraDiscountEntity);
					}
					
					//Room Vs Ora Price Percentage Delete
					/*for(RoomVsOrapricePercModel roomVsOrapricePercModel:roomModel.getRoomVsOrapricePercModels()) {
						RoomVsOraPricePercentageEntity roomVsOraPricePercentageEntity = roomVsOraPricePercentageDAO.find(Long.valueOf(roomVsOrapricePercModel.getRopId()));
						roomVsOraPricePercentageEntity.setModifiedBy(userId);
						roomVsOraPricePercentageEntity.setModifiedDate(Util.getCurrentDateTime());
						roomVsOraPricePercentageEntity.setStatus(Status.DELETE.ordinal());
						roomVsOraPricePercentageDAO.update(roomVsOraPricePercentageEntity);
					}*/
					
					
					// Room Vs Price Delete
					/*for(RoomVsPriceModel roomVsPriceModel:roomModel.getRoomVsPriceModels()){
						RoomVsPriceEntity roomVsPriceEntity = roomVsPriceDAO.find(Long.valueOf(roomVsPriceModel.getRoomVsPriceId()));
						roomVsPriceEntity.setModifiedBy(userId);
						roomVsPriceEntity.setModifiedDate(Util.getCurrentDateTime());
						roomVsPriceEntity.setStatus(Status.DELETE.ordinal());
						roomVsPriceDAO.update(roomVsPriceEntity);
					}*/
					
					// Room vs Specilities Delete
					for(RoomVsSpecialitiesModel roomVsSpecialitiesModel:roomModel.getRoomVsSpecialitiesModels()){
						RoomVsSpecialitiesEntity roomVsSpecialitiesEntity = roomVsSpecialitiesDAO.find(Long.valueOf(roomVsSpecialitiesModel.getRoomspecId()));
						roomVsSpecialitiesEntity.setModifiedBy(userId);
						roomVsSpecialitiesEntity.setModifiedDate(Util.getCurrentDateTime());
						roomVsSpecialitiesEntity.setStatus(Status.DELETE.ordinal());
						roomVsSpecialitiesDAO.update(roomVsSpecialitiesEntity);
					}
					
					//Room Vs Meal Delete
					for(RoomVsMealModel roomVsMeal:roomModel.getRoomVsMealModels()){
						RoomVsMealEntity roomVsMealEntity = roomVsMealDAO.find(Long.valueOf(roomVsMeal.getRoomVsMealId()));
						roomVsMealEntity.setModifiedBy(userId);
						roomVsMealEntity.setModifiedDate(Util.getCurrentDateTime());
						roomVsMealEntity.setStatus(Status.DELETE.ordinal());
						roomVsMealDAO.update(roomVsMealEntity);
					}
					
					//Room vs Cancellation Delete
					for(RoomVsCancellationModel roomVsCancellationModel:roomModel.getRoomVsCancellationModels()){
						RoomVsCancellationEntity roomVsCancellationEntity = roomVsCancellationDAO.find(Long.valueOf(roomVsCancellationModel.getRcId()));
						roomVsCancellationEntity.setModifiedBy(userId);
						roomVsCancellationEntity.setModifiedDate(Util.getCurrentDateTime());
						roomVsCancellationEntity.setStatus(Status.DELETE.ordinal());
						roomVsCancellationDAO.update(roomVsCancellationEntity);
					}
					
					//// Room Vs Bed Delete
					RoomVsBedEntity roomVsBedEntity = roomVsBedDAO.find(Long.valueOf(roomModel.getRoomVsBedModel().getRbId()));
					roomVsBedEntity.setModifiedBy(userId);
					roomVsBedEntity.setModifiedDate(Util.getCurrentDateTime());
					roomVsBedEntity.setStatus(Status.DELETE.ordinal());
					roomVsBedDAO.update(roomVsBedEntity);	
				}
				
				
				//////////////////////////////////////////////////////////// Property Add ////////////////////////////////////////////////
				
				
				// User vs Account
				propertyModel.getUserVsAccountModel().setCreatedBy(userId);
				propertyModel.getUserVsAccountModel().setUserId(userModel.getUserId());
				UserVsAccountEntity userVsAccountEntity2 = userVsAccountConverter.modelToEntity(propertyModel.getUserVsAccountModel());
				userVsAccountDAO.save(userVsAccountEntity2);
				
				//Property
				propertyModel.setCreatedBy(userId);
				propertyModel.setAdvancePercentage(PropertyAddConstant.ADVPERCENTAGE);
				PropertyEntity propertyEntity2 = propertyConverter.modelToEntity(propertyModel);
				propertyEntity2.setStatus(Status.ACTIVE.ordinal());
				propertyEntity2.setUserVsAccountEntity(userVsAccountEntity2);
				propertyDAO.save(propertyEntity2);
				
				//Property Vs Description
				for(PropertyVsDescriptionModel propertyVsDescriptionModel:propertyModel.getPropertyVsDescriptionModels()){
					propertyVsDescriptionModel.setCreatedBy(userId);
					PropertyVsDescriptionEntity propertyVsDescriptionEntity = propertyVsDescriptionConverter.modelToEntity(propertyVsDescriptionModel);
					propertyVsDescriptionEntity.setPropertyEntity(propertyEntity2);			
					propertyVsDescriptionDAO.save(propertyVsDescriptionEntity);
				}
				
				//Property Vs Document
				for(PropertyVsDocumentModel propertyvsDocumentModel:propertyModel.getPropertyVsDocumentModels()){
					propertyvsDocumentModel.setCreatedBy(userId);
					PropertyVsDocumentEntity propertyVsDocumentEntity = propertyVsDocumentConverter.modelToEntity(propertyvsDocumentModel);
					propertyVsDocumentEntity.setPropertyEntity(propertyEntity2);
					propertyVsDocumentDAO.save(propertyVsDocumentEntity);
				}
				
				//Property Vs Special Experience
				for(PropertyVsSpecialExperienceModel specialExperienceModel:propertyModel.getPropertyVsSpecialExperienceModels()){
					specialExperienceModel.setCreatedBy(userId);
					PropertyVsSpecialExperienceEntity propertyVsSpecialExperienceEntity = pVsSpecialExperienceConverter.modelToEntity(specialExperienceModel);
					propertyVsSpecialExperienceEntity.setPropertyEntity(propertyEntity2);
					propertyVsSpecialExperienceDAO.save(propertyVsSpecialExperienceEntity);
				}
				
				//Property Vs Guest Access
				for(PropertyVsGuestAccessModel guestAccessModel:propertyModel.getPropertyVsGuestAccessModels()){
					guestAccessModel.setCreatedBy(userId);
					PropertyVsGuestAccessEntity propertyVsGuestAccessEntity = propertyVsGuestAccessConverter.modelToEntity(guestAccessModel);
					propertyVsGuestAccessEntity.setPropertyEntity(propertyEntity2);
					propertyVsGuestAccessDAO.save(propertyVsGuestAccessEntity);
				}
				
				//Property Vs Image 
				for(PropertyVsImageModel propertyVsImageModel:propertyModel.getPropertyVsImageModels()){
					propertyVsImageModel.setCreatedBy(userId);
					PropertyVsImageEntity propertyVsImageEntity = propertyVsImageConverter.modelToEntity(propertyVsImageModel);
					propertyVsImageEntity.setPropertyEntity(propertyEntity2);
					propertyVsImageDAO.save(propertyVsImageEntity);
				}
				
				//Property Vs NearBy
				for(PropertyVsNearbyModel propertyVsNearbyModel:propertyModel.getPropertyVsNearbyModels()){
					propertyVsNearbyModel.setCreatedBy(userId);
					PropertyVsNearbyEntity propertyVsNearbyEntity = propertyVsNearbyConverter.modelToEntity(propertyVsNearbyModel);
					propertyVsNearbyEntity.setPropertyEntity(propertyEntity2);
					propertyVsNearbyDAO.save(propertyVsNearbyEntity);
				}
				
				//Property Vs PriceDrop
				if(propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_Y)){
					List<PriceDropModel> priceDropModels = fetchPriceDropList();
					for(PriceDropModel priceDropModel:priceDropModels){
						PropertyVsPriceDropModel propertyVsPriceDropModel = new PropertyVsPriceDropModel();
						propertyVsPriceDropModel.setPriceDropModel(priceDropModel);
						propertyVsPriceDropModel.setPercentage(PropertyAddConstant.STR_ZERO);
						propertyVsPriceDropModel.setCreatedBy(userId);
						PropertyVsPriceDropEntity propertyVsPriceDropEntity = propertyVsPriceDropConverter.modelToEntity(propertyVsPriceDropModel);
						propertyVsPriceDropEntity.setPropertyEntity(propertyEntity2);
						propertyVsPriceDropDAO.save(propertyVsPriceDropEntity);
					}
				}
				
				//Property Vs SpaceRule
				for(PropertyVsSpaceRuleModel propertyVsSpaceRuleModel:propertyModel.getPropertyVsSpaceRuleModels()){
					propertyVsSpaceRuleModel.setCreatedBy(userId);
					PropertyVsSpaceRuleEntity propertyVsSpaceRuleEntity = propertyVsSpaceRuleConverter.modelToEntity(propertyVsSpaceRuleModel);
					propertyVsSpaceRuleEntity.setPropertyEntity(propertyEntity2);
					propertyVsSpaceRuleDAO.save(propertyVsSpaceRuleEntity);
				}
				
				///////////////// Room Data Insert Code ///////////////////////////
				//Room 
				for(RoomModel roomModel:propertyModel.getRoomModels()){
					roomModel.setCreatedBy(userId);
					RoomEntity roomEntity = roomConverter.modelToEntity(roomModel);
					roomEntity.setPropertyEntity(propertyEntity2);
					roomDAO.save(roomEntity);
					
					//Room vs Amenities
					for(RoomVsAmenitiesModel roomVsAmenitiesModel:roomModel.getRoomVsAmenitiesModels()){
						roomVsAmenitiesModel.setCreatedBy(userId);
						RoomVsAmenitiesEntity roomVsAmenitiesEntity = roomVsAmenitiesConverter.modelToEntity(roomVsAmenitiesModel);
						roomVsAmenitiesEntity.setRoomEntity(roomEntity);
						roomVsAmenitiesDAO.save(roomVsAmenitiesEntity);
					}
					
					//Room Vs Image
					for(RoomVsImageModel roomVsImageModel:roomModel.getRoomVsImageModels()){
						roomVsImageModel.setCreatedBy(userId);
						RoomVsImageEntity roomVsImageEntity = roomVsImageConverter.modelToEntity(roomVsImageModel);
						roomVsImageEntity.setRoomEntity(roomEntity);
						roomVsImageDAO.save(roomVsImageEntity);
					}
					
					//Room Vs Host Discount
					/*for(RoomVsHostDiscountModel roomVsHostDiscountModel:roomModel.getRoomVsHostDiscountModels()){
						roomVsHostDiscountModel.setCreatedBy(userId);
						RoomVsHostDiscountEntity roomVsHostDiscountEntity = roomVsHostDiscountConverter.modelToEntity(roomVsHostDiscountModel);
						roomVsHostDiscountEntity.setRoomEntity(roomEntity);
						roomVsHostDiscountDAO.save(roomVsHostDiscountEntity);
					}*/
					
					//Room Vs Ora Discount
					RoomVsOraDiscountEntity roomVsOraDiscountEntity = new RoomVsOraDiscountEntity();
					DiscountCategoryOraEntity discountCategoryOraEntity= discountCategoryOraDAO.find(Long.valueOf(1));
					roomVsOraDiscountEntity.setDiscountCategoryOraEntity(discountCategoryOraEntity);
					roomVsOraDiscountEntity.setRoomEntity(roomEntity);
					roomVsOraDiscountEntity.setDiscount(PropertyAddConstant.STR_ZERO);
					roomVsOraDiscountEntity.setCreatedBy(userId);
					roomVsOraDiscountDAO.save(roomVsOraDiscountEntity);
					
					//Room Vs Ora Price Percentage
					/*RoomVsOraPricePercentageEntity roomVsOraPricePercentageEntity = new RoomVsOraPricePercentageEntity();
					roomVsOraPricePercentageEntity.setPercentage(PropertyAddConstant.STR_ZERO);
					roomVsOraPricePercentageEntity.setRoomEntity(roomEntity);
					roomVsOraPricePercentageEntity.setCreatedBy(userId);
					roomVsOraPricePercentageDAO.save(roomVsOraPricePercentageEntity);*/
					
					// Room Vs Price
					/*for(RoomVsPriceModel roomVsPriceModel:roomModel.getRoomVsPriceModels()){
						roomVsPriceModel.setCreatedBy(userId);
						RoomVsPriceEntity roomVsPriceEntity = roomVsPriceConverter.modelToEntity(roomVsPriceModel);
						roomVsPriceEntity.setRoomEntity(roomEntity);
						roomVsPriceDAO.save(roomVsPriceEntity);
					}*/
					
					// Room vs Specilities
					for(RoomVsSpecialitiesModel roomVsSpecialitiesModel:roomModel.getRoomVsSpecialitiesModels()){
						roomVsSpecialitiesModel.setCreatedBy(userId);
						RoomVsSpecialitiesEntity roomVsSpecialitiesEntity = roomVsSpecialitiesConverter.modelToEntity(roomVsSpecialitiesModel);
						roomVsSpecialitiesEntity.setRoomEntity(roomEntity);
						roomVsSpecialitiesDAO.save(roomVsSpecialitiesEntity);
					}
					
					//Room Vs Meal
					for(RoomVsMealModel roomVsMeal:roomModel.getRoomVsMealModels()){
						roomVsMeal.setCreatedBy(userId);
						RoomVsMealEntity roomVsMealEntity = roomVsMealConverter.modelToEntity(roomVsMeal);
						roomVsMealEntity.setRoomEntity(roomEntity);
						roomVsMealDAO.save(roomVsMealEntity);
					}
					
					//Room vs Cancellation
					for(RoomVsCancellationModel roomVsCancellationModel:roomModel.getRoomVsCancellationModels()){
						roomVsCancellationModel.setCreatedBy(userId);
						RoomVsCancellationEntity roomVsCancellationEntity = roomVsCancellationConverter.modelToEntity(roomVsCancellationModel);
						roomVsCancellationEntity.setRoomEntity(roomEntity);
						roomVsCancellationDAO.save(roomVsCancellationEntity);
					}
					
					//// Room Vs Bed
					RoomVsBedModel roomVsBedModel = roomModel.getRoomVsBedModel();
					roomVsBedModel.setCreatedBy(userId);
					RoomVsBedEntity roomVsBedEntity = roomVsBedConverter.modelToEntity(roomVsBedModel);
					roomVsBedEntity.setRoomEntity(roomEntity);
					roomVsBedDAO.save(roomVsBedEntity);	
				}
				
				if (logger.isInfoEnabled()) {
					logger.info("updateProperty -- END");
				}


	}

	@Override
	public List<BookingModel> viewPropertyBookingList(PropertyModel propertyModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyBookingList -- START");
		}
		
		
		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyBookingList -- END");
		}
		
		return  propertyValidation.validatePropertyUserToken(propertyModel);
	}

	@Override
	public List<BookingModel> viewUserBookingList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("viewUserBookingList -- START");
		}
		
		
		
		if (logger.isInfoEnabled()) {
			logger.info("viewUserBookingList -- END");
		}
		
		return propertyValidation.validateUserTokenForBookingList(commonModel);
	}

	@Override
	public List<CancellationModel> viewPropertyCancellationList(BookingModel bookingModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyCancellationList -- START");
		}
		

		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyCancellationList -- END");
		}
		
		return propertyValidation.getPropertyCancellationList(bookingModel);
	}

	@Override
	public List<CancellationModel> viewUserCancellationList(BookingModel bookingModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("viewUserCancellationList -- START");
		}
		

		if (logger.isInfoEnabled()) {
			logger.info("viewUserCancellationList -- END");
		}
		return propertyValidation.validateUserTokenForCancellationList(bookingModel);
	}

}