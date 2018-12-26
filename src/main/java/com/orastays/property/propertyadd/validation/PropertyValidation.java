package com.orastays.property.propertyadd.validation;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.entity.AccommodationEntity;
import com.orastays.property.propertyadd.entity.AmenitiesEntity;
import com.orastays.property.propertyadd.entity.CancellationSlabEntity;
import com.orastays.property.propertyadd.entity.DiscountCategoryHostEntity;
import com.orastays.property.propertyadd.entity.DocumentEntity;
import com.orastays.property.propertyadd.entity.MealCategoryEntity;
import com.orastays.property.propertyadd.entity.MealDaysEntity;
import com.orastays.property.propertyadd.entity.MealPriceCategoryEntity;
import com.orastays.property.propertyadd.entity.MealTypeEntity;
import com.orastays.property.propertyadd.entity.PGCategorySexEntity;
import com.orastays.property.propertyadd.entity.PriceTypeEntity;
import com.orastays.property.propertyadd.entity.PropertyEntity;
import com.orastays.property.propertyadd.entity.PropertyTypeEntity;
import com.orastays.property.propertyadd.entity.PropertyVsDescriptionEntity;
import com.orastays.property.propertyadd.entity.PropertyVsDocumentEntity;
import com.orastays.property.propertyadd.entity.PropertyVsGuestAccessEntity;
import com.orastays.property.propertyadd.entity.PropertyVsImageEntity;
import com.orastays.property.propertyadd.entity.PropertyVsNearbyEntity;
import com.orastays.property.propertyadd.entity.PropertyVsSpaceRuleEntity;
import com.orastays.property.propertyadd.entity.PropertyVsSpecialExperienceEntity;
import com.orastays.property.propertyadd.entity.RoomCategoryEntity;
import com.orastays.property.propertyadd.entity.RoomStandardEntity;
import com.orastays.property.propertyadd.entity.RoomVsAmenitiesEntity;
import com.orastays.property.propertyadd.entity.RoomVsCancellationEntity;
import com.orastays.property.propertyadd.entity.RoomVsHostDiscountEntity;
import com.orastays.property.propertyadd.entity.RoomVsImageEntity;
import com.orastays.property.propertyadd.entity.RoomVsMealEntity;
import com.orastays.property.propertyadd.entity.RoomVsOraDiscountEntity;
import com.orastays.property.propertyadd.entity.RoomVsOraPricePercentageEntity;
import com.orastays.property.propertyadd.entity.RoomVsPriceEntity;
import com.orastays.property.propertyadd.entity.RoomVsSpecialitiesEntity;
import com.orastays.property.propertyadd.entity.SpaceRuleEntity;
import com.orastays.property.propertyadd.entity.SpecialExperienceEntity;
import com.orastays.property.propertyadd.entity.SpecialtiesEntity;
import com.orastays.property.propertyadd.entity.UserVsAccountEntity;
import com.orastays.property.propertyadd.exceptions.FormExceptions;
import com.orastays.property.propertyadd.helper.Accommodation;
import com.orastays.property.propertyadd.helper.MealCategory;
import com.orastays.property.propertyadd.helper.PropertyAddConstant;
import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.helper.UserType;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.BookingModel;
import com.orastays.property.propertyadd.model.CommonModel;
import com.orastays.property.propertyadd.model.PropertyModel;
import com.orastays.property.propertyadd.model.PropertyVsDescriptionModel;
import com.orastays.property.propertyadd.model.PropertyVsDocumentModel;
import com.orastays.property.propertyadd.model.PropertyVsGuestAccessModel;
import com.orastays.property.propertyadd.model.PropertyVsImageModel;
import com.orastays.property.propertyadd.model.PropertyVsNearbyModel;
import com.orastays.property.propertyadd.model.PropertyVsSpaceRuleModel;
import com.orastays.property.propertyadd.model.PropertyVsSpecialExperienceModel;
import com.orastays.property.propertyadd.model.RoomModel;
import com.orastays.property.propertyadd.model.RoomStandardModel;
import com.orastays.property.propertyadd.model.RoomVsAmenitiesModel;
import com.orastays.property.propertyadd.model.RoomVsCancellationModel;
import com.orastays.property.propertyadd.model.RoomVsHostDiscountModel;
import com.orastays.property.propertyadd.model.RoomVsImageModel;
import com.orastays.property.propertyadd.model.RoomVsMealModel;
import com.orastays.property.propertyadd.model.RoomVsOraDiscountModel;
import com.orastays.property.propertyadd.model.RoomVsOrapricePercModel;
import com.orastays.property.propertyadd.model.RoomVsPriceModel;
import com.orastays.property.propertyadd.model.RoomVsSpecialitiesModel;
import com.orastays.property.propertyadd.model.UserModel;
import com.orastays.property.propertyadd.model.UserVsTypeModel;

@Component
@Transactional
public class PropertyValidation extends AuthorizeUserValidation {

	private static final Logger logger = LogManager.getLogger(PropertyValidation.class);
	
