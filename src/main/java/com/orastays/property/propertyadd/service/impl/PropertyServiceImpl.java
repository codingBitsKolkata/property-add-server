package com.orastays.property.propertyadd.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orastays.property.propertyadd.exceptions.FormExceptions;
import com.orastays.property.propertyadd.helper.PropertyAddConstant;
import com.orastays.property.propertyadd.helper.Status;
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
}