	public List<BookingModel> validateUserTokenForBookingList(CommonModel commonModel) throws FormExceptions {
		if (logger.isDebugEnabled()) {
			logger.debug("validatePropertyUserToken -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<BookingModel> bookingModels = null;
		UserModel userModel = null;
		if(Objects.nonNull(commonModel)){
			// Validate User Token
			if (StringUtils.isBlank(commonModel.getUserToken())) {
				exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
			} else {
				userModel = getUserDetails(commonModel.getUserToken());
			}
			
			// Validate User Login Details
			if(Objects.nonNull(userModel)){
				if(Objects.nonNull(userModel.getUserVsTypes())){
					boolean flag = false;
					for(UserVsTypeModel userVsTypeModel : userModel.getUserVsTypes()){
						if(Objects.nonNull(userVsTypeModel.getUserType())) {
							if(userVsTypeModel.getUserType().getUserTypeId().equals(String.valueOf(UserType.CUSTOMER.ordinal()))){
								flag = true;
							}
						} else {
							exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
						}
					}
					
					if(!flag){
						exceptions.put(messageUtil.getBundle("user.type.invalid.code"), new Exception(messageUtil.getBundle("user.type.invalid.message")));
					} else {
						bookingModels = getUserBookingList(userModel.getUserId());
					}
				} else {
					exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
				}
			} else {
				exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message")));
			}

		}
		
		return bookingModels;
	}
	
	
	public List<BookingModel> validatePropertyUserToken(PropertyModel propertyModel) throws FormExceptions {
		
		if (logger.isDebugEnabled()) {
			logger.debug("validatePropertyUserToken -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<BookingModel> bookingModels = null;
		UserModel userModel = null;
		if(Objects.nonNull(propertyModel)){
			
			// Validate User Token
			if (StringUtils.isBlank(propertyModel.getUserToken())) {
				exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
			} else {
				userModel = getUserDetails(propertyModel.getUserToken());
			}
			
			// Validate Host Login Details
			if(Objects.nonNull(userModel)){
				if(Objects.nonNull(userModel.getUserVsTypes())){
					boolean flag = false;
					for(UserVsTypeModel userVsTypeModel : userModel.getUserVsTypes()){
						if(Objects.nonNull(userVsTypeModel.getUserType())) {
							if(userVsTypeModel.getUserType().getUserTypeId().equals(String.valueOf(UserType.HOST.ordinal()))){
								flag = true;
							}
						} else {
							exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
						}
					}
					
					if(!flag){
						exceptions.put(messageUtil.getBundle("user.type.invalid.code"), new Exception(messageUtil.getBundle("user.type.invalid.message")));
					}
				} else {
					exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
				}
			} else {
				exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message")));
			}
			
			//Validate Property
			if (StringUtils.isBlank(String.valueOf(propertyModel.getPropertyId()))) {
				exceptions.put(messageUtil.getBundle("property.id.null.code"), new Exception(messageUtil.getBundle("property.id.null.message")));
			} else {
				
				if (!Util.isNumeric(String.valueOf(propertyModel.getPropertyId()))) {
					exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
				} else {
					PropertyEntity propertyEntity = null;
					
					try {
						Map<String, String> innerMap1 = new LinkedHashMap<>();
						innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
						innerMap1.put(PropertyAddConstant.PROPERTYID, String.valueOf(propertyModel.getPropertyId()));
				
						Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
						outerMap1.put("eq", innerMap1);
				
						Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
						alliasMap.put(entitymanagerPackagesToScan+".PropertyEntity", outerMap1);
						
						propertyEntity = propertyDAO.fetchObjectBySubCiteria(alliasMap);
						
						if (Objects.isNull(propertyEntity)) {
							exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
						} else {
							bookingModels = getPropertyBookingList(String.valueOf(propertyModel.getPropertyId()));
						}

					} catch (Exception e) {
						exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
					}
					
				}
			}
			
		} else {
			 exceptions.put(messageUtil.getBundle("property.null.code"), new Exception(messageUtil.getBundle("property.null.message")));
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isDebugEnabled()) {
			logger.debug("validatePropertyUserToken -- End");
		}
		
		return bookingModels;
		
	}

	public void validateLanguageWithUserToken(Object object) throws FormExceptions {

		if (logger.isDebugEnabled()) {
			logger.debug("validateLanguageWithUserToken -- Start");
		}

		if (object instanceof CommonModel) {
			CommonModel commonModel = (CommonModel) object;
			validateTokenAndLanguage(commonModel);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("validateLanguageWithUserToken -- End");
		}
	}

	private void validateTokenAndLanguage(CommonModel commonModel) throws FormExceptions {

		if (logger.isDebugEnabled()) {
			logger.debug("validateLanguageWithUserToken -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();
		// Validate User Token
		if (StringUtils.isBlank(commonModel.getUserToken())) {
			exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
		} else {
			getUserDetails(commonModel.getUserToken());
		}

		// Validate Language
		if (StringUtils.isBlank(commonModel.getLanguageId())) {
			exceptions.put(messageUtil.getBundle("language.id.null.code"), new Exception(messageUtil.getBundle("language.id.null.message")));
		} else {
			validateLanguage(commonModel.getLanguageId());
		}

		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isDebugEnabled()) {
			logger.debug("validateLanguageWithUserToken -- End");
		}
	}
	
	public UserModel validateUserToken(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isDebugEnabled()) {
			logger.debug("validateUserToken -- Start");
		}
		
		UserModel userModel = null;
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		// Validate User Token
		if (StringUtils.isBlank(commonModel.getUserToken())) {
			exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
		} else {
			userModel = getUserDetails(commonModel.getUserToken());
		}
		
		// Validate Host Login Details
		if(Objects.nonNull(userModel)){
			if(Objects.nonNull(userModel.getUserVsTypes())){
				boolean flag = false;
				for(UserVsTypeModel userVsTypeModel : userModel.getUserVsTypes()){
					if(Objects.nonNull(userVsTypeModel.getUserType())) {
						if(userVsTypeModel.getUserType().getUserTypeId().equals(String.valueOf(UserType.HOST.ordinal()))){
							flag = true;
						}
					} else {
						exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
					}
				}
				
				if(!flag){
					exceptions.put(messageUtil.getBundle("user.type.invalid.code"), new Exception(messageUtil.getBundle("user.type.invalid.message")));
				}
			} else {
				exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
			}
		} else {
			exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message")));
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isDebugEnabled()) {
			logger.debug("validateUserToken -- End");
		}
		
		return userModel;
	} 
	
	public void validateFetchPropertyById(PropertyModel propertyModel) throws FormExceptions {
		
		if (logger.isDebugEnabled()) {
			logger.debug("validateFetchPropertyById -- Start");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		
		UserModel userModel = null;
		if(Objects.nonNull(propertyModel)){
			// Validate User Token
			if (StringUtils.isBlank(propertyModel.getUserToken())) {
				exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
			} else {
				userModel = getUserDetails(propertyModel.getUserToken());
			}
			
			// Validate Host Login Details
			if(Objects.nonNull(userModel)){
				if(Objects.nonNull(userModel.getUserVsTypes())){
					boolean flag = false;
					for(UserVsTypeModel userVsTypeModel : userModel.getUserVsTypes()){
						if(Objects.nonNull(userVsTypeModel.getUserType())) {
							if(userVsTypeModel.getUserType().getUserTypeId().equals(String.valueOf(UserType.HOST.ordinal()))){
								flag = true;
							}
						} else {
							exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
						}
					}
					
					if(!flag){
						exceptions.put(messageUtil.getBundle("user.type.invalid.code"), new Exception(messageUtil.getBundle("user.type.invalid.message")));
					}
				} else {
					exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
				}
			} else {
				exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message")));
			}
			
			//Validate Property Id
			if (StringUtils.isBlank(String.valueOf(propertyModel.getPropertyId()))) {
				exceptions.put(messageUtil.getBundle("property.id.null.code"), new Exception(messageUtil.getBundle("property.id.null.message")));
			} else {
				
				if (!Util.isNumeric(String.valueOf(propertyModel.getPropertyId()))) {
					exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
				} else {
					PropertyEntity propertyEntity = null;
					
					try {
						Map<String, String> innerMap1 = new LinkedHashMap<>();
						innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
						innerMap1.put(PropertyAddConstant.PROPERTYID, String.valueOf(propertyModel.getPropertyId()));
				
						Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
						outerMap1.put("eq", innerMap1);
				
						Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
						alliasMap.put(entitymanagerPackagesToScan+".PropertyEntity", outerMap1);
						
						propertyEntity = propertyDAO.fetchObjectBySubCiteria(alliasMap);
						
						if (Objects.isNull(propertyEntity)) {
							exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
						}

					} catch (Exception e) {
						exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
					}
					
				}
			}
			
		} else {
			 exceptions.put(messageUtil.getBundle("property.null.code"), new Exception(messageUtil.getBundle("property.null.message"))); 
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isDebugEnabled()) {
			logger.debug("validateFetchPropertyById -- End");
		}
	}

	public UserModel validatePropertyAdd(PropertyModel propertyModel) throws FormExceptions {

		if (logger.isDebugEnabled()) {
			logger.debug("validatePropertyAdd -- Start");
		}

		Util.printLog(propertyModel, PropertyAddConstant.INCOMING, "Property Add", request);
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		UserModel userModel = null;
		if (Objects.nonNull(propertyModel)) {

			
			//Test to Bypass Auth
			userModel =  getUserDetails(propertyModel.getUserToken());
			
			
			if(Objects.nonNull(userModel)) {
					
				// Validate Host Login Details
				if(Objects.nonNull(userModel)){
					if(Objects.nonNull(userModel.getUserVsTypes())){
						boolean flag = false;
						for(UserVsTypeModel userVsTypeModel : userModel.getUserVsTypes()){
							if(Objects.nonNull(userVsTypeModel.getUserType())) {
								if(userVsTypeModel.getUserType().getUserTypeId().equals(String.valueOf(UserType.HOST.ordinal()))){
									flag = true;
								}
							} else {
								exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
							}
						}
						
						if(!flag){
							exceptions.put(messageUtil.getBundle("user.type.invalid.code"), new Exception(messageUtil.getBundle("user.type.invalid.message")));
						}
					} else {
						exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
					}
				} else {
					exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message")));
				}
				
				
					// Validate Property Name
					if (StringUtils.isBlank(propertyModel.getName())) {
						exceptions.put(messageUtil.getBundle("property.name.null.code"), new Exception(messageUtil.getBundle("property.name.null.message")));
					} else {
						if (!Util.checkAlphabet(propertyModel.getName())) {
							exceptions.put(messageUtil.getBundle("property.name.invalid.code"), new Exception(messageUtil.getBundle("property.name.invalid.message")));
						}
					}
		
					propertyModel.setOraname("ORA"+new Date().getTime());
		
					// validate Entire Apartment
					if (StringUtils.isBlank(propertyModel.getEntireApartment())) {
						exceptions.put(messageUtil.getBundle("entire.appartment.null.code"), new Exception(messageUtil.getBundle("entire.appartment.null.message")));
					} else {
						if (!(propertyModel.getEntireApartment().equals(PropertyAddConstant.STR_Y)
								|| propertyModel.getEntireApartment().equals(PropertyAddConstant.STR_N))) {
							exceptions.put(messageUtil.getBundle("entire.appartment.invalid.code"), new Exception(messageUtil.getBundle("entire.appartment.invalid.message")));
						}
					}
		
					// Validate Latitude
					if (StringUtils.isBlank(propertyModel.getLatitude())) {
						exceptions.put(messageUtil.getBundle("latitude.null.code"), new Exception(messageUtil.getBundle("latitude.null.message")));
					} else {
						if (!Util.checkLatitude(propertyModel.getLatitude())) {
							exceptions.put(messageUtil.getBundle("latitude.invalid.code"), new Exception(messageUtil.getBundle("latitude.invalid.message")));
						}
					}
		
					// Validate Longitude
					if (StringUtils.isBlank(propertyModel.getLongitude())) {
						exceptions.put(messageUtil.getBundle("longitude.null.code"), new Exception(messageUtil.getBundle("longitude.null.message")));
					} else {
						if (!Util.checkLongitude(propertyModel.getLongitude())) {
							exceptions.put(messageUtil.getBundle("longitude.invalid.code"), new Exception(messageUtil.getBundle("longitude.invalid.message")));
						}
					}
		
					// Validate Address
					if (StringUtils.isBlank(propertyModel.getAddress())) {
						exceptions.put(messageUtil.getBundle("address.null.code"),new Exception(messageUtil.getBundle("address.null.message")));
					}
		
					// Validate Start End Date
					if (StringUtils.isBlank(propertyModel.getStartDate())) {
						exceptions.put(messageUtil.getBundle("start.date.null.code"), new Exception(messageUtil.getBundle("start.date.null.message")));
					} else {
						if (StringUtils.isBlank(propertyModel.getEndDate())) {
							exceptions.put(messageUtil.getBundle("end.date.null.code"), new Exception(messageUtil.getBundle("end.date.null.message")));
						} else {
							String startDate = propertyModel.getStartDate();
							String endDate = propertyModel.getEndDate();
							propertyModel.setStartDate(startDate + " 00:00:01");
							propertyModel.setEndDate(endDate + " 23:59:59");
							
							if(!Util.checkDate(propertyModel.getStartDate(), propertyModel.getEndDate())){
								exceptions.put(messageUtil.getBundle("stEndate.invalid.code"), new Exception(messageUtil.getBundle("stEndate.invalid.message")));
							}
						}
					}
		
					// Validate CheckIn Time
					if (StringUtils.isBlank(propertyModel.getCheckinTime())) {
						exceptions.put(messageUtil.getBundle("checkin.time.null.code"), new Exception(messageUtil.getBundle("checkin.time.null.message")));
					} else {
						if (!Util.checkTimeFormat(propertyModel.getCheckinTime())) {
							exceptions.put(messageUtil.getBundle("checkin.time.invalid.code"), new Exception(messageUtil.getBundle("checkin.time.invalid.message")));
						}
					}
		
					// Validate CheckOut Time
					if (StringUtils.isBlank(propertyModel.getCheckoutTime())) {
						exceptions.put(messageUtil.getBundle("checkout.time.null.code"), new Exception(messageUtil.getBundle("checkout.time.null.message")));
					} else {
						if (!Util.checkTimeFormat(propertyModel.getCheckoutTime())) {
							exceptions.put(messageUtil.getBundle("checkout.time.invalid.code"), new Exception(messageUtil.getBundle("checkout.time.invalid.message")));
						}
					}
		
					// Validate Image Url
					if (StringUtils.isBlank(propertyModel.getCoverImageUrl())) {
						exceptions.put(messageUtil.getBundle("image.url.null.code"), new Exception(messageUtil.getBundle("image.url.null.message")));
					}
		
					// Validate Price Drop
					if (StringUtils.isBlank(propertyModel.getPriceDrop())) {
						exceptions.put(messageUtil.getBundle("price.drop.null.code"), new Exception(messageUtil.getBundle("price.drop.null.message")));
					} else {
						if (!(propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_Y) || propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_N))) {
							exceptions.put(messageUtil.getBundle("price.drop.invalid.code"), new Exception(messageUtil.getBundle("price.drop.invalid.message")));
						}
					}
		
					// Validate Property Type
					if (Objects.isNull(propertyModel.getPropertyTypeModel())) {
						exceptions.put(messageUtil.getBundle("property.type.null.code"), new Exception(messageUtil.getBundle("property.type.null.message")));
					} else {
						if (StringUtils.isBlank(propertyModel.getPropertyTypeModel().getPropertyTypeId())) {
							exceptions.put(messageUtil.getBundle("property.type.id.null.code"), new Exception(messageUtil.getBundle("property.type.id.null.message")));
						} else {
							if (!Util.isNumeric(propertyModel.getPropertyTypeModel().getPropertyTypeId())) {
								exceptions.put(messageUtil.getBundle("property.type.id.invalid.code"), new Exception(messageUtil.getBundle("property.type.id.invalid.message")));
							} else {
								PropertyTypeEntity propertyTypeEntity = propertyTypeDAO.find(Long.parseLong(propertyModel.getPropertyTypeModel().getPropertyTypeId()));
								if (Objects.isNull(propertyTypeEntity) && propertyTypeEntity.getStatus() != Status.ACTIVE.ordinal()) {
									exceptions.put(messageUtil.getBundle("property.type.id.invalid.code"), new Exception(messageUtil.getBundle("property.type.id.invalid.message")));
								}
							}
						}
					}
		
					// Validate Property Vs Description
					if (Objects.isNull(propertyModel.getPropertyVsDescriptionModels())) {
						exceptions.put(messageUtil.getBundle("property.description.null.code"), new Exception(messageUtil.getBundle("property.description.null.message")));
					} else {
		
						for (PropertyVsDescriptionModel propertyVsDescriptionModel : propertyModel.getPropertyVsDescriptionModels()) {
							if (StringUtils.isBlank(propertyVsDescriptionModel.getDescription())) {
								exceptions.put(messageUtil.getBundle("property.description.null.code"), new Exception(messageUtil.getBundle("property.description.null.message")));
							}
		
							if (StringUtils.isBlank(propertyVsDescriptionModel.getLanguageId())) {
								exceptions.put(messageUtil.getBundle("language.id.null.code"), new Exception(messageUtil.getBundle("language.id.null.message")));
							} else {
								validateLanguage(propertyVsDescriptionModel.getLanguageId());
							}
						}
					}
		
					// Property Vs Guest Access
					if (Objects.isNull(propertyModel.getPropertyVsGuestAccessModels())) {
						exceptions.put(messageUtil.getBundle("property.guest.null.code"), new Exception(messageUtil.getBundle("property.guest.null.message")));
					} else {
		
						for (PropertyVsGuestAccessModel propertyVsGuestAccessModel : propertyModel.getPropertyVsGuestAccessModels()) {
							if (StringUtils.isBlank(propertyVsGuestAccessModel.getGuestAccess())) {
								exceptions.put(messageUtil.getBundle("property.guest.null.code"), new Exception(messageUtil.getBundle("property.guest.null.message")));
							}
		
							if (StringUtils.isBlank(propertyVsGuestAccessModel.getLanguageId())) {
								exceptions.put(messageUtil.getBundle("language.id.null.code"), new Exception(messageUtil.getBundle("language.id.null.message")));
							} else {
								validateLanguage(propertyVsGuestAccessModel.getLanguageId());
							}
						}
					}
		
					// Immediate Booking
					if (StringUtils.isBlank(propertyModel.getImmediateBooking())) {
						exceptions.put(messageUtil.getBundle("property.immbooking.null.code"), new Exception(messageUtil.getBundle("property.immbooking.null.message")));
					} else {
						if (!(propertyModel.getImmediateBooking().equals(PropertyAddConstant.STR_Y) || propertyModel.getImmediateBooking().equals(PropertyAddConstant.STR_N))) {
							exceptions.put(messageUtil.getBundle("property.immbooking.invalid.code"), new Exception(messageUtil.getBundle("property.immbooking.invalid.message")));
						}
					}
		
					// Strict Checkin
					if (StringUtils.isBlank(propertyModel.getStrictCheckin())) {
						exceptions.put(messageUtil.getBundle("property.checkin.null.code"), new Exception(messageUtil.getBundle("property.checkin.null.message")));
					} else {
						if (!(propertyModel.getStrictCheckin().equals(PropertyAddConstant.STR_Y) || propertyModel.getStrictCheckin().equals(PropertyAddConstant.STR_N))) {
							exceptions.put(messageUtil.getBundle("property.checkin.invalid.code"), new Exception(messageUtil.getBundle("property.checkin.invalid.message")));
						}
					}
		
					// Property Vs Image **Optional
		
					// Property Vs NearBy
					if (Objects.isNull(propertyModel.getPropertyVsNearbyModels())) {
						exceptions.put(messageUtil.getBundle("property.nearby.null.code"), new Exception(messageUtil.getBundle("property.nearby.null.message")));
					} else {
						// Address Validation
						for (PropertyVsNearbyModel propertyVsNearbyModel : propertyModel.getPropertyVsNearbyModels()) {
							if (StringUtils.isBlank(propertyVsNearbyModel.getPlaces())) {
								exceptions.put(messageUtil.getBundle("property.place.null.code"), new Exception(messageUtil.getBundle("property.place.null.message")));
							}
						}
					}
		
					// PropertyVs PGCS
					if (Objects.isNull(propertyModel.getPgCategorySexModel())) {
						exceptions.put(messageUtil.getBundle("property.pgcs.null.code"), new Exception(messageUtil.getBundle("property.pgcs.null.message")));
					} else {
						if (StringUtils.isEmpty(propertyModel.getPgCategorySexModel().getPgcsId())) {
							exceptions.put(messageUtil.getBundle("property.pgcs.null.code"), new Exception(messageUtil.getBundle("property.pgcs.null.message")));
						} else {
							if (!Util.isNumeric(propertyModel.getPgCategorySexModel().getPgcsId())) {
								exceptions.put(messageUtil.getBundle("property.pgcs.numeric.code"), new Exception(messageUtil.getBundle("property.pgcs.numeric.message")));
							} else {
								PGCategorySexEntity pgCategorySexEntity = pgCategorySexDAO.find(Long.valueOf(propertyModel.getPgCategorySexModel().getPgcsId()));
								if (Objects.isNull(pgCategorySexEntity) && pgCategorySexEntity.getStatus() != Status.ACTIVE.ordinal()) {
									exceptions.put(messageUtil.getBundle("property.pgcs.invalid.code"), new Exception(messageUtil.getBundle("property.pgcs.invalid.message")));
								}
							}
						}
					}
		
					// Property Vs Space Rule
					if (Objects.isNull(propertyModel.getPropertyVsSpaceRuleModels())) {
						exceptions.put(messageUtil.getBundle("property.spacerule.null.code"), new Exception(messageUtil.getBundle("property.spacerule.null.message")));
					} else {
						// Space Rule Validation
						for (PropertyVsSpaceRuleModel propertyVsSpaceRuleModel : propertyModel.getPropertyVsSpaceRuleModels()) {
							if (StringUtils.isBlank(propertyVsSpaceRuleModel.getAnswer())) {
								exceptions.put(messageUtil.getBundle("property.spacerule.answer.null.code"), new Exception(messageUtil.getBundle("property.sp.answer.null.message")));
							} else {
								if (!(propertyVsSpaceRuleModel.getAnswer().equals(PropertyAddConstant.STR_Y) || propertyVsSpaceRuleModel.getAnswer().equals(PropertyAddConstant.STR_N))) {
									exceptions.put(messageUtil.getBundle("property.spacerule.invalid.code"), new Exception(messageUtil.getBundle("property.spacerule.invalid.message")));
								}
							}
		
							// Validate Space Rule
							if (Objects.isNull(propertyVsSpaceRuleModel.getSpaceRuleModel())) {
								exceptions.put(messageUtil.getBundle("space.rule.null.code"), new Exception(messageUtil.getBundle("space.rule.null.message")));
							} else {
		
								if (StringUtils.isBlank(propertyVsSpaceRuleModel.getSpaceRuleModel().getSpruleId())) {
									exceptions.put(messageUtil.getBundle("space.rule.null.code"), new Exception(messageUtil.getBundle("space.rule.null.message")));
								} else {
		
									if (!Util.isNumeric(propertyVsSpaceRuleModel.getSpaceRuleModel().getSpruleId())) {
										exceptions.put(messageUtil.getBundle("sprule.nonnumeric.code"), new Exception(messageUtil.getBundle("sprule.nonnumeric.message")));
									} else {
		
										SpaceRuleEntity spaceRuleEntity = spaceRuleDAO.find(Long.parseLong(propertyVsSpaceRuleModel.getSpaceRuleModel().getSpruleId()));
										if (Objects.isNull(spaceRuleEntity) && spaceRuleEntity.getStatus() != Status.ACTIVE.ordinal()) {
											exceptions.put(messageUtil.getBundle("sprule.invalid.code"), new Exception(messageUtil.getBundle("sprule.invalid.message")));
										}
									}
								}
		
							}
						}
					}
		
					// Property vs Special Experience
		
					if (Objects.isNull(propertyModel.getPropertyVsSpecialExperienceModels())) {
						exceptions.put(messageUtil.getBundle("special.expe.null.code"), new Exception(messageUtil.getBundle("special.expe.null.message")));
					} else {
						// Answer Validation
						for (PropertyVsSpecialExperienceModel propertyVsExperienceModel : propertyModel.getPropertyVsSpecialExperienceModels()) {
							if (Objects.isNull(propertyVsExperienceModel.getSpecialExperienceModel())) {
								exceptions.put(messageUtil.getBundle("special.expe.null.code"), new Exception(messageUtil.getBundle("special.expe.null.message")));
							} else {
		
								if (StringUtils.isEmpty(propertyVsExperienceModel.getSpecialExperienceModel().getExperienceId())) {
									exceptions.put(messageUtil.getBundle("special.expe.null.code"), new Exception(messageUtil.getBundle("special.expe.null.message")));
								} else {
									if (!Util.isNumeric(propertyVsExperienceModel.getSpecialExperienceModel().getExperienceId())) {
										exceptions.put(messageUtil.getBundle("special.expe.invalid.code"), new Exception(messageUtil.getBundle("special.expe.invalid.message")));
									} else {
		
										SpecialExperienceEntity specialExperienceEntity = specialExperienceDAO.find(Long.parseLong(propertyVsExperienceModel.getSpecialExperienceModel().getExperienceId()));
										if (Objects.isNull(specialExperienceEntity) && specialExperienceEntity.getStatus() != Status.ACTIVE.ordinal()) {
											exceptions.put(messageUtil.getBundle("special.expe.invalid.code"), new Exception(messageUtil.getBundle("special.expe.invalid.message")));
										}
									}
								}
		
							}
		
						}
					}
		
					// User vs Account
					if (Objects.isNull(propertyModel.getUserVsAccountModel())) {
						exceptions.put(messageUtil.getBundle("property.user.null.code"), new Exception(messageUtil.getBundle("property.user.null.message")));
					} else {
						if (Util.isEmpty(propertyModel.getUserVsAccountModel().getAccountHolderName())) {
							exceptions.put(messageUtil.getBundle("accholder.name.null.code"), new Exception(messageUtil.getBundle("accholder.name.null.message")));
						}
						if (Util.isEmpty(propertyModel.getUserVsAccountModel().getAccountNumber())) {
							exceptions.put(messageUtil.getBundle("account.no.null.code"), new Exception(messageUtil.getBundle("account.no.null.message")));
						}
						if (Util.isEmpty(propertyModel.getUserVsAccountModel().getAccountType())) {
							exceptions.put(messageUtil.getBundle("account.type.null.code"), new Exception(messageUtil.getBundle("account.type.null.message")));
						}
						if (Util.isEmpty(propertyModel.getUserVsAccountModel().getIfscCode())) {
							exceptions.put(messageUtil.getBundle("ifsc.code.null.code"), new Exception(messageUtil.getBundle("ifsc.code.null.message")));
						}
					}
		
					// Property Vs Document
					if (Objects.isNull(propertyModel.getPropertyVsDocumentModels())) {
						exceptions.put(messageUtil.getBundle("property.document.null.code"), new Exception(messageUtil.getBundle("property.document.null.message")));
					} else {
		
						for (PropertyVsDocumentModel propertyVsDocumentModel : propertyModel.getPropertyVsDocumentModels()) {
		
							if (Objects.isNull(propertyVsDocumentModel.getDocumentModel())) {
								exceptions.put(messageUtil.getBundle("document.null.code"), new Exception(messageUtil.getBundle("document.null.message")));
							} else {
								if (Util.isEmpty(propertyVsDocumentModel.getDocumentModel().getDocumentId())) {
									exceptions.put(messageUtil.getBundle("document.null.code"), new Exception(messageUtil.getBundle("document.null.message")));
								} else {
									if (!Util.isNumeric(propertyVsDocumentModel.getDocumentModel().getDocumentId())) {
										exceptions.put(messageUtil.getBundle("document.id.nonnumeric.code"), new Exception(messageUtil.getBundle("document.id.nonnumeric.message")));
									} else {
										DocumentEntity documentEntity = documentDAO.find(Long.valueOf(propertyVsDocumentModel.getDocumentModel().getDocumentId()));
										if (Objects.isNull(documentEntity) && documentEntity.getStatus() != Status.ACTIVE.ordinal()) {
											exceptions.put(messageUtil.getBundle("document.id.invalid.code"),new Exception(messageUtil.getBundle("document.id.invalid.message")));
										}
									}
								}
							}
		
							if (StringUtils.isBlank(propertyVsDocumentModel.getFileUrl())) {
								exceptions.put(messageUtil.getBundle("property.document.file.null.code"),new Exception(messageUtil.getBundle("property.document.file.null.message")));
							}
						}
					}
		
////////////////////////////////////////////////////////////////// Room Data Validation /////////// /////////////////////////////////////////////////////////////////////
		
					if (Objects.nonNull(propertyModel.getRoomModels())) {
		
						for (RoomModel roomModel : propertyModel.getRoomModels()) {
		
							// Shared Space
							if (StringUtils.isBlank(roomModel.getSharedSpace())) {
								exceptions.put(messageUtil.getBundle("room.sharedSpace.null.code"),new Exception(messageUtil.getBundle("room.sharedSpace.null.message")));
							} else {
		
								if (!(roomModel.getSharedSpace().equals(PropertyAddConstant.STR_Y) || roomModel.getSharedSpace().equals(PropertyAddConstant.STR_N))) {
									exceptions.put(messageUtil.getBundle("room.sharedSpace.invalid.code"), new Exception(messageUtil.getBundle("room.sharedSpace.invalid.message")));
								}
							}
		
							// CotAvailable
							if (!StringUtils.isBlank(roomModel.getCotAvailable())) {
								if (!(roomModel.getCotAvailable().equals(PropertyAddConstant.STR_Y) || roomModel.getCotAvailable().equals(PropertyAddConstant.STR_N))) {
									exceptions.put(messageUtil.getBundle("room.cotavail.invalid.code"), new Exception(messageUtil.getBundle("room.cotavail.invalid.message")));
								}
							}
		
							// No Of Guest
							if (!StringUtils.isBlank(roomModel.getNoOfGuest())) {
								if (!Util.isNumeric(roomModel.getNoOfGuest())) {
									exceptions.put(messageUtil.getBundle("room.noofguest.numeric.code"), new Exception(messageUtil.getBundle("room.noofguest.numeric.message")));
								}
							}
		
							// No of Child
							if (!StringUtils.isBlank(roomModel.getNoOfChild())) {
								if (!Util.isNumeric(roomModel.getNoOfChild())) {
									exceptions.put(messageUtil.getBundle("room.noofchild.numeric.code"), new Exception(messageUtil.getBundle("room.noofchild.numeric.message")));
								}
							}
		
							// not of Cot
							if (StringUtils.isBlank(roomModel.getNumOfCot())) {
								if (!Util.isNumeric(roomModel.getNumOfCot())) {
									exceptions.put(messageUtil.getBundle("room.numofCot.numeric.code"), new Exception(messageUtil.getBundle("room.numofCot.numeric.message")));
								}
							}
		
							// Accommodation Check
							if (Objects.isNull(roomModel.getAccommodationModel())) {
								exceptions.put(messageUtil.getBundle("room.accommodation.null.code"), new Exception(messageUtil.getBundle("room.accommodation.null.message")));
							} else {
		
								if (StringUtils.isEmpty(roomModel.getAccommodationModel().getAccommodationId())) {
									exceptions.put(messageUtil.getBundle("room.accommodation.null.code"), new Exception(messageUtil.getBundle("room.accommodation.null.message")));
								} else {
									if (!Util.isNumeric(roomModel.getAccommodationModel().getAccommodationId())) {
										exceptions.put(messageUtil.getBundle("room.accommodation.invalid.code"), new Exception(messageUtil.getBundle("room.accommodation.invalid.message")));
									} else {
										AccommodationEntity accommodationEntity = accommodationDAO.find(Long.parseLong(roomModel.getAccommodationModel().getAccommodationId()));
										if (Objects.isNull(accommodationEntity) && accommodationEntity.getStatus() != Status.ACTIVE.ordinal()) {
											exceptions.put(messageUtil.getBundle("room.accommodation.invalid.code"), new Exception(messageUtil.getBundle("room.accommodation.invalid.message")));
										} else if (accommodationEntity.getAccommodationName() == String.valueOf(Accommodation.Shared.ordinal())) {
											// Room Vs Bed
											if (Objects.isNull(roomModel.getRoomVsBedModel())) {
												exceptions.put(messageUtil.getBundle("room.vs.bed.null.code"), new Exception(messageUtil.getBundle("room.vs.bed.null.message")));
											} else {
												if (StringUtils.isEmpty(roomModel.getRoomVsBedModel().getNoOfBeds())) {
													exceptions.put(messageUtil.getBundle("room.vs.bed.null.code"), new Exception(messageUtil.getBundle("room.vs.bed.null.message")));
												} else if (!Util.isNumeric(roomModel.getRoomVsBedModel().getNoOfBeds())) {
													exceptions.put(messageUtil.getBundle("room.no.of.bed.numeric.code"), new Exception(messageUtil.getBundle("room.no.of.bed.numeric.message")));
												}
											}
										}
									}
								}
		
							}
		
							// Room Category Validation
							if (Objects.isNull(roomModel.getRoomCategoryModel())) {
								exceptions.put(messageUtil.getBundle("room.category.null.code"), new Exception(messageUtil.getBundle("room.category.null.message")));
							} else {
		
								if (StringUtils.isEmpty(roomModel.getRoomCategoryModel().getRoomCatId())) {
									exceptions.put(messageUtil.getBundle("room.category.null.code"), new Exception(messageUtil.getBundle("room.category.null.message")));
								} else {
									if (!Util.isNumeric(roomModel.getRoomCategoryModel().getRoomCatId())) {
										exceptions.put(messageUtil.getBundle("room.category.numeric.code"), new Exception(messageUtil.getBundle("room.category.numeric.message")));
									} else {
										RoomCategoryEntity roomCategoryEntity = roomCategoryDAO.find(Long.parseLong(roomModel.getRoomCategoryModel().getRoomCatId()));
										if (Objects.isNull(roomCategoryEntity) && roomCategoryEntity.getStatus() != Status.ACTIVE.ordinal()) {
											exceptions.put(messageUtil.getBundle("room.category.invalid.code"), new Exception(messageUtil.getBundle("room.category.invalid.message")));
										}
									}
								}
		
							}
		
							// Room Vs Amenities
							if (Objects.isNull(roomModel.getRoomVsAmenitiesModels())) {
								exceptions.put(messageUtil.getBundle("room.vs.amenities.null.code"), new Exception(messageUtil.getBundle("room.vs.amenities.null.message")));
							} else {
								int expressFlagY = 0;
								int premiumFlagY = 0;
								for (RoomVsAmenitiesModel roomVsAmenitiesModel : roomModel.getRoomVsAmenitiesModels()) {
									if (Objects.nonNull(roomVsAmenitiesModel.getAmenitiesModel())) {
										if (StringUtils.isBlank(roomVsAmenitiesModel.getAmenitiesModel().getAminitiesId())) {
											exceptions.put(messageUtil.getBundle("amenities.id.null.code"), new Exception(messageUtil.getBundle("amenities.id.null.message")));
										} else {
											if (!Util.isNumeric(roomVsAmenitiesModel.getAmenitiesModel().getAminitiesId())) {
												exceptions.put(messageUtil.getBundle("amenities.id.numeric.code"), new Exception(messageUtil.getBundle("amenities.id.numeric.message")));
											} else {
												AmenitiesEntity amenitiesEntity = amenitiesDAO.find(Long.parseLong(roomVsAmenitiesModel.getAmenitiesModel().getAminitiesId()));
												if (Objects.isNull(amenitiesEntity) && amenitiesEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("amenities.invalid.code"), new Exception(messageUtil.getBundle("amenities.invalid.message")));
												} else {
													//
													if(amenitiesEntity.getExpressFlag().equals(PropertyAddConstant.STR_Y)){
														expressFlagY++;
													}
													if(amenitiesEntity.getPremiumFlag().equals(PropertyAddConstant.STR_Y)){
														premiumFlagY++;
													}
													
												} 
												
											}
		
										}
									} else {
										exceptions.put(messageUtil.getBundle("amenities.null.code"), new Exception(messageUtil.getBundle("amenities.null.message")));
									}
								}
								// Room Standard Validation
								//Logic For Room Stand
								/*String expressCount = messageUtil.getBundle("express.flag.count");
								String premiumCount = messageUtil.getBundle("premium.flg.count");
								List<RoomStandardModel> roomStandardModels = roomStandardConverter.entityListToModelList(roomStandardDAO.findAll());
								
								for(RoomStandardModel roomStandardModel:roomStandardModels){
									//Same Logic for Update
									if(roomStandardModel.getFlagCount().equals(PropertyAddConstant.STR_P) && premiumFlagY >= Integer.valueOf(roomStandardModel.getFlagCount())) {
										// Premium
										// fetch Premium Id from Room Standard Table and set to roomModel.RoomStandardModel.roomStandardId
									} else if(roomStandardModel.getFlagCount().equals(PropertyAddConstant.STR_E) && expressFlagY >= Integer.valueOf(roomStandardModel.getFlagCount())) {
										// Express
										// fetch Express Id from Room Standard Table and set to roomModel.RoomStandardModel.roomStandardId
									} else {
										// Normal
										// fetch Normal Id from Room Standard Table and set to roomModel.RoomStandardModel.roomStandardId
									}
								}*/
								
							}
		
							// Room Vs Cancellation
							if (Objects.isNull(roomModel.getRoomVsCancellationModels())) {
								exceptions.put(messageUtil.getBundle("room.vs.cancellation.null.code"), new Exception(messageUtil.getBundle("room.vs.cancellation.null.message")));
							} else {
								for (RoomVsCancellationModel roomVsCancellationModel : roomModel .getRoomVsCancellationModels()) {
		
									// Percentage
									if (StringUtils.isBlank(roomVsCancellationModel.getPercentage())) {
										exceptions.put(messageUtil.getBundle("room.vs.cancellation.percentage.null.code"), new Exception(messageUtil.getBundle("room.vs.cancellation.percentage.null.message")));
									} else {
										if (!Util.isNumeric(roomVsCancellationModel.getPercentage())) {
											exceptions.put(messageUtil.getBundle("room.vs.cancellation.percentage.numeric.code"),new Exception(messageUtil.getBundle("room.vs.cancellation.percentage.numeric.message")));
										}
									}
		
									// Cancellation Slab Validation
									if (Objects.nonNull(roomVsCancellationModel.getCancellationSlabModel())) {
										if (StringUtils.isBlank(roomVsCancellationModel.getCancellationSlabModel().getCancellationSlabId())) {
											exceptions.put(messageUtil.getBundle("cancellation.slab.null.code"),new Exception(messageUtil.getBundle("cancellation..slab.null.message")));
										} else {
											if (!Util.isNumeric(roomVsCancellationModel.getCancellationSlabModel().getCancellationSlabId())) {
												exceptions.put(messageUtil.getBundle("cancellation.slab.numeric.code"),new Exception(messageUtil.getBundle("cancellation.slab.numeric.message")));
											} else {
												CancellationSlabEntity cancellationSlabEntity = cancellationSlabDAO.find(Long.parseLong(roomVsCancellationModel.getCancellationSlabModel().getCancellationSlabId()));
												if (Objects.isNull(cancellationSlabEntity) && cancellationSlabEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("cancellation.invalid.code"), new Exception(messageUtil.getBundle("cancellation.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("cancellation.slab.null.code"), new Exception(messageUtil.getBundle("cancellation.slab.null.message")));
									}
								}
							}
		
							// Room Vs Image
		
							// Room Vs Price
							if (Objects.nonNull(roomModel.getRoomVsPriceModels())) {
								for (RoomVsPriceModel roomVsPriceModel : roomModel.getRoomVsPriceModels()) {
		
									// Value
									if (StringUtils.isEmpty(roomVsPriceModel.getValue())) {
										exceptions.put(messageUtil.getBundle("price.value.null.code"), new Exception(messageUtil.getBundle("price.value.null.message")));
									} else if (!Util.isNumeric(roomVsPriceModel.getValue())) {
										exceptions.put(messageUtil.getBundle("price.value.numeric.code"), new Exception(messageUtil.getBundle("price.value.numeric.message")));
									}
		
									// Price Type
									if (Objects.nonNull(roomVsPriceModel.getPriceTypeModel())) {
										if (StringUtils.isEmpty(roomVsPriceModel.getPriceTypeModel().getPriceTypeId())) {
											exceptions.put(messageUtil.getBundle("price.type.null.code"), new Exception(messageUtil.getBundle("price.type.null.message")));
										} else {
											if (!Util.isNumeric(roomVsPriceModel.getPriceTypeModel().getPriceTypeId())) {
												exceptions.put(messageUtil.getBundle("price.type.id.numeric.code"), new Exception(messageUtil.getBundle("price.type.id.numeric.message")));
											} else {
												PriceTypeEntity priceTypeEntity = priceTypeDAO.find(Long.valueOf(roomVsPriceModel.getPriceTypeModel().getPriceTypeId()));
												if (Objects.isNull(priceTypeEntity) && priceTypeEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("price.type.id.invalid.code"), new Exception(messageUtil.getBundle("price.type.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("price.type.null.code"), new Exception(messageUtil.getBundle("price.type.null.message")));
									}
								}
		
							} else {
								exceptions.put(messageUtil.getBundle("room.vs.price.null.code"), new Exception(messageUtil.getBundle("room.vs.price.null.message")));
							}
		
							// Room vs host discount
		
							if (Objects.nonNull(roomModel.getRoomVsHostDiscountModels())) {
								for (RoomVsHostDiscountModel roomVsHostDiscountModel : roomModel.getRoomVsHostDiscountModels()) {
		
									// Percentage
									if (StringUtils.isEmpty(roomVsHostDiscountModel.getPercentage())) {
										exceptions.put(messageUtil.getBundle("discount.percentage.null.code"), new Exception(messageUtil.getBundle("discount.percentage.null.message")));
									} else if (!Util.isNumeric(roomVsHostDiscountModel.getPercentage())) {
										exceptions.put(messageUtil.getBundle("discount.percentage.numeric.code"), new Exception(messageUtil.getBundle("discount.percentage.numeric.message")));
									}
		
									// Room Vs Discount Category Host
									if (Objects.nonNull(roomVsHostDiscountModel.getDiscountCategoryHostModel())) {
										if (StringUtils.isEmpty(roomVsHostDiscountModel.getDiscountCategoryHostModel().getDchId())) {
											exceptions.put(messageUtil.getBundle("discount.category.null.code"), new Exception(messageUtil.getBundle("discount.category.null.message")));
										} else {
											if (!Util.isNumeric(roomVsHostDiscountModel.getDiscountCategoryHostModel().getDchId())) {
												exceptions.put(messageUtil.getBundle("discount.category.id.numeric.code"), new Exception(messageUtil.getBundle("discount.category.id.numeric.message")));
											} else {
												DiscountCategoryHostEntity discountCategoryHostEntity = discountCategoryHostDAO.find(Long.valueOf(roomVsHostDiscountModel.getDiscountCategoryHostModel().getDchId()));
												if (Objects.isNull(discountCategoryHostEntity) && discountCategoryHostEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("discount.category.id.invalid.code"), new Exception(messageUtil.getBundle("discount.category.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("discount.category.null.code"), new Exception(messageUtil.getBundle("discount.category.null.message")));
									}
								}
		
							} else {
								exceptions.put(messageUtil.getBundle("discount.category.null.code"), new Exception(messageUtil.getBundle("discount.category.null.message")));
							}
							// Room Vs Ora discount
							// Logic For Code Set
		
							// Room Vs Ora Price Percentage
							// Logic For Code Set
		
							// Room Vs Specialities
							if (Objects.nonNull(roomModel.getRoomVsSpecialitiesModels())) {
								for (RoomVsSpecialitiesModel roomVsSpecialitiesModel : roomModel.getRoomVsSpecialitiesModels()) {
		
									// Specialities
									if (Objects.nonNull(roomVsSpecialitiesModel.getSpecialtiesModel())) {
										if (StringUtils.isEmpty(roomVsSpecialitiesModel.getSpecialtiesModel().getSpecialtiesId())) {
											exceptions.put(messageUtil.getBundle("specilities.null.code"),new Exception(messageUtil.getBundle("specilities.null.message")));
										} else {
											if (!Util.isNumeric(roomVsSpecialitiesModel.getSpecialtiesModel().getSpecialtiesId())) {
												exceptions.put(messageUtil.getBundle("specilities.id.numeric.code"), new Exception(messageUtil.getBundle("specilities.id.numeric.message")));
											} else {
												SpecialtiesEntity specialtiesEntity = specialtiesDAO.find(Long.valueOf(roomVsSpecialitiesModel.getSpecialtiesModel().getSpecialtiesId()));
												if (Objects.isNull(specialtiesEntity) && specialtiesEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("specilities.id.invalid.code"), new Exception(messageUtil.getBundle("specilities.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("specilities.null.code"),new Exception(messageUtil.getBundle("specilities.null.message")));
									}
								}
		
							} else {
								exceptions.put(messageUtil.getBundle("specilities.null.code"),new Exception(messageUtil.getBundle("specilities.null.message")));
							}
		
							// Room Vs Meal
							if (Objects.nonNull(roomModel.getRoomVsMealModels())) {
								for (RoomVsMealModel roomVsMealModel : roomModel.getRoomVsMealModels()) {
									MealCategoryEntity mealCategoryEntity = null;
									// Meal Category Validation
									if (Objects.nonNull(roomVsMealModel.getMealCategoryModel())) {
										if (StringUtils.isEmpty(roomVsMealModel.getMealCategoryModel().getMealCategoryId())) {
											exceptions.put(messageUtil.getBundle("meal.category.null.code"), new Exception(messageUtil.getBundle("meal.category.null.message")));
										} else {
											if (!Util.isNumeric(roomVsMealModel.getMealCategoryModel().getMealCategoryId())) {
												exceptions.put(messageUtil.getBundle("meal.category.numeric.code"), new Exception(messageUtil.getBundle("meal.category.numeric.message")));
											} else {
												mealCategoryEntity = mealCategoryDAO.find(Long.valueOf(roomVsMealModel.getMealCategoryModel().getMealCategoryId()));
												if (Objects.isNull(mealCategoryEntity) && mealCategoryEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("meal.category.id.invalid.code"), new Exception(messageUtil.getBundle("meal.category.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("meal.category.null.code"), new Exception(messageUtil.getBundle("meal.category.null.message")));
									}
		
									if (Objects.nonNull(mealCategoryEntity)) {
										if (mealCategoryEntity.getMealCatName() == String.valueOf(MealCategory.Daily.ordinal())) {
											// Meal Days Validation
											if (Objects.nonNull(roomVsMealModel.getMealDaysModel())) {
												if (StringUtils.isEmpty(roomVsMealModel.getMealDaysModel().getMealDaysId())) {
													exceptions.put(messageUtil.getBundle("meal.days.null.code"), new Exception(messageUtil.getBundle("meal.days.null.message")));
												} else {
													if (!Util.isNumeric(roomVsMealModel.getMealDaysModel().getMealDaysId())) {
														exceptions.put(messageUtil.getBundle("meal.days.numeric.code"), new Exception(messageUtil.getBundle("meal.days.numeric.message")));
													} else {
														MealDaysEntity mealDaysEntity = mealDaysDAO.find(Long.valueOf(roomVsMealModel.getMealDaysModel().getMealDaysId()));
														if (Objects.isNull(mealDaysEntity) && mealDaysEntity.getStatus() != Status.ACTIVE.ordinal()) {
															exceptions.put(messageUtil.getBundle("meal.days.id.invalid.code"), new Exception(messageUtil .getBundle("meal.days.id.invalid.message")));
														}
													}
												}
											} else {
												exceptions.put(messageUtil.getBundle("meal.days.null.code"), new Exception(messageUtil.getBundle("meal.days.null.message")));
											}
										}
									}
		
									// Master Meal Price Category
									if (Objects.nonNull(roomVsMealModel.getMealPriceCategoryModel())) {
										if (StringUtils.isEmpty(roomVsMealModel.getMealPriceCategoryModel().getMmpcId())) {
											exceptions.put(messageUtil.getBundle("meal.price.null.code"), new Exception(messageUtil.getBundle("meal.price.null.message")));
										} else {
											if (!Util.isNumeric(roomVsMealModel.getMealPriceCategoryModel().getMmpcId())) {
												exceptions.put(messageUtil.getBundle("meal.price.numeric.code"), new Exception(messageUtil.getBundle("meal.price.numeric.message")));
											} else {
												MealPriceCategoryEntity mealPriceCategoryEntity = mealPriceCategoryDAO.find(Long.valueOf(roomVsMealModel.getMealPriceCategoryModel().getMmpcId()));
												if (Objects.isNull(mealPriceCategoryEntity) && mealPriceCategoryEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("meal.price.id.invalid.code"), new Exception(messageUtil.getBundle("meal.price.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("meal.price.null.code"), new Exception(messageUtil.getBundle("meal.price.null.message")));
									}
		
									// Meal Type Validation
									if (Objects.nonNull(roomVsMealModel.getMealTypeModel())) {
										if (StringUtils.isEmpty(roomVsMealModel.getMealTypeModel().getMealTypeId())) {
											exceptions.put(messageUtil.getBundle("meal.type.null.code"), new Exception(messageUtil.getBundle("meal.type.null.message")));
										} else {
											if (!Util.isNumeric(roomVsMealModel.getMealTypeModel().getMealTypeId())) {
												exceptions.put(messageUtil.getBundle("meal.type.numeric.code"), new Exception(messageUtil.getBundle("meal.type.numeric.message")));
											} else {
												MealTypeEntity mealTypeEntity = mealTypeDAO.find(Long.valueOf(roomVsMealModel.getMealTypeModel().getMealTypeId()));
												if (Objects.isNull(mealTypeEntity) && mealTypeEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("meal.type.id.invalid.code"), new Exception(messageUtil.getBundle("meal.type.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("meal.type.null.code"), new Exception(messageUtil.getBundle("meal.type.null.message")));
									}
		
								}
		
							} else {
								exceptions.put(messageUtil.getBundle("meal.category.null.code"), new Exception(messageUtil.getBundle("meal.category.null.message")));
							}
		
						}
		
					} else {
						exceptions.put(messageUtil.getBundle("property.room.null.code"), new Exception(messageUtil.getBundle("property.room.null.message")));
					}
		
				
			 } else { 
				 exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message"))); 
			 }
			
			
		} else { 
				 exceptions.put(messageUtil.getBundle("property.null.code"), new Exception(messageUtil.getBundle("property.null.message"))); 
		 }
			
	
			if (exceptions.size() > 0)
				throw new FormExceptions(exceptions);
	
			if (logger.isDebugEnabled()) {
				logger.debug("validatePropertyAdd -- End");
			}
			
			return userModel;
	
		}
	
	public UserModel validatePropertyUpdate(PropertyModel propertyModel) throws FormExceptions {

		if (logger.isDebugEnabled()) {
			logger.debug("validatePropertyUpdate -- Start");
		}

		Util.printLog(propertyModel, PropertyAddConstant.INCOMING, "Property Update", request);
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		UserModel userModel = null;
		if (Objects.nonNull(propertyModel)) {
			
			userModel =  getUserDetails(propertyModel.getUserToken());
			
			if(Objects.nonNull(userModel)) {
				
				// Validate Host Login Details
				if(Objects.nonNull(userModel)){
					if(Objects.nonNull(userModel.getUserVsTypes())){
						boolean flag = false;
						for(UserVsTypeModel userVsTypeModel : userModel.getUserVsTypes()){
							if(Objects.nonNull(userVsTypeModel.getUserType())) {
								if(userVsTypeModel.getUserType().getUserTypeId().equals(String.valueOf(UserType.HOST.ordinal()))){
									flag = true;
								}
							} else {
								exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
							}
						}
						
						if(!flag){
							exceptions.put(messageUtil.getBundle("user.type.invalid.code"), new Exception(messageUtil.getBundle("user.type.invalid.message")));
						}
					} else {
						exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
					}
				} else {
					exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message")));
				}				
					// Validate Property Name
					if (StringUtils.isBlank(propertyModel.getName())) {
						exceptions.put(messageUtil.getBundle("property.name.null.code"), new Exception(messageUtil.getBundle("property.name.null.message")));
					} else {
						if (!Util.checkAlphabet(propertyModel.getName())) {
							exceptions.put(messageUtil.getBundle("property.name.invalid.code"), new Exception(messageUtil.getBundle("property.name.invalid.message")));
						}
					}
		
					if (StringUtils.isBlank(propertyModel.getOraname())) {
						exceptions.put(messageUtil.getBundle("ora.name.null.code"), new Exception(messageUtil.getBundle("ora.name.null.message")));
					} 
		
					// validate Entire Apartment
					if (StringUtils.isBlank(propertyModel.getEntireApartment())) {
						exceptions.put(messageUtil.getBundle("entire.appartment.null.code"), new Exception(messageUtil.getBundle("entire.appartment.null.message")));
					} else {
						if (!(propertyModel.getEntireApartment().equals(PropertyAddConstant.STR_Y) || propertyModel.getEntireApartment().equals(PropertyAddConstant.STR_N))) {
							exceptions.put(messageUtil.getBundle("entire.appartment.invalid.code"), new Exception(messageUtil.getBundle("entire.appartment.invalid.message")));
						}
					}
		
					// Validate Latitude
					if (StringUtils.isBlank(propertyModel.getLatitude())) {
						exceptions.put(messageUtil.getBundle("latitude.null.code"), new Exception(messageUtil.getBundle("latitude.null.message")));
					} else {
						if (!Util.checkLatitude(propertyModel.getLatitude())) {
							exceptions.put(messageUtil.getBundle("latitude.invalid.code"), new Exception(messageUtil.getBundle("latitude.invalid.message")));
						}
					}
		
					// Validate Longitude
					if (StringUtils.isBlank(propertyModel.getLongitude())) {
						exceptions.put(messageUtil.getBundle("longitude.null.code"), new Exception(messageUtil.getBundle("longitude.null.message")));
					} else {
						if (!Util.checkLongitude(propertyModel.getLongitude())) {
							exceptions.put(messageUtil.getBundle("longitude.invalid.code"), new Exception(messageUtil.getBundle("longitude.invalid.message")));
						}
					}
		
					// Validate Address
					if (StringUtils.isBlank(propertyModel.getAddress())) {
						exceptions.put(messageUtil.getBundle("address.null.code"),new Exception(messageUtil.getBundle("address.null.message")));
					}
		
					// Validate Start End Date
					if (StringUtils.isBlank(propertyModel.getStartDate())) {
						exceptions.put(messageUtil.getBundle("start.date.null.code"), new Exception(messageUtil.getBundle("start.date.null.message")));
					} else {
						if (StringUtils.isBlank(propertyModel.getEndDate())) {
							exceptions.put(messageUtil.getBundle("end.date.null.code"), new Exception(messageUtil.getBundle("end.date.null.message")));
						} else {
							String startDate = propertyModel.getStartDate();
							String endDate = propertyModel.getEndDate();
							propertyModel.setStartDate(startDate + " 00:00:01");
							propertyModel.setEndDate(endDate + " 23:59:59");
							
						}
					}
		
					// Validate CheckIn Time
					if (StringUtils.isBlank(propertyModel.getCheckinTime())) {
						exceptions.put(messageUtil.getBundle("checkin.time.null.code"), new Exception(messageUtil.getBundle("checkin.time.null.message")));
					} else {
						if (!Util.checkTimeFormat(propertyModel.getCheckinTime())) {
							exceptions.put(messageUtil.getBundle("checkin.time.invalid.code"), new Exception(messageUtil.getBundle("checkin.time.invalid.message")));
						}
					}
		
					// Validate CheckOut Time
					if (StringUtils.isBlank(propertyModel.getCheckoutTime())) {
						exceptions.put(messageUtil.getBundle("checkout.time.null.code"), new Exception(messageUtil.getBundle("checkout.time.null.message")));
					} else {
						if (!Util.checkTimeFormat(propertyModel.getCheckoutTime())) {
							exceptions.put(messageUtil.getBundle("checkout.time.invalid.code"), new Exception(messageUtil.getBundle("checkout.time.invalid.message")));
						}
					}
		
					// Validate Image Url
					if (StringUtils.isBlank(propertyModel.getCoverImageUrl())) {
						exceptions.put(messageUtil.getBundle("image.url.null.code"), new Exception(messageUtil.getBundle("image.url.null.message")));
					}
		
					// Validate Price Drop
					if (StringUtils.isBlank(propertyModel.getPriceDrop())) {
						exceptions.put(messageUtil.getBundle("price.drop.null.code"), new Exception(messageUtil.getBundle("price.drop.null.message")));
					} else {
						if (!(propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_Y) || propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_N))) {
							exceptions.put(messageUtil.getBundle("price.drop.invalid.code"), new Exception(messageUtil.getBundle("price.drop.invalid.message")));
						}
					}
		
					// Validate Property Type
					if (Objects.isNull(propertyModel.getPropertyTypeModel())) {
						exceptions.put(messageUtil.getBundle("property.type.null.code"), new Exception(messageUtil.getBundle("property.type.null.message")));
					} else {
						if (StringUtils.isBlank(propertyModel.getPropertyTypeModel().getPropertyTypeId())) {
							exceptions.put(messageUtil.getBundle("property.type.id.null.code"), new Exception(messageUtil.getBundle("property.type.id.null.message")));
						} else {
							if (!Util.isNumeric(propertyModel.getPropertyTypeModel().getPropertyTypeId())) {
								exceptions.put(messageUtil.getBundle("property.type.id.invalid.code"), new Exception(messageUtil.getBundle("property.type.id.invalid.message")));
							} else {
								PropertyTypeEntity propertyTypeEntity = propertyTypeDAO.find(Long.parseLong(propertyModel.getPropertyTypeModel().getPropertyTypeId()));
								if (Objects.isNull(propertyTypeEntity) && propertyTypeEntity.getStatus() != Status.ACTIVE.ordinal()) {
									exceptions.put(messageUtil.getBundle("property.type.id.invalid.code"), new Exception(messageUtil.getBundle("property.type.id.invalid.message")));
								}
							}
						}
					}
		
					// Validate Property Vs Description
					if (Objects.isNull(propertyModel.getPropertyVsDescriptionModels())) {
						exceptions.put(messageUtil.getBundle("property.description.null.code"), new Exception(messageUtil.getBundle("property.description.null.message")));
					} else {
		
						for (PropertyVsDescriptionModel propertyVsDescriptionModel : propertyModel.getPropertyVsDescriptionModels()) {
							
							if(StringUtils.isBlank(propertyVsDescriptionModel.getPropertyDescId())){
								exceptions.put(messageUtil.getBundle("property.description.id.null.code"), new Exception(messageUtil.getBundle("property.description.id.null.message")));
							} else {
								if(Util.isNumeric(propertyVsDescriptionModel.getPropertyDescId())){
									
									PropertyVsDescriptionEntity propertyVsDescriptionEntity = propertyVsDescriptionDAO.find(Long.valueOf(propertyVsDescriptionModel.getPropertyDescId()));
									
									if(Objects.isNull(propertyVsDescriptionEntity)){
										exceptions.put(messageUtil.getBundle("property.description.id.invalid.code"), new Exception(messageUtil.getBundle("property.description.id.invalid.message")));
									}
								} else {
									exceptions.put(messageUtil.getBundle("property.description.id.numeric.code"), new Exception(messageUtil.getBundle("property.description.id.numeric.message")));
								}
							}
							
							
							if (StringUtils.isBlank(propertyVsDescriptionModel.getDescription())) {
								exceptions.put(messageUtil.getBundle("property.description.null.code"), new Exception(messageUtil.getBundle("property.description.null.message")));
							}
		
							if (StringUtils.isBlank(propertyVsDescriptionModel.getLanguageId())) {
								exceptions.put(messageUtil.getBundle("language.id.null.code"), new Exception(messageUtil.getBundle("language.id.null.message")));
							} else {
								//validateLanguage(propertyVsDescriptionModel.getLanguageId());
							}
						}
					}
		
					// Property Vs Guest Access
					if (Objects.isNull(propertyModel.getPropertyVsGuestAccessModels())) {
						exceptions.put(messageUtil.getBundle("property.guest.null.code"), new Exception(messageUtil.getBundle("property.guest.null.message")));
					} else {
		
						for (PropertyVsGuestAccessModel propertyVsGuestAccessModel : propertyModel.getPropertyVsGuestAccessModels()) {
							
							if(StringUtils.isBlank(propertyVsGuestAccessModel.getPropertyGAccessId())){
								exceptions.put(messageUtil.getBundle("property.ga.id.null.code"), new Exception(messageUtil.getBundle("property.ga.id.null.message")));
							} else {
								if(Util.isNumeric(propertyVsGuestAccessModel.getPropertyGAccessId())){
									
									PropertyVsGuestAccessEntity propertyVsGuestAccessEntity = propertyVsGuestAccessDAO.find(Long.valueOf(propertyVsGuestAccessModel.getPropertyGAccessId()));
									
									if(Objects.isNull(propertyVsGuestAccessEntity)){
										exceptions.put(messageUtil.getBundle("property.ga.id.invalid.code"), new Exception(messageUtil.getBundle("property.ga.id.invalid.message")));
									}
								} else {
									exceptions.put(messageUtil.getBundle("property.ga.id.numeric.code"), new Exception(messageUtil.getBundle("property.ga.id.numeric.message")));
								}
							}
							
							if (StringUtils.isBlank(propertyVsGuestAccessModel.getGuestAccess())) {
								exceptions.put(messageUtil.getBundle("property.guest.null.code"), new Exception(messageUtil.getBundle("property.guest.null.message")));
							}
		
							if (StringUtils.isBlank(propertyVsGuestAccessModel.getLanguageId())) {
								exceptions.put(messageUtil.getBundle("language.id.null.code"), new Exception(messageUtil.getBundle("language.id.null.message")));
							} else {
								//validateLanguage(propertyVsGuestAccessModel.getLanguageId());
							}
						}
					}
		
					// Immediate Booking
					if (StringUtils.isBlank(propertyModel.getImmediateBooking())) {
						exceptions.put(messageUtil.getBundle("property.immbooking.null.code"), new Exception(messageUtil.getBundle("property.immbooking.null.message")));
					} else {
						if (!(propertyModel.getImmediateBooking().equals(PropertyAddConstant.STR_Y) || propertyModel.getImmediateBooking().equals(PropertyAddConstant.STR_N))) {
							exceptions.put(messageUtil.getBundle("property.immbooking.invalid.code"), new Exception(messageUtil.getBundle("property.immbooking.invalid.message")));
						}
					}
		
					// Strict Checkin
					if (StringUtils.isBlank(propertyModel.getStrictCheckin())) {
						exceptions.put(messageUtil.getBundle("property.checkin.null.code"), new Exception(messageUtil.getBundle("property.checkin.null.message")));
					} else {
						if (!(propertyModel.getStrictCheckin().equals(PropertyAddConstant.STR_Y) || propertyModel.getStrictCheckin().equals(PropertyAddConstant.STR_N))) {
							exceptions.put(messageUtil.getBundle("property.checkin.invalid.code"), new Exception(messageUtil.getBundle("property.checkin.invalid.message")));
						}
					}
		
					// Property Vs Image **Optional
					if(Objects.nonNull(propertyModel.getPropertyVsImageModels())){
						for(PropertyVsImageModel propertyVsImageModel : propertyModel.getPropertyVsImageModels()){
							
							//Validate Property Vs Image Id
							if(StringUtils.isBlank(propertyVsImageModel.getPropertyImageId())){
								exceptions.put(messageUtil.getBundle("property.image.id.null.code"), new Exception(messageUtil.getBundle("property.image.id.null.message")));
							} else {
								if(Util.isNumeric(propertyVsImageModel.getPropertyImageId())){
									
									PropertyVsImageEntity propertyVsImageEntity = propertyVsImageDAO.find(Long.valueOf(propertyVsImageModel.getPropertyImageId()));
									
									if(Objects.isNull(propertyVsImageEntity)){
										exceptions.put(messageUtil.getBundle("property.image.id.invalid.code"), new Exception(messageUtil.getBundle("property.image.id.invalid.message")));
									}
								} else {
									exceptions.put(messageUtil.getBundle("property.image.id.numeric.code"), new Exception(messageUtil.getBundle("property.image.id.numeric.message")));
								}
							}
							
							
						}
						
					}
		
					// Property Vs NearBy
					if (Objects.isNull(propertyModel.getPropertyVsNearbyModels())) {
						exceptions.put(messageUtil.getBundle("property.nearby.null.code"), new Exception(messageUtil.getBundle("property.nearby.null.message")));
					} else {
						// Address Validation
						for (PropertyVsNearbyModel propertyVsNearbyModel : propertyModel.getPropertyVsNearbyModels()) {
							
							//Validate Property Vs NearBy Id
							if(StringUtils.isBlank(propertyVsNearbyModel.getPropertyNearbyId())){
								exceptions.put(messageUtil.getBundle("property.nearby.id.null.code"), new Exception(messageUtil.getBundle("property.nearby.id.null.message")));
							} else {
								if(Util.isNumeric(propertyVsNearbyModel.getPropertyNearbyId())){
									
									PropertyVsNearbyEntity propertyVsNearbyEntity = propertyVsNearbyDAO.find(Long.valueOf(propertyVsNearbyModel.getPropertyNearbyId()));
									
									if(Objects.isNull(propertyVsNearbyEntity)){
										exceptions.put(messageUtil.getBundle("property.nearby.id.invalid.code"), new Exception(messageUtil.getBundle("property.nearby.id.invalid.message")));
									}
								} else {
									exceptions.put(messageUtil.getBundle("property.nearby.id.numeric.code"), new Exception(messageUtil.getBundle("property.nearby.id.numeric.message")));
								}
							}
							
							if (StringUtils.isBlank(propertyVsNearbyModel.getPlaces())) {
								exceptions.put(messageUtil.getBundle("property.place.null.code"), new Exception(messageUtil.getBundle("property.place.null.message")));
							}
						}
					}
		
					// PropertyVs PGCS
					if (Objects.isNull(propertyModel.getPgCategorySexModel())) {
						exceptions.put(messageUtil.getBundle("property.pgcs.null.code"), new Exception(messageUtil.getBundle("property.pgcs.null.message")));
					} else {
						if (StringUtils.isEmpty(propertyModel.getPgCategorySexModel().getPgcsId())) {
							exceptions.put(messageUtil.getBundle("property.pgcs.null.code"), new Exception(messageUtil.getBundle("property.pgcs.null.message")));
						} else {
							if (!Util.isNumeric(propertyModel.getPgCategorySexModel().getPgcsId())) {
								exceptions.put(messageUtil.getBundle("property.pgcs.numeric.code"), new Exception(messageUtil.getBundle("property.pgcs.numeric.message")));
							} else {
								PGCategorySexEntity pgCategorySexEntity = pgCategorySexDAO.find(Long.valueOf(propertyModel.getPgCategorySexModel().getPgcsId()));
								if (Objects.isNull(pgCategorySexEntity) && pgCategorySexEntity.getStatus() != Status.ACTIVE.ordinal()) {
									exceptions.put(messageUtil.getBundle("property.pgcs.invalid.code"), new Exception(messageUtil.getBundle("property.pgcs.invalid.message")));
								}
							}
						}
					}
					// Property Vs Space Rule
					if (Objects.isNull(propertyModel.getPropertyVsSpaceRuleModels())) {
						exceptions.put(messageUtil.getBundle("property.spacerule.null.code"), new Exception(messageUtil.getBundle("property.spacerule.null.message")));
					} else {
						// Answer Validation
						for (PropertyVsSpaceRuleModel propertyVsSpaceRuleModel : propertyModel.getPropertyVsSpaceRuleModels()) {
							
							//Space Rule Id Validate
							if(StringUtils.isBlank(propertyVsSpaceRuleModel.getPropertySpaceId())){
								exceptions.put(messageUtil.getBundle("property.spacerule.id.null.code"), new Exception(messageUtil.getBundle("property.spacerule.id.null.message")));
							} else {
								if(Util.isNumeric(propertyVsSpaceRuleModel.getPropertySpaceId())){
									
									PropertyVsSpaceRuleEntity propertyVsSpaceRuleEntity = propertyVsSpaceRuleDAO.find(Long.valueOf(propertyVsSpaceRuleModel.getPropertySpaceId()));
									
									if(Objects.isNull(propertyVsSpaceRuleEntity)){
										exceptions.put(messageUtil.getBundle("property.spacerule.id.invalid.code"), new Exception(messageUtil.getBundle("property.spacerule.id.invalid.message")));
									}
								} else {
									exceptions.put(messageUtil.getBundle("property.spacerule.id.numeric.code"), new Exception(messageUtil.getBundle("property.spacerule.id.numeric.message")));
								}
							}
							
							if (StringUtils.isBlank(propertyVsSpaceRuleModel.getAnswer())) {
								exceptions.put(messageUtil.getBundle("property.spacerule.answer.null.code"), new Exception(messageUtil.getBundle("property.sp.answer.null.message")));
							} else {
								if (!(propertyVsSpaceRuleModel.getAnswer().equals(PropertyAddConstant.STR_Y) || propertyVsSpaceRuleModel.getAnswer().equals(PropertyAddConstant.STR_N))) {
									exceptions.put(messageUtil.getBundle("property.spacerule.invalid.code"), new Exception(messageUtil.getBundle("property.spacerule.invalid.message")));
								}
							}
		
							// Validate Space Rule
							if (Objects.isNull(propertyVsSpaceRuleModel.getSpaceRuleModel())) {
								exceptions.put(messageUtil.getBundle("space.rule.null.code"), new Exception(messageUtil.getBundle("space.rule.null.message")));
							} else {
		
								if (StringUtils.isBlank(propertyVsSpaceRuleModel.getSpaceRuleModel().getSpruleId())) {
									exceptions.put(messageUtil.getBundle("space.rule.null.code"), new Exception(messageUtil.getBundle("space.rule.null.message")));
								} else {
		
									if (!Util.isNumeric(propertyVsSpaceRuleModel.getSpaceRuleModel().getSpruleId())) {
										exceptions.put(messageUtil.getBundle("sprule.nonnumeric.code"), new Exception(messageUtil.getBundle("sprule.nonnumeric.message")));
									} else {
		
										SpaceRuleEntity spaceRuleEntity = spaceRuleDAO.find(Long.parseLong(propertyVsSpaceRuleModel.getSpaceRuleModel().getSpruleId()));
										if (Objects.isNull(spaceRuleEntity) && spaceRuleEntity.getStatus() != Status.ACTIVE.ordinal()) {
											exceptions.put(messageUtil.getBundle("sprule.invalid.code"), new Exception(messageUtil.getBundle("sprule.invalid.message")));
										}
									}
								}
		
							}
						}
					}
		
					// Property vs Special Experience
		
					if (Objects.isNull(propertyModel.getPropertyVsSpecialExperienceModels())) {
						exceptions.put(messageUtil.getBundle("special.expe.null.code"), new Exception(messageUtil.getBundle("special.expe.null.message")));
					} else {
						// Answer Validation
						for (PropertyVsSpecialExperienceModel propertyVsExperienceModel : propertyModel.getPropertyVsSpecialExperienceModels()) {
							
							// Validate Property Vs Special Exp Id
							if(StringUtils.isBlank(propertyVsExperienceModel.getPropertyExpId())){
								exceptions.put(messageUtil.getBundle("property.spexp.id.null.code"), new Exception(messageUtil.getBundle("property.spexp.id.null.message")));
							} else {
								if(Util.isNumeric(propertyVsExperienceModel.getPropertyExpId())){
									
									PropertyVsSpecialExperienceEntity propertyVsSpecialExperienceEntity = propertyVsSpecialExperienceDAO.find(Long.valueOf(propertyVsExperienceModel.getPropertyExpId()));
									
									if(Objects.isNull(propertyVsSpecialExperienceEntity)){
										exceptions.put(messageUtil.getBundle("property.spexp.id.invalid.code"), new Exception(messageUtil.getBundle("property.spexp.id.invalid.message")));
									}
								} else {
									exceptions.put(messageUtil.getBundle("property.spexp.id.numeric.code"), new Exception(messageUtil.getBundle("property.spexp.id.numeric.message")));
								}
							}
							
							
							
							if (Objects.isNull(propertyVsExperienceModel.getSpecialExperienceModel())) {
								exceptions.put(messageUtil.getBundle("special.expe.null.code"), new Exception(messageUtil.getBundle("special.expe.null.message")));
							} else {
		
								if (StringUtils.isEmpty(propertyVsExperienceModel.getSpecialExperienceModel().getExperienceId())) {
									exceptions.put(messageUtil.getBundle("special.expe.null.code"), new Exception(messageUtil.getBundle("special.expe.null.message")));
								} else {
									if (!Util.isNumeric(propertyVsExperienceModel.getSpecialExperienceModel().getExperienceId())) {
										exceptions.put(messageUtil.getBundle("special.expe.invalid.code"), new Exception(messageUtil.getBundle("special.expe.invalid.message")));
									} else {
		
										SpecialExperienceEntity specialExperienceEntity = specialExperienceDAO.find(Long.parseLong(propertyVsExperienceModel.getSpecialExperienceModel().getExperienceId()));
										if (Objects.isNull(specialExperienceEntity) && specialExperienceEntity.getStatus() != Status.ACTIVE.ordinal()) {
											exceptions.put(messageUtil.getBundle("special.expe.invalid.code"), new Exception(messageUtil.getBundle("special.expe.invalid.message")));
										}
									}
								}
		
							}
		
						}
					}
		
					// User vs Account
					if (Objects.isNull(propertyModel.getUserVsAccountModel())) {
						exceptions.put(messageUtil.getBundle("property.user.null.code"), new Exception(messageUtil.getBundle("property.user.null.message")));
					} else {
						
						//User Vs Account Id Validate
						if(StringUtils.isBlank(String.valueOf(propertyModel.getUserVsAccountModel().getUserVsAccountId()))){
							exceptions.put(messageUtil.getBundle("uservsacc.id.null.code"), new Exception(messageUtil.getBundle("uservsacc.id.null.message")));
						} else {
							if(Util.isNumeric(String.valueOf(propertyModel.getUserVsAccountModel().getUserVsAccountId()))){
								
								UserVsAccountEntity userVsAccountEntity = userVsAccountDAO.find(propertyModel.getUserVsAccountModel().getUserVsAccountId());
								
								if(Objects.isNull(userVsAccountEntity)){
									exceptions.put(messageUtil.getBundle("uservsacc.id.invalid.code"), new Exception(messageUtil.getBundle("uservsacc.id.invalid.message")));
								}
							} else {
								exceptions.put(messageUtil.getBundle("uservsacc.id.numeric.code"), new Exception(messageUtil.getBundle("uservsacc.id.numeric.message")));
							}
						}
						
						
						if (Util.isEmpty(propertyModel.getUserVsAccountModel().getAccountHolderName())) {
							exceptions.put(messageUtil.getBundle("accholder.name.null.code"), new Exception(messageUtil.getBundle("accholder.name.null.message")));
						}
						if (Util.isEmpty(propertyModel.getUserVsAccountModel().getAccountNumber())) {
							exceptions.put(messageUtil.getBundle("account.no.null.code"), new Exception(messageUtil.getBundle("account.no.null.message")));
						}
						if (Util.isEmpty(propertyModel.getUserVsAccountModel().getAccountType())) {
							exceptions.put(messageUtil.getBundle("account.type.null.code"), new Exception(messageUtil.getBundle("account.type.null.message")));
						}
						if (Util.isEmpty(propertyModel.getUserVsAccountModel().getIfscCode())) {
							exceptions.put(messageUtil.getBundle("ifsc.code.null.code"), new Exception(messageUtil.getBundle("ifsc.code.null.message")));
						}
					}
		
					// Property Vs Document
					if (Objects.isNull(propertyModel.getPropertyVsDocumentModels())) {
						exceptions.put(messageUtil.getBundle("property.document.null.code"), new Exception(messageUtil.getBundle("property.document.null.message")));
					} else {
		
						for (PropertyVsDocumentModel propertyVsDocumentModel : propertyModel.getPropertyVsDocumentModels()) {
							
							//Validate Property Vs Document Id
							if(StringUtils.isBlank(String.valueOf(propertyVsDocumentModel.getUserVsDocumentId()))){
								exceptions.put(messageUtil.getBundle("property.document.id.null.code"), new Exception(messageUtil.getBundle("property.document.id.null.message")));
							} else {
								if(Util.isNumeric(String.valueOf(propertyVsDocumentModel.getUserVsDocumentId()))){
									
									PropertyVsDocumentEntity propertyVsDocumentEntity = propertyVsDocumentDAO.find(propertyVsDocumentModel.getUserVsDocumentId());
									
									if(Objects.isNull(propertyVsDocumentEntity)){
										exceptions.put(messageUtil.getBundle("property.document.id.invalid.code"), new Exception(messageUtil.getBundle("property.document.id.invalid.message")));
									}
								} else {
									exceptions.put(messageUtil.getBundle("property.document.id.numeric.code"), new Exception(messageUtil.getBundle("property.document.id.numeric.message")));
								}
							}
							
							
							
							if (Objects.isNull(propertyVsDocumentModel.getDocumentModel())) {
								exceptions.put(messageUtil.getBundle("document.null.code"), new Exception(messageUtil.getBundle("document.null.message")));
							} else {
								if (Util.isEmpty(propertyVsDocumentModel.getDocumentModel().getDocumentId())) {
									exceptions.put(messageUtil.getBundle("document.null.code"), new Exception(messageUtil.getBundle("document.null.message")));
								} else {
									if (!Util.isNumeric(propertyVsDocumentModel.getDocumentModel().getDocumentId())) {
										exceptions.put(messageUtil.getBundle("document.id.nonnumeric.code"), new Exception(messageUtil.getBundle("document.id.nonnumeric.message")));
									} else {
										DocumentEntity documentEntity = documentDAO.find(Long.valueOf(propertyVsDocumentModel.getDocumentModel().getDocumentId()));
										if (Objects.isNull(documentEntity) && documentEntity.getStatus() != Status.ACTIVE.ordinal()) {
											exceptions.put(messageUtil.getBundle("document.id.invalid.code"),new Exception(messageUtil.getBundle("document.id.invalid.message")));
										}
									}
								}
							}
		
							if (StringUtils.isBlank(propertyVsDocumentModel.getFileUrl())) {
								exceptions.put(messageUtil.getBundle("property.document.file.null.code"),new Exception(messageUtil.getBundle("property.document.file.null.message")));
							}
						}
					}
		
////////////////////////////////////////////////////////////////// Room Data Validation /////////// /////////////////////////////////////////////////////////////////////
		
					if (Objects.nonNull(propertyModel.getRoomModels())) {
		
						for (RoomModel roomModel : propertyModel.getRoomModels()) {
		
							// Shared Space
							if (StringUtils.isBlank(roomModel.getSharedSpace())) {
								exceptions.put(messageUtil.getBundle("room.sharedSpace.null.code"),new Exception(messageUtil.getBundle("room.sharedSpace.null.message")));
							} else {
		
								if (!(roomModel.getSharedSpace().equals(PropertyAddConstant.STR_Y) || roomModel.getSharedSpace().equals(PropertyAddConstant.STR_N))) {
									exceptions.put(messageUtil.getBundle("room.sharedSpace.invalid.code"), new Exception(messageUtil.getBundle("room.sharedSpace.invalid.message")));
								}
							}
		
							// CotAvailable
							if (!StringUtils.isBlank(roomModel.getCotAvailable())) {
								if (!(roomModel.getCotAvailable().equals(PropertyAddConstant.STR_Y) || roomModel.getCotAvailable().equals(PropertyAddConstant.STR_N))) {
									exceptions.put(messageUtil.getBundle("room.cotavail.invalid.code"), new Exception(messageUtil.getBundle("room.cotavail.invalid.message")));
								}
							}
		
							// No Of Guest
							if (!StringUtils.isBlank(roomModel.getNoOfGuest())) {
								if (!Util.isNumeric(roomModel.getNoOfGuest())) {
									exceptions.put(messageUtil.getBundle("room.noofguest.numeric.code"), new Exception(messageUtil.getBundle("room.noofguest.numeric.message")));
								}
							}
		
							// No of Child
							if (!StringUtils.isBlank(roomModel.getNoOfChild())) {
								if (!Util.isNumeric(roomModel.getNoOfChild())) {
									exceptions.put(messageUtil.getBundle("room.noofchild.numeric.code"), new Exception(messageUtil.getBundle("room.noofchild.numeric.message")));
								}
							}
		
							// not of Cot
							if (StringUtils.isBlank(roomModel.getNumOfCot())) {
								if (!Util.isNumeric(roomModel.getNumOfCot())) {
									exceptions.put(messageUtil.getBundle("room.numofCot.numeric.code"), new Exception(messageUtil.getBundle("room.numofCot.numeric.message")));
								}
							}
		
							// Accommodation Check
							if (Objects.isNull(roomModel.getAccommodationModel())) {
								exceptions.put(messageUtil.getBundle("room.accommodation.null.code"), new Exception(messageUtil.getBundle("room.accommodation.null.message")));
							} else {
		
								if (StringUtils.isEmpty(roomModel.getAccommodationModel().getAccommodationId())) {
									exceptions.put(messageUtil.getBundle("room.accommodation.null.code"), new Exception(messageUtil.getBundle("room.accommodation.null.message")));
								} else {
									if (!Util.isNumeric(roomModel.getAccommodationModel().getAccommodationId())) {
										exceptions.put(messageUtil.getBundle("room.accommodation.invalid.code"), new Exception(messageUtil.getBundle("room.accommodation.invalid.message")));
									} else {
										AccommodationEntity accommodationEntity = accommodationDAO.find(Long.parseLong(roomModel.getAccommodationModel().getAccommodationId()));
										if (Objects.isNull(accommodationEntity) && accommodationEntity.getStatus() != Status.ACTIVE.ordinal()) {
											exceptions.put(messageUtil.getBundle("room.accommodation.invalid.code"), new Exception(messageUtil.getBundle("room.accommodation.invalid.message")));
										} else if (accommodationEntity.getAccommodationName() == String.valueOf(Accommodation.Shared.ordinal())) {
											// Room Vs Bed
											if (Objects.isNull(roomModel.getRoomVsBedModel())) {
												exceptions.put(messageUtil.getBundle("room.vs.bed.null.code"), new Exception(messageUtil.getBundle("room.vs.bed.null.message")));
											} else {
												if (StringUtils.isEmpty(roomModel.getRoomVsBedModel().getNoOfBeds())) {
													exceptions.put(messageUtil.getBundle("room.vs.bed.null.code"), new Exception(messageUtil.getBundle("room.vs.bed.null.message")));
												} else if (!Util.isNumeric(roomModel.getRoomVsBedModel().getNoOfBeds())) {
													exceptions.put(messageUtil.getBundle("room.no.of.bed.numeric.code"), new Exception(messageUtil.getBundle("room.no.of.bed.numeric.message")));
												}
											}
										}
									}
								}
		
							}
		
							// Room Category Validation
							if (Objects.isNull(roomModel.getRoomCategoryModel())) {
								exceptions.put(messageUtil.getBundle("room.category.null.code"), new Exception(messageUtil.getBundle("room.category.null.message")));
							} else {
		
								if (StringUtils.isEmpty(roomModel.getRoomCategoryModel().getRoomCatId())) {
									exceptions.put(messageUtil.getBundle("room.category.null.code"), new Exception(messageUtil.getBundle("room.category.null.message")));
								} else {
									if (!Util.isNumeric(roomModel.getRoomCategoryModel().getRoomCatId())) {
										exceptions.put(messageUtil.getBundle("room.category.numeric.code"), new Exception(messageUtil.getBundle("room.category.numeric.message")));
									} else {
										RoomCategoryEntity roomCategoryEntity = roomCategoryDAO.find(Long.parseLong(roomModel.getRoomCategoryModel().getRoomCatId()));
										if (Objects.isNull(roomCategoryEntity) && roomCategoryEntity.getStatus() != Status.ACTIVE.ordinal()) {
											exceptions.put(messageUtil.getBundle("room.category.invalid.code"), new Exception(messageUtil.getBundle("room.category.invalid.message")));
										}
									}
								}
		
							}
							// Room Standard Validation
							/*if(Objects.isNull(roomModel.getRoomStandardModel())) {
								  exceptions.put(messageUtil.getBundle("room.standard.null.code"), new Exception(messageUtil.getBundle("room.standard.null.message"))); 
								  } else {
									  if(StringUtils.isEmpty(roomModel.getRoomStandardModel().getRoomStandardId()))  { 
										  exceptions.put(messageUtil.getBundle("room.standard.null.code"), new Exception(messageUtil.getBundle("room.standard.null.message"))); 
										  } else {
											  	if(!Util.isNumeric(roomModel.getRoomStandardModel().getRoomStandardId())){
											  		exceptions.put(messageUtil.getBundle("room.standard.numeric.code"), new Exception(messageUtil.getBundle("room.standard.numeric.message"))); 
											  	} else {
											  			RoomStandardEntity roomStandardEntity = roomStandardDAO.find(Long.parseLong(roomModel.getRoomStandardModel().getRoomStandardId())); 
											  			if(Objects.isNull(roomStandardEntity) && roomStandardEntity.getStatus() != Status.ACTIVE.ordinal()) {
											  				exceptions.put(messageUtil.getBundle("room.standard.invalid.code"), new  Exception(messageUtil.getBundle("room.standard.invalid.message"))); 
											  			} 
											  	} 
									  } 
							  }*/
		
							// Room Vs Amenities
							if (Objects.isNull(roomModel.getRoomVsAmenitiesModels())) {
								exceptions.put(messageUtil.getBundle("room.vs.amenities.null.code"), new Exception(messageUtil.getBundle("room.vs.amenities.null.message")));
							} else {
								for (RoomVsAmenitiesModel roomVsAmenitiesModel : roomModel.getRoomVsAmenitiesModels()) {
									
									
									//Validate Room Vs Amenities Id
									if(StringUtils.isBlank(String.valueOf(roomVsAmenitiesModel.getRoomVsAminitiesId()))){
										exceptions.put(messageUtil.getBundle("room.amenities.id.null.code"), new Exception(messageUtil.getBundle("room.amenities.id.null.message")));
									} else {
										if(Util.isNumeric(String.valueOf(roomVsAmenitiesModel.getRoomVsAminitiesId()))){
											
											RoomVsAmenitiesEntity roomVsAmenitiesEntity = roomVsAmenitiesDAO.find(Long.valueOf(roomVsAmenitiesModel.getRoomVsAminitiesId()));
											
											if(Objects.isNull(roomVsAmenitiesEntity)){
												exceptions.put(messageUtil.getBundle("room.amenities.id.invalid.code"), new Exception(messageUtil.getBundle("room.amenities.id.invalid.message")));
											}
										} else {
											exceptions.put(messageUtil.getBundle("room.amenities.id.numeric.code"), new Exception(messageUtil.getBundle("room.amenities.id.numeric.message")));
										}
									}
									
									if (Objects.nonNull(roomVsAmenitiesModel.getAmenitiesModel())) {
										if (StringUtils.isBlank(roomVsAmenitiesModel.getAmenitiesModel().getAminitiesId())) {
											exceptions.put(messageUtil.getBundle("amenities.id.null.code"), new Exception(messageUtil.getBundle("amenities.id.null.message")));
										} else {
											if (!Util.isNumeric(roomVsAmenitiesModel.getAmenitiesModel().getAminitiesId())) {
												exceptions.put(messageUtil.getBundle("amenities.id.numeric.code"), new Exception(messageUtil.getBundle("amenities.id.numeric.message")));
											} else {
												AmenitiesEntity amenitiesEntity = amenitiesDAO.find(Long.parseLong(roomVsAmenitiesModel.getAmenitiesModel().getAminitiesId()));
												if (Objects.isNull(amenitiesEntity) && amenitiesEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("amenities.invalid.code"), new Exception(messageUtil.getBundle("amenities.invalid.message")));
												}
											}
		
										}
									} else {
										exceptions.put(messageUtil.getBundle("amenities.null.code"), new Exception(messageUtil.getBundle("amenities.null.message")));
									}
								}
							}
		
							// Room Vs Cancellation
							if (Objects.isNull(roomModel.getRoomVsCancellationModels())) {
								exceptions.put(messageUtil.getBundle("room.vs.cancellation.null.code"), new Exception(messageUtil.getBundle("room.vs.cancellation.null.message")));
							} else {
								for (RoomVsCancellationModel roomVsCancellationModel : roomModel .getRoomVsCancellationModels()) {
									
									//Validate Room Vs Cancellation Id
									if(StringUtils.isBlank(String.valueOf(roomVsCancellationModel.getRcId()))){
										exceptions.put(messageUtil.getBundle("room.cancel.id.null.code"), new Exception(messageUtil.getBundle("room.cancel.id.null.message")));
									} else {
										if(Util.isNumeric(String.valueOf(roomVsCancellationModel.getRcId()))){
											
											RoomVsCancellationEntity roomVsCancellationEntity = roomVsCancellationDAO.find(Long.valueOf(roomVsCancellationModel.getRcId()));
											
											if(Objects.isNull(roomVsCancellationEntity)){
												exceptions.put(messageUtil.getBundle("room.cancel.id.invalid.code"), new Exception(messageUtil.getBundle("room.cancel.id.invalid.message")));
											}
										} else {
											exceptions.put(messageUtil.getBundle("room.cancel.id.numeric.code"), new Exception(messageUtil.getBundle("room.cancel.id.numeric.message")));
										}
									}
									
									// Percentage
									if (StringUtils.isBlank(roomVsCancellationModel.getPercentage())) {
										exceptions.put(messageUtil.getBundle("room.vs.cancellation.percentage.null.code"), new Exception(messageUtil.getBundle("room.vs.cancellation.percentage.null.message")));
									} else {
										if (!Util.isNumeric(roomVsCancellationModel.getPercentage())) {
											exceptions.put(messageUtil.getBundle("room.vs.cancellation.percentage.numeric.code"),new Exception(messageUtil.getBundle("room.vs.cancellation.percentage.numeric.message")));
										}
									}
		
									// Cancellation Slab Validation
									if (Objects.nonNull(roomVsCancellationModel.getCancellationSlabModel())) {
										if (StringUtils.isBlank(roomVsCancellationModel.getCancellationSlabModel().getCancellationSlabId())) {
											exceptions.put(messageUtil.getBundle("cancellation.slab.null.code"),new Exception(messageUtil.getBundle("cancellation..slab.null.message")));
										} else {
											if (!Util.isNumeric(roomVsCancellationModel.getCancellationSlabModel().getCancellationSlabId())) {
												exceptions.put(messageUtil.getBundle("cancellation.slab.numeric.code"),new Exception(messageUtil.getBundle("cancellation.slab.numeric.message")));
											} else {
												CancellationSlabEntity cancellationSlabEntity = cancellationSlabDAO.find(Long.parseLong(roomVsCancellationModel.getCancellationSlabModel().getCancellationSlabId()));
												if (Objects.isNull(cancellationSlabEntity) && cancellationSlabEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("cancellation.invalid.code"), new Exception(messageUtil.getBundle("cancellation.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("cancellation.slab.null.code"), new Exception(messageUtil.getBundle("cancellation.slab.null.message")));
									}
								}
							}
		
							// Room Vs Image
							if(Objects.nonNull(roomModel.getRoomVsImageModels())){
								for(RoomVsImageModel roomVsImageModel:roomModel.getRoomVsImageModels()){
									
									//Validate Room Vs Price Id
									if(StringUtils.isBlank(String.valueOf(roomVsImageModel.getRoomVsImageId()))){
										exceptions.put(messageUtil.getBundle("room.image.id.null.code"), new Exception(messageUtil.getBundle("room.image.id.null.message")));
									} else {
										if(Util.isNumeric(String.valueOf(roomVsImageModel.getRoomVsImageId()))){
											
											RoomVsImageEntity roomVsImageEntity = roomVsImageDAO.find(Long.valueOf(roomVsImageModel.getRoomVsImageId()));
											
											if(Objects.isNull(roomVsImageEntity)){
												exceptions.put(messageUtil.getBundle("room.image.id.invalid.code"), new Exception(messageUtil.getBundle("room.image.id.invalid.message")));
											}
										} else {
											exceptions.put(messageUtil.getBundle("room.image.id.numeric.code"), new Exception(messageUtil.getBundle("room.image.id.numeric.message")));
										}
									}
								}
							}
		
							// Room Vs Price
							if (Objects.nonNull(roomModel.getRoomVsPriceModels())) {
								for (RoomVsPriceModel roomVsPriceModel : roomModel.getRoomVsPriceModels()) {
									
									//Validate Room Vs Price Id
									if(StringUtils.isBlank(String.valueOf(roomVsPriceModel.getRoomVsPriceId()))){
										exceptions.put(messageUtil.getBundle("room.price.id.null.code"), new Exception(messageUtil.getBundle("room.price.id.null.message")));
									} else {
										if(Util.isNumeric(String.valueOf(roomVsPriceModel.getRoomVsPriceId()))){
											
											RoomVsPriceEntity roomVsPriceEntity = roomVsPriceDAO.find(Long.valueOf(roomVsPriceModel.getRoomVsPriceId()));
											
											if(Objects.isNull(roomVsPriceEntity)){
												exceptions.put(messageUtil.getBundle("room.price.id.invalid.code"), new Exception(messageUtil.getBundle("room.price.id.invalid.message")));
											}
										} else {
											exceptions.put(messageUtil.getBundle("room.price.id.numeric.code"), new Exception(messageUtil.getBundle("room.price.id.numeric.message")));
										}
									}
									
									// Value
									if (StringUtils.isEmpty(roomVsPriceModel.getValue())) {
										exceptions.put(messageUtil.getBundle("price.value.null.code"), new Exception(messageUtil.getBundle("price.value.null.message")));
									} else if (!Util.isNumeric(roomVsPriceModel.getValue())) {
										exceptions.put(messageUtil.getBundle("price.value.numeric.code"), new Exception(messageUtil.getBundle("price.value.numeric.message")));
									}
		
									// Price Type
									if (Objects.nonNull(roomVsPriceModel.getPriceTypeModel())) {
										if (StringUtils.isEmpty(roomVsPriceModel.getPriceTypeModel().getPriceTypeId())) {
											exceptions.put(messageUtil.getBundle("price.type.null.code"), new Exception(messageUtil.getBundle("price.type.null.message")));
										} else {
											if (!Util.isNumeric(roomVsPriceModel.getPriceTypeModel().getPriceTypeId())) {
												exceptions.put(messageUtil.getBundle("price.type.id.numeric.code"), new Exception(messageUtil.getBundle("price.type.id.numeric.message")));
											} else {
												PriceTypeEntity priceTypeEntity = priceTypeDAO.find(Long.valueOf(roomVsPriceModel.getPriceTypeModel().getPriceTypeId()));
												if (Objects.isNull(priceTypeEntity) && priceTypeEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("price.type.id.invalid.code"), new Exception(messageUtil.getBundle("price.type.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("price.type.null.code"), new Exception(messageUtil.getBundle("price.type.null.message")));
									}
								}
		
							} else {
								exceptions.put(messageUtil.getBundle("room.vs.price.null.code"), new Exception(messageUtil.getBundle("room.vs.price.null.message")));
							}
		
							// Room vs host discount
		
							if (Objects.nonNull(roomModel.getRoomVsHostDiscountModels())) {
								for (RoomVsHostDiscountModel roomVsHostDiscountModel : roomModel.getRoomVsHostDiscountModels()) {
									
									//Validate Room Vs Host Discount Id
									if(StringUtils.isBlank(String.valueOf(roomVsHostDiscountModel.getRhdId()))){
										exceptions.put(messageUtil.getBundle("room.hostdis.id.null.code"), new Exception(messageUtil.getBundle("room.hostdis.id.null.message")));
									} else {
										if(Util.isNumeric(String.valueOf(roomVsHostDiscountModel.getRhdId()))){
											
											RoomVsHostDiscountEntity roomVsHostDiscountEntity = roomVsHostDiscountDAO.find(Long.valueOf(roomVsHostDiscountModel.getRhdId()));
											
											if(Objects.isNull(roomVsHostDiscountEntity)){
												exceptions.put(messageUtil.getBundle("room.hostdis.id.invalid.code"), new Exception(messageUtil.getBundle("room.hostdis.id.invalid.message")));
											}
										} else {
											exceptions.put(messageUtil.getBundle("room.hostdis.id.numeric.code"), new Exception(messageUtil.getBundle("room.hostdis.id.numeric.message")));
										}
									}
									
									// Percentage
									if (StringUtils.isEmpty(roomVsHostDiscountModel.getPercentage())) {
										exceptions.put(messageUtil.getBundle("discount.percentage.null.code"), new Exception(messageUtil.getBundle("discount.percentage.null.message")));
									} else if (!Util.isNumeric(roomVsHostDiscountModel.getPercentage())) {
										exceptions.put(messageUtil.getBundle("discount.percentage.numeric.code"), new Exception(messageUtil.getBundle("discount.percentage.numeric.message")));
									}
		
									// Room Vs Discount Category Host
									if (Objects.nonNull(roomVsHostDiscountModel.getDiscountCategoryHostModel())) {
										if (StringUtils.isEmpty(roomVsHostDiscountModel.getDiscountCategoryHostModel().getDchId())) {
											exceptions.put(messageUtil.getBundle("discount.category.null.code"), new Exception(messageUtil.getBundle("discount.category.null.message")));
										} else {
											if (!Util.isNumeric(roomVsHostDiscountModel.getDiscountCategoryHostModel().getDchId())) {
												exceptions.put(messageUtil.getBundle("discount.category.id.numeric.code"), new Exception(messageUtil.getBundle("discount.category.id.numeric.message")));
											} else {
												DiscountCategoryHostEntity discountCategoryHostEntity = discountCategoryHostDAO.find(Long.valueOf(roomVsHostDiscountModel.getDiscountCategoryHostModel().getDchId()));
												if (Objects.isNull(discountCategoryHostEntity) && discountCategoryHostEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("discount.category.id.invalid.code"), new Exception(messageUtil.getBundle("discount.category.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("discount.category.null.code"), new Exception(messageUtil.getBundle("discount.category.null.message")));
									}
								}
		
							} else {
								exceptions.put(messageUtil.getBundle("discount.category.null.code"), new Exception(messageUtil.getBundle("discount.category.null.message")));
							}
							// Room Vs Ora discount
							if(Objects.nonNull(roomModel.getRoomVsOraDiscountModels())){
								for(RoomVsOraDiscountModel roomVsOraDiscountModel : roomModel.getRoomVsOraDiscountModels()){
									
									//Validate Room Vs Ora Discount Id
									if(StringUtils.isBlank(String.valueOf(roomVsOraDiscountModel.getRodId()))){
										exceptions.put(messageUtil.getBundle("room.vs.ora.id.null.code"), new Exception(messageUtil.getBundle("room.vs.ora.id.null.message")));
									} else {
										if(Util.isNumeric(String.valueOf(roomVsOraDiscountModel.getRodId()))){
											
											RoomVsOraDiscountEntity roomVsOraDiscountEntity = roomVsOraDiscountDAO.find(Long.valueOf(roomVsOraDiscountModel.getRodId()));
											
											if(Objects.isNull(roomVsOraDiscountEntity)){
												exceptions.put(messageUtil.getBundle("room.vs.ora.id.invalid.code"), new Exception(messageUtil.getBundle("room.vs.ora.id.invalid.message")));
											}
										} else {
											exceptions.put(messageUtil.getBundle("room.vs.ora.id.numeric.code"), new Exception(messageUtil.getBundle("room.vs.ora.id.numeric.message")));
										}
									}
								}
							}
							
		
							// Room Vs Ora Price Percentage
							
							if(Objects.nonNull(roomModel.getRoomVsOrapricePercModels())){
								for(RoomVsOrapricePercModel roomVsOrapricePercModel : roomModel.getRoomVsOrapricePercModels()){
									
									//Validate Room Vs Ora Price Percentage Id
									if(StringUtils.isBlank(String.valueOf(roomVsOrapricePercModel.getRopId()))){
										exceptions.put(messageUtil.getBundle("room.vs.ora.price.id.null.code"), new Exception(messageUtil.getBundle("room.vs.ora.price.id.null.message")));
									} else {
										if(Util.isNumeric(String.valueOf(roomVsOrapricePercModel.getRopId()))){
											
											RoomVsOraPricePercentageEntity roomVsOraPricePercentageEntity = roomVsOraPricePercentageDAO.find(Long.valueOf(roomVsOrapricePercModel.getRopId()));
											
											if(Objects.isNull(roomVsOraPricePercentageEntity)){
												exceptions.put(messageUtil.getBundle("room.vs.ora.price.id.invalid.code"), new Exception(messageUtil.getBundle("room.vs.ora.price.id.invalid.message")));
											}
										} else {
											exceptions.put(messageUtil.getBundle("room.vs.ora.price.id.numeric.code"), new Exception(messageUtil.getBundle("room.vs.ora.price.id.numeric.message")));
										}
									}
								}
							}
							
							// Room Vs Specialities
							if (Objects.nonNull(roomModel.getRoomVsSpecialitiesModels())) {
								for (RoomVsSpecialitiesModel roomVsSpecialitiesModel : roomModel.getRoomVsSpecialitiesModels()) {
									
									//Validate Room Vs Specilities Id
									if(StringUtils.isBlank(String.valueOf(roomVsSpecialitiesModel.getRoomspecId()))){
										exceptions.put(messageUtil.getBundle("room.specilities.id.null.code"), new Exception(messageUtil.getBundle("room.specilities.id.null.message")));
									} else {
										if(Util.isNumeric(String.valueOf(roomVsSpecialitiesModel.getRoomspecId()))){
											
											RoomVsSpecialitiesEntity roomVsSpecialitiesEntity = roomVsSpecialitiesDAO.find(Long.valueOf(roomVsSpecialitiesModel.getRoomspecId()));
											
											if(Objects.isNull(roomVsSpecialitiesEntity)){
												exceptions.put(messageUtil.getBundle("room.specilities.id.invalid.code"), new Exception(messageUtil.getBundle("room.specilities.id.invalid.message")));
											}
										} else {
											exceptions.put(messageUtil.getBundle("room.specilities.id.numeric.code"), new Exception(messageUtil.getBundle("room.specilities.id.numeric.message")));
										}
									}
									
									// Specialities
									if (Objects.nonNull(roomVsSpecialitiesModel.getSpecialtiesModel())) {
										if (StringUtils.isEmpty(roomVsSpecialitiesModel.getSpecialtiesModel().getSpecialtiesId())) {
											exceptions.put(messageUtil.getBundle("specilities.null.code"),new Exception(messageUtil.getBundle("specilities.null.message")));
										} else {
											if (!Util.isNumeric(roomVsSpecialitiesModel.getSpecialtiesModel().getSpecialtiesId())) {
												exceptions.put(messageUtil.getBundle("specilities.id.numeric.code"), new Exception(messageUtil.getBundle("specilities.id.numeric.message")));
											} else {
												SpecialtiesEntity specialtiesEntity = specialtiesDAO.find(Long.valueOf(roomVsSpecialitiesModel.getSpecialtiesModel().getSpecialtiesId()));
												if (Objects.isNull(specialtiesEntity) && specialtiesEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("specilities.id.invalid.code"), new Exception(messageUtil.getBundle("specilities.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("specilities.null.code"),new Exception(messageUtil.getBundle("specilities.null.message")));
									}
								}
		
							} else {
								exceptions.put(messageUtil.getBundle("specilities.null.code"),new Exception(messageUtil.getBundle("specilities.null.message")));
							}
		
							// Room Vs Meal
							if (Objects.nonNull(roomModel.getRoomVsMealModels())) {
								for (RoomVsMealModel roomVsMealModel : roomModel.getRoomVsMealModels()) {
									
									//Room Vs Meal Id Validation
									if(StringUtils.isBlank(String.valueOf(roomVsMealModel.getRoomVsMealId()))){
										exceptions.put(messageUtil.getBundle("room.meal.id.null.code"), new Exception(messageUtil.getBundle("room.meal.id.null.message")));
									} else {
										if(Util.isNumeric(String.valueOf(roomVsMealModel.getRoomVsMealId()))){
											
											RoomVsMealEntity roomVsMealEntity = roomVsMealDAO.find(Long.valueOf(roomVsMealModel.getRoomVsMealId()));
											
											if(Objects.isNull(roomVsMealEntity)){
												exceptions.put(messageUtil.getBundle("room.meal.id.invalid.code"), new Exception(messageUtil.getBundle("room.meal.id.invalid.message")));
											}
										} else {
											exceptions.put(messageUtil.getBundle("room.meal.id.numeric.code"), new Exception(messageUtil.getBundle("room.meal.id.numeric.message")));
										}
									}
									
									
									MealCategoryEntity mealCategoryEntity = null;
									// Meal Category Validation
									if (Objects.nonNull(roomVsMealModel.getMealCategoryModel())) {
										if (StringUtils.isEmpty(roomVsMealModel.getMealCategoryModel().getMealCategoryId())) {
											exceptions.put(messageUtil.getBundle("meal.category.null.code"), new Exception(messageUtil.getBundle("meal.category.null.message")));
										} else {
											if (!Util.isNumeric(roomVsMealModel.getMealCategoryModel().getMealCategoryId())) {
												exceptions.put(messageUtil.getBundle("meal.category.numeric.code"), new Exception(messageUtil.getBundle("meal.category.numeric.message")));
											} else {
												mealCategoryEntity = mealCategoryDAO.find(Long.valueOf(roomVsMealModel.getMealCategoryModel().getMealCategoryId()));
												if (Objects.isNull(mealCategoryEntity) && mealCategoryEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("meal.category.id.invalid.code"), new Exception(messageUtil.getBundle("meal.category.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("meal.category.null.code"), new Exception(messageUtil.getBundle("meal.category.null.message")));
									}
		
									if (Objects.nonNull(mealCategoryEntity)) {
										if (mealCategoryEntity.getMealCatName() == String.valueOf(MealCategory.Daily.ordinal())) {
											// Meal Days Validation
											if (Objects.nonNull(roomVsMealModel.getMealDaysModel())) {
												if (StringUtils.isEmpty(roomVsMealModel.getMealDaysModel().getMealDaysId())) {
													exceptions.put(messageUtil.getBundle("meal.days.null.code"), new Exception(messageUtil.getBundle("meal.days.null.message")));
												} else {
													if (!Util.isNumeric(roomVsMealModel.getMealDaysModel().getMealDaysId())) {
														exceptions.put(messageUtil.getBundle("meal.days.numeric.code"), new Exception(messageUtil.getBundle("meal.days.numeric.message")));
													} else {
														MealDaysEntity mealDaysEntity = mealDaysDAO.find(Long.valueOf(roomVsMealModel.getMealDaysModel().getMealDaysId()));
														if (Objects.isNull(mealDaysEntity) && mealDaysEntity.getStatus() != Status.ACTIVE.ordinal()) {
															exceptions.put(messageUtil.getBundle("meal.days.id.invalid.code"), new Exception(messageUtil .getBundle("meal.days.id.invalid.message")));
														}
													}
												}
											} else {
												exceptions.put(messageUtil.getBundle("meal.days.null.code"), new Exception(messageUtil.getBundle("meal.days.null.message")));
											}
										}
									}
		
									// Master Meal Price Category
									if (Objects.nonNull(roomVsMealModel.getMealPriceCategoryModel())) {
										if (StringUtils.isEmpty(roomVsMealModel.getMealPriceCategoryModel().getMmpcId())) {
											exceptions.put(messageUtil.getBundle("meal.price.null.code"), new Exception(messageUtil.getBundle("meal.price.null.message")));
										} else {
											if (!Util.isNumeric(roomVsMealModel.getMealPriceCategoryModel().getMmpcId())) {
												exceptions.put(messageUtil.getBundle("meal.price.numeric.code"), new Exception(messageUtil.getBundle("meal.price.numeric.message")));
											} else {
												MealPriceCategoryEntity mealPriceCategoryEntity = mealPriceCategoryDAO.find(Long.valueOf(roomVsMealModel.getMealPriceCategoryModel().getMmpcId()));
												if (Objects.isNull(mealPriceCategoryEntity) && mealPriceCategoryEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("meal.price.id.invalid.code"), new Exception(messageUtil.getBundle("meal.price.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("meal.price.null.code"), new Exception(messageUtil.getBundle("meal.price.null.message")));
									}
		
									// Meal Type Validation
									if (Objects.nonNull(roomVsMealModel.getMealTypeModel())) {
										if (StringUtils.isEmpty(roomVsMealModel.getMealTypeModel().getMealTypeId())) {
											exceptions.put(messageUtil.getBundle("meal.type.null.code"), new Exception(messageUtil.getBundle("meal.type.null.message")));
										} else {
											if (!Util.isNumeric(roomVsMealModel.getMealTypeModel().getMealTypeId())) {
												exceptions.put(messageUtil.getBundle("meal.type.numeric.code"), new Exception(messageUtil.getBundle("meal.type.numeric.message")));
											} else {
												MealTypeEntity mealTypeEntity = mealTypeDAO.find(Long.valueOf(roomVsMealModel.getMealTypeModel().getMealTypeId()));
												if (Objects.isNull(mealTypeEntity) && mealTypeEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("meal.type.id.invalid.code"), new Exception(messageUtil.getBundle("meal.type.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("meal.type.null.code"), new Exception(messageUtil.getBundle("meal.type.null.message")));
									}
		
								}
		
							} else {
								exceptions.put(messageUtil.getBundle("meal.category.null.code"), new Exception(messageUtil.getBundle("meal.category.null.message")));
							}
		
						}
		
					} else {
						exceptions.put(messageUtil.getBundle("property.room.null.code"), new Exception(messageUtil.getBundle("property.room.null.message")));
					}
		
				
			 } else { 
				 exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message"))); 
			 }
			} else { 
				 exceptions.put(messageUtil.getBundle("property.null.code"), new Exception(messageUtil.getBundle("property.null.message"))); 
			 }
			
	
			if (exceptions.size() > 0)
				throw new FormExceptions(exceptions);
	
			if (logger.isDebugEnabled()) {
				logger.debug("validatePropertyUpdate -- End");
			}
			
			return userModel;
	
		}
}