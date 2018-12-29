package com.orastays.property.propertyadd.validation;

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

import com.orastays.property.propertyadd.entity.AmenitiesEntity;
import com.orastays.property.propertyadd.entity.CancellationSlabEntity;
import com.orastays.property.propertyadd.entity.DocumentEntity;
import com.orastays.property.propertyadd.entity.HostVsAccountEntity;
import com.orastays.property.propertyadd.entity.MealPlanEntity;
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
import com.orastays.property.propertyadd.entity.RoomVsCancellationEntity;
import com.orastays.property.propertyadd.entity.RoomVsImageEntity;
import com.orastays.property.propertyadd.entity.RoomVsSpecialitiesEntity;
import com.orastays.property.propertyadd.entity.SpaceRuleEntity;
import com.orastays.property.propertyadd.entity.SpecialExperienceEntity;
import com.orastays.property.propertyadd.entity.SpecialtiesEntity;
import com.orastays.property.propertyadd.entity.StayTypeEntity;
import com.orastays.property.propertyadd.exceptions.FormExceptions;
import com.orastays.property.propertyadd.helper.Accommodation;
import com.orastays.property.propertyadd.helper.PropertyAddConstant;
import com.orastays.property.propertyadd.helper.RoomStandard;
import com.orastays.property.propertyadd.helper.Status;
import com.orastays.property.propertyadd.helper.StayType;
import com.orastays.property.propertyadd.helper.UserType;
import com.orastays.property.propertyadd.helper.Util;
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
import com.orastays.property.propertyadd.model.RoomVsAmenitiesModel;
import com.orastays.property.propertyadd.model.RoomVsCancellationModel;
import com.orastays.property.propertyadd.model.RoomVsImageModel;
import com.orastays.property.propertyadd.model.RoomVsMealModel;
import com.orastays.property.propertyadd.model.RoomVsSpecialitiesModel;
import com.orastays.property.propertyadd.model.auth.UserModel;
import com.orastays.property.propertyadd.model.auth.UserVsTypeModel;
import com.orastays.property.propertyadd.model.booking.BookingModel;
import com.orastays.property.propertyadd.model.booking.CancellationModel;

@Component
@Transactional
public class PropertyValidation extends AuthorizeUserValidation {

	private static final Logger logger = LogManager.getLogger(PropertyValidation.class);
	
	
	public List<CancellationModel> validatePropertyCancellationList(BookingModel bookingModel) throws FormExceptions {
		
		if (logger.isDebugEnabled()) {
			logger.debug("validatePropertyCancellationList -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<CancellationModel> cancellationModels = null;
		UserModel userModel = null;
		if(Objects.nonNull(bookingModel)){
			
			// Validate User Token
			if (StringUtils.isBlank(bookingModel.getUserToken())) {
				exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
			} else {
				userModel = getUserDetails(bookingModel.getUserToken());
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
			if (StringUtils.isBlank(String.valueOf(bookingModel.getPropertyId()))) {
				exceptions.put(messageUtil.getBundle("property.id.null.code"), new Exception(messageUtil.getBundle("property.id.null.message")));
			} else {
				
				if (!Util.isNumeric(String.valueOf(bookingModel.getPropertyId()))) {
					exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
				} else {
					PropertyEntity propertyEntity = null;
					
					try {
						Map<String, String> innerMap1 = new LinkedHashMap<>();
						innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
						innerMap1.put(PropertyAddConstant.PROPERTYID, String.valueOf(bookingModel.getPropertyId()));
				
						Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
						outerMap1.put("eq", innerMap1);
				
						Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
						alliasMap.put(entitymanagerPackagesToScan+".PropertyEntity", outerMap1);
						
						propertyEntity = propertyDAO.fetchObjectBySubCiteria(alliasMap);
						
						if (Objects.isNull(propertyEntity)) {
							exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
						} else {
							//validate BookingID
							if(StringUtils.isEmpty(bookingModel.getBookingId())){
								exceptions.put(messageUtil.getBundle("booking.id.null.code"), new Exception(messageUtil.getBundle("booking.id.null.message")));
								
							} else if(StringUtils.isEmpty(bookingModel.getOrabookingId())){ //Validate Ora Booking Id
								
								exceptions.put(messageUtil.getBundle("orabooking.id.null.code"), new Exception(messageUtil.getBundle("orabooking.id.null.message")));
								
							} else {
									cancellationModels = getPropertyCancellationList(bookingModel);
							}
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
			logger.debug("validatePropertyCancellationList -- End");
		}
		
		return cancellationModels;
		
	}

	
	public List<CancellationModel> validateUserTokenForCancellationList(BookingModel bookingModel) throws FormExceptions {
		
		if (logger.isDebugEnabled()) {
			logger.debug("validateUserTokenForCancellationList -- START");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<CancellationModel> cancellationModels = null;
		UserModel userModel = null;
		if(Objects.nonNull(bookingModel)){
			// Validate User Token
			if (StringUtils.isBlank(bookingModel.getUserToken())) {
				exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
			} else {
				userModel = getUserDetails(bookingModel.getUserToken());
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
						//validate BookingID
						if(StringUtils.isEmpty(bookingModel.getBookingId())){
							exceptions.put(messageUtil.getBundle("booking.id.null.code"), new Exception(messageUtil.getBundle("booking.id.null.message")));
							
						} else if(StringUtils.isEmpty(bookingModel.getOrabookingId())){ //Validate Ora Booking Id
							
							exceptions.put(messageUtil.getBundle("orabooking.id.null.code"), new Exception(messageUtil.getBundle("orabooking.id.null.message")));
							
						} else {
							cancellationModels = getUserCancellationList(bookingModel);
						}
					}
				} else {
					exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
				}
			} else {
				exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message")));
			}

		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("validateUserTokenForCancellationList -- End");
		}
		
		return cancellationModels;
	}
	
	public List<BookingModel> validateUserTokenForBookingList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isDebugEnabled()) {
			logger.debug("validatePropertyUserToken -- START");
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
		
		if (logger.isDebugEnabled()) {
			logger.debug("validatePropertyUserToken -- End");
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
			
			// Fetching User Details From Auth Server
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
						if (!(propertyModel.getEntireApartment().equals(PropertyAddConstant.STR_Y) || propertyModel.getEntireApartment().equals(PropertyAddConstant.STR_N))) {
							exceptions.put(messageUtil.getBundle("entire.appartment.invalid.code"), new Exception(messageUtil.getBundle("entire.appartment.invalid.message")));
						}
					}
					
					// Validate Sex
					if (StringUtils.isEmpty(propertyModel.getSexCategory())) {
						exceptions.put(messageUtil.getBundle("property.pgcs.null.code"), new Exception(messageUtil.getBundle("property.pgcs.null.message")));
					} else {
						if (!Util.sexContains(propertyModel.getSexCategory())) {
							exceptions.put(messageUtil.getBundle("property.pgcs.invalid.code"), new Exception(messageUtil.getBundle("property.pgcs.invalid.message")));
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
					
					//Validate Stay Type
					StayTypeEntity stayTypeEntity = null;
					if (Objects.isNull(propertyModel.getStayTypeModel())) {
						exceptions.put(messageUtil.getBundle("stay.type.null.code"), new Exception(messageUtil.getBundle("stay.type.null.message")));
					} else {
						if (StringUtils.isBlank(propertyModel.getStayTypeModel().getStayTypeId())) {
							exceptions.put(messageUtil.getBundle("stay.type.id.null.code"), new Exception(messageUtil.getBundle("stay.type.id.null.message")));
						} else {
							if (!Util.isNumeric(propertyModel.getStayTypeModel().getStayTypeId())) {
								exceptions.put(messageUtil.getBundle("stay.type.id.invalid.code"), new Exception(messageUtil.getBundle("stay.type.id.invalid.message")));
							} else {
								stayTypeEntity = stayTypeDAO.find(Long.parseLong(propertyModel.getStayTypeModel().getStayTypeId()));
								if (Objects.isNull(stayTypeEntity) && stayTypeEntity.getStatus() != Status.ACTIVE.ordinal()) {
									exceptions.put(messageUtil.getBundle("stay.type.id.invalid.code"), new Exception(messageUtil.getBundle("stay.type.id.invalid.message")));
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
						// Experience Validation
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
					if (Objects.isNull(propertyModel.getHostVsAccountModel())) {
						exceptions.put(messageUtil.getBundle("property.user.null.code"), new Exception(messageUtil.getBundle("property.user.null.message")));
					} else {
						if (Util.isEmpty(propertyModel.getHostVsAccountModel().getAccountHolderName())) {
							exceptions.put(messageUtil.getBundle("accholder.name.null.code"), new Exception(messageUtil.getBundle("accholder.name.null.message")));
						}
						if (Util.isEmpty(propertyModel.getHostVsAccountModel().getAccountNumber())) {
							exceptions.put(messageUtil.getBundle("account.no.null.code"), new Exception(messageUtil.getBundle("account.no.null.message")));
						}
						if (Util.isEmpty(propertyModel.getHostVsAccountModel().getAccountType())) {
							exceptions.put(messageUtil.getBundle("account.type.null.code"), new Exception(messageUtil.getBundle("account.type.null.message")));
						}
						if (Util.isEmpty(propertyModel.getHostVsAccountModel().getIfscCode())) {
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
							
							
							roomModel.setOraRoomName("ORA"+new Date().getTime());
		
							// Shared Space
							if (StringUtils.isBlank(roomModel.getSharedSpace())) {
								exceptions.put(messageUtil.getBundle("room.sharedSpace.null.code"),new Exception(messageUtil.getBundle("room.sharedSpace.null.message")));
							} else {
		
								if (!(roomModel.getSharedSpace().equals(PropertyAddConstant.STR_Y) || roomModel.getSharedSpace().equals(PropertyAddConstant.STR_N))) {
									exceptions.put(messageUtil.getBundle("room.sharedSpace.invalid.code"), new Exception(messageUtil.getBundle("room.sharedSpace.invalid.message")));
								} else {
									
									if(roomModel.getSharedSpace().equals(PropertyAddConstant.STR_Y)){
										if(StringUtils.isEmpty(roomModel.getSharedBedPrice())){
											exceptions.put(messageUtil.getBundle("room.sharedprice.null.code"), new Exception(messageUtil.getBundle("room.sharedprice.null.message")));
										} else {
											if(!Util.isNumeric(roomModel.getSharedBedPrice())) {
												exceptions.put(messageUtil.getBundle("room.sharedprice.numeric.code"), new Exception(messageUtil.getBundle("room.sharedprice.numeric.message")));
											}
										}
										
									}
								}
							}
		
							// CotAvailable
							if (!StringUtils.isBlank(roomModel.getCotAvailable())) {
								if (!(roomModel.getCotAvailable().equals(PropertyAddConstant.STR_Y) || roomModel.getCotAvailable().equals(PropertyAddConstant.STR_N))) {
									exceptions.put(messageUtil.getBundle("room.cotavail.invalid.code"), new Exception(messageUtil.getBundle("room.cotavail.invalid.message")));
								} 
							}
		
							
							// No of Child
							if (!StringUtils.isBlank(roomModel.getNoOfChild())) {
								if (!Util.isNumeric(roomModel.getNoOfChild())) {
									exceptions.put(messageUtil.getBundle("room.noofchild.numeric.code"), new Exception(messageUtil.getBundle("room.noofchild.numeric.message")));
								}
							}
		
							// No of Cot
							if (StringUtils.isBlank(roomModel.getNumOfCot())) {
								if (!Util.isNumeric(roomModel.getNumOfCot())) {
									exceptions.put(messageUtil.getBundle("room.numofCot.numeric.code"), new Exception(messageUtil.getBundle("room.numofCot.numeric.message")));
								}
							}
							
							
							// Host Discount Weekly
							if (!StringUtils.isBlank(roomModel.getHostDiscountWeekly())) {
								if (!Util.isNumeric(roomModel.getHostDiscountWeekly())) {
									exceptions.put(messageUtil.getBundle("room.host.discount.numeric.code"), new Exception(messageUtil.getBundle("room.host.discount.numeric.message")));
								}
							}
							
							// Host Discount Monthly
							if (!StringUtils.isBlank(roomModel.getHostDiscountMonthly())) {
								if (!Util.isNumeric(roomModel.getHostDiscountMonthly())) {
									exceptions.put(messageUtil.getBundle("room.host.dis.monthly.numeric.code"), new Exception(messageUtil.getBundle("room.host.dis.monthly.numeric.message")));
								}
							}
							
							// Ora Discount Percentage
							if (!StringUtils.isBlank(roomModel.getOraDiscountPercentage())) {
								if (!Util.isNumeric(roomModel.getOraDiscountPercentage())) {
									exceptions.put(messageUtil.getBundle("room.ora.dis.per.numeric.code"), new Exception(messageUtil.getBundle("room.ora.dis.per.numeric.message")));
								}
							}
							
							// Commission Validate
							if (StringUtils.isEmpty(roomModel.getCommission())) {
								exceptions.put(messageUtil.getBundle("room.commission.null.code"), new Exception(messageUtil.getBundle("room.commission.null.message")));
							} else {
								if (!Util.isNumeric(roomModel.getCommission())) {
									exceptions.put(messageUtil.getBundle("room.commission.numeric.code"), new Exception(messageUtil.getBundle("room.commission.numeric.message")));
								} else {
									if (Integer.valueOf(roomModel.getCommission()) >= 100) {
										exceptions.put(messageUtil.getBundle("room.commission.less100.code"), new Exception(messageUtil.getBundle("room.commission.less100.message")));
									}
								}
							}
							
							// Accommodation Name Check
							if (StringUtils.isEmpty(roomModel.getAccommodationName())) {
								exceptions.put(messageUtil.getBundle("room.accommodation.null.code"), new Exception(messageUtil.getBundle("room.accommodation.null.message")));
							} else {
		
								if (!Util.accommodationContains(roomModel.getAccommodationName())) {
									exceptions.put(messageUtil.getBundle("room.accommodation.invalid.code"), new Exception(messageUtil.getBundle("room.accommodation.invalid.message")));
								} else {
									
									// Price Logic For Shared
									if(roomModel.getAccommodationName().equals(Accommodation.SHARED.name())){
										
										// Check Stay type Long term
										if(stayTypeEntity.getStayTypeId() == StayType.LONGTERM.ordinal()){
											
											// Validate Shared Bed Price Per Month
											if (StringUtils.isEmpty(roomModel.getSharedBedPricePerMonth())) {
												exceptions.put(messageUtil.getBundle("shared.bed.price.pm.null.code"), new Exception(messageUtil.getBundle("shared.bed.price.pm.null.message")));
											} else {
												if (!Util.isNumeric(roomModel.getSharedBedPricePerMonth())) {
													exceptions.put(messageUtil.getBundle("shared.bed.price.pm.numeric.code"), new Exception(messageUtil.getBundle("shared.bed.price.pm.numeric.message")));
												}
											}
										}
										
										// Check Stay type Short term
										if(stayTypeEntity.getStayTypeId() == StayType.SHORTTERM.ordinal()){
											
											// Validate Shared Bed Price Per Night
											if (StringUtils.isEmpty(roomModel.getSharedBedPricePerNight())) {
												exceptions.put(messageUtil.getBundle("shared.bed.price.pn.null.code"), new Exception(messageUtil.getBundle("shared.bed.price.pn.null.message")));
											} else {
												if (!Util.isNumeric(roomModel.getSharedBedPricePerNight())) {
													exceptions.put(messageUtil.getBundle("shared.bed.price.pn.numeric.code"), new Exception(messageUtil.getBundle("shared.bed.price.pn.numeric.message")));
												}
											}
										}
										
										// Check Stay type Both term
										if(stayTypeEntity.getStayTypeId() == StayType.BOTH.ordinal()){
											
											// Validate Shared Bed Price Per Month
											if (StringUtils.isEmpty(roomModel.getSharedBedPricePerMonth())) {
												exceptions.put(messageUtil.getBundle("shared.bed.price.pm.null.code"), new Exception(messageUtil.getBundle("shared.bed.price.pm.null.message")));
											} else {
												if (!Util.isNumeric(roomModel.getSharedBedPricePerMonth())) {
													exceptions.put(messageUtil.getBundle("shared.bed.price.pm.numeric.code"), new Exception(messageUtil.getBundle("shared.bed.price.pm.numeric.message")));
												}
											}
											
											// Validate Shared Bed Price Per Night
											if (StringUtils.isEmpty(roomModel.getSharedBedPricePerNight())) {
												exceptions.put(messageUtil.getBundle("shared.bed.price.pn.null.code"), new Exception(messageUtil.getBundle("shared.bed.price.pn.null.message")));
											} else {
												if (!Util.isNumeric(roomModel.getSharedBedPricePerNight())) {
													exceptions.put(messageUtil.getBundle("shared.bed.price.pn.numeric.code"), new Exception(messageUtil.getBundle("shared.bed.price.pn.numeric.message")));
												}
											}
											
										}
										
										// Room Vs Bed
										if (StringUtils.isEmpty(roomModel.getNumOfBed())) {
											exceptions.put(messageUtil.getBundle("room.vs.bed.null.code"), new Exception(messageUtil.getBundle("room.vs.bed.null.message")));
										} else if (!Util.isNumeric(roomModel.getNumOfBed())) {
												exceptions.put(messageUtil.getBundle("room.no.of.bed.numeric.code"), new Exception(messageUtil.getBundle("room.no.of.bed.numeric.message")));
										}
										
									}
									
									// Price Logic For Private
									if(roomModel.getAccommodationName().equals(Accommodation.PRIVATE.name())){
										
										// No Of Guest
										if (StringUtils.isEmpty(roomModel.getNoOfGuest())) {
											exceptions.put(messageUtil.getBundle("room.noofguest.null.code"), new Exception(messageUtil.getBundle("room.noofguest.null.message")));
										} else {
											if (!Util.isNumeric(roomModel.getNoOfGuest())) {
												exceptions.put(messageUtil.getBundle("room.noofguest.numeric.code"), new Exception(messageUtil.getBundle("room.noofguest.numeric.message")));
											}
										}
										
										// Validate Cot Price
										if(roomModel.getCotAvailable().equals(PropertyAddConstant.STR_Y)){
											if(StringUtils.isEmpty(roomModel.getCotPrice())){
												exceptions.put(messageUtil.getBundle("cot.price.null.code"), new Exception(messageUtil.getBundle("cot.price.null.message")));
											} else {
												if(!Util.isNumeric(roomModel.getCotPrice())) {
													exceptions.put(messageUtil.getBundle("cot.price.numeric.code"), new Exception(messageUtil.getBundle("cot.price.numeric.message")));
												}
											}
											
										}
										
										// Check Stay type Long term
										if(stayTypeEntity.getStayTypeId() == StayType.LONGTERM.ordinal()){
											
											// Validate Room Price Per Month
											if (StringUtils.isEmpty(roomModel.getRoomPricePerMonth())) {
												exceptions.put(messageUtil.getBundle("room.price.pm.null.code"), new Exception(messageUtil.getBundle("room.price.pm.null.message")));
											} else {
												if (!Util.isNumeric(roomModel.getRoomPricePerMonth())) {
													exceptions.put(messageUtil.getBundle("room.price.pm.numeric.code"), new Exception(messageUtil.getBundle("room.price.pm.numeric.message")));
												}
											}
										}
										
										// Check Stay type Short term
										if(stayTypeEntity.getStayTypeId() == StayType.SHORTTERM.ordinal()){
											
											// Validate Room Price Per Night
											if (StringUtils.isEmpty(roomModel.getRoomPricePerNight())) {
												exceptions.put(messageUtil.getBundle("room.price.pn.null.code"), new Exception(messageUtil.getBundle("room.price.pn.null.message")));
											} else {
												if (!Util.isNumeric(roomModel.getRoomPricePerNight())) {
													exceptions.put(messageUtil.getBundle("room.price.pn.numeric.code"), new Exception(messageUtil.getBundle("room.price.pn.numeric.message")));
												}
											}
										}
										
										// Check Stay type Both term
										if(stayTypeEntity.getStayTypeId() == StayType.BOTH.ordinal()){
											
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
		
							// Room Vs Amenities and Room Standard
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
								
								String roomStd = "";
								boolean flag = true;
										// Premium
										if(premiumFlagY >= Integer.valueOf(messageUtil.getBundle("premium.flag.count"))) {
											roomStd = RoomStandard.PREMIUM.name();
											flag = false;
										} 
								if(flag) {
										// Express
										if(expressFlagY >= Integer.valueOf(messageUtil.getBundle("express.flag.count"))) {
											roomStd = RoomStandard.EXPRESS.name();
											flag = false;
										} 
									}
								
								if(flag) {
											// Normal
									roomStd = RoomStandard.NORMAL.name();
								}
								
								roomModel.setRoomStandard(roomStd);
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
							if(Objects.nonNull(roomModel.getRoomVsMealModels())){
								for(RoomVsMealModel roomVsMealModel : roomModel.getRoomVsMealModels()){
									
									//Validate Meal Plan
									if (Objects.nonNull(roomVsMealModel.getMealPlanModel())) {
										if (StringUtils.isEmpty(roomVsMealModel.getMealPlanModel().getMealPlanId())) {
											exceptions.put(messageUtil.getBundle("meal.plan.null.code"), new Exception(messageUtil.getBundle("meal.plan.null.message")));
										} else {
											if (!Util.isNumeric(roomVsMealModel.getMealPlanModel().getMealPlanId())) {
												exceptions.put(messageUtil.getBundle("meal.plan.numeric.code"), new Exception(messageUtil.getBundle("meal.plan.numeric.message")));
											} else {
												MealPlanEntity mealPlanEntity = mealPlanDAO.find(Long.valueOf(roomVsMealModel.getMealPlanModel().getMealPlanId()));
												if (Objects.isNull(mealPlanEntity) && mealPlanEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("meal.plan.id.invalid.code"), new Exception(messageUtil.getBundle("meal.plan.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("meal.plan.null.code"), new Exception(messageUtil.getBundle("meal.plan.null.message")));
									}
									
									//Meal Days Sunday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysSunday())){
										if (!(roomVsMealModel.getMealDaysSunday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysSunday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.sunday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.sunday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysSunday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Sunday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeSunday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeSunday())){
														exceptions.put(messageUtil.getBundle("meal.type.sunday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.sunday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.sunday.null.code"), new Exception(messageUtil.getBundle("meal.type.sunday.null.message")));
												}
												
												// Validate Meal Price Category Sunday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategorySunday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategorySunday())){
														exceptions.put(messageUtil.getBundle("meal.price.sunday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.sunday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.sunday.null.code"), new Exception(messageUtil.getBundle("meal.price.sunday.null.message")));
												}
												
											}
										}
									}
									
									//Meal Days Monday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysMonday())){
										if (!(roomVsMealModel.getMealDaysMonday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysMonday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.monday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.monday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysMonday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Monday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeMonday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeMonday())){
														exceptions.put(messageUtil.getBundle("meal.type.monday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.monday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.monday.null.code"), new Exception(messageUtil.getBundle("meal.type.monday.null.message")));
												}
												
												// Validate Meal Price Category Monday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategoryMonday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategoryMonday())){
														exceptions.put(messageUtil.getBundle("meal.price.monday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.monday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.monday.null.code"), new Exception(messageUtil.getBundle("meal.price.monday.null.message")));
												}
												
											}
										}
									}
									
									//Meal Days Tuesday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysTuesday())){
										if (!(roomVsMealModel.getMealDaysTuesday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysTuesday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.tuesday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.tuesday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysTuesday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Tuesday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeTuesday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeTuesday())){
														exceptions.put(messageUtil.getBundle("meal.type.tuesday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.tuesday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.tuesday.null.code"), new Exception(messageUtil.getBundle("meal.type.tuesday.null.message")));
												}
												
												// Validate Meal Price Category Tuesday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategoryTuesday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategoryTuesday())){
														exceptions.put(messageUtil.getBundle("meal.price.tuesday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.tuesday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.tuesday.null.code"), new Exception(messageUtil.getBundle("meal.price.tuesday.null.message")));
												}
												
											}
										}
									}
									
									//Meal Days Wednesday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysWednesday())){
										if (!(roomVsMealModel.getMealDaysWednesday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysWednesday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.wednesday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.wednesday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysWednesday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Wednesday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeWednesday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeWednesday())){
														exceptions.put(messageUtil.getBundle("meal.type.wednesday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.wednesday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.wednesday.null.code"), new Exception(messageUtil.getBundle("meal.type.wednesday.null.message")));
												}
												
												// Validate Meal Price Category Wednesday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategoryWednesday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategoryWednesday())){
														exceptions.put(messageUtil.getBundle("meal.price.wednesday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.wednesday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.wednesday.null.code"), new Exception(messageUtil.getBundle("meal.price.wednesday.null.message")));
												}
												
											}
										}
									}
									
									//Meal Days Thursday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysThursday())){
										if (!(roomVsMealModel.getMealDaysThursday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysThursday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.thursday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.thursday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysThursday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Thursday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeThursday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeThursday())){
														exceptions.put(messageUtil.getBundle("meal.type.thursday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.thursday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.thursday.null.code"), new Exception(messageUtil.getBundle("meal.type.thursday.null.message")));
												}
												
												// Validate Meal Price Category Thursday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategoryThursday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategoryThursday())){
														exceptions.put(messageUtil.getBundle("meal.price.thursday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.thursday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.thursday.null.code"), new Exception(messageUtil.getBundle("meal.price.thursday.null.message")));
												}
												
											}
										}
									}
									
									//Meal Days Friday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysFriday())){
										if (!(roomVsMealModel.getMealDaysFriday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysFriday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.friday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.friday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysFriday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Friday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeFriday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeFriday())){
														exceptions.put(messageUtil.getBundle("meal.type.friday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.friday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.friday.null.code"), new Exception(messageUtil.getBundle("meal.type.friday.null.message")));
												}
												
												// Validate Meal Price Category Friday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategoryFriday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategoryFriday())){
														exceptions.put(messageUtil.getBundle("meal.price.friday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.friday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.friday.null.code"), new Exception(messageUtil.getBundle("meal.price.friday.null.message")));
												}
												
											}
										}
									}
									
									//Meal Days Saturday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysSaturday())){
										if (!(roomVsMealModel.getMealDaysSaturday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysSaturday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.saturday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.saturday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysSaturday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Saturday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeSaturday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeSaturday())){
														exceptions.put(messageUtil.getBundle("meal.type.saturday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.saturday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.saturday.null.code"), new Exception(messageUtil.getBundle("meal.type.saturday.null.message")));
												}
												
												// Validate Meal Price Category Saturday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategorySaturday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategorySaturday())){
														exceptions.put(messageUtil.getBundle("meal.price.saturday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.saturday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.saturday.null.code"), new Exception(messageUtil.getBundle("meal.price.saturday.null.message")));
												}
												
											}
										}
									}
									
								}
								
							} else {
								exceptions.put(messageUtil.getBundle("meal.plan.null.code"), new Exception(messageUtil.getBundle("meal.category.null.message")));
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
					StayTypeEntity stayTypeEntity = null;
					//Validate Stay Type
					if (Objects.isNull(propertyModel.getStayTypeModel())) {
						exceptions.put(messageUtil.getBundle("stay.type.null.code"), new Exception(messageUtil.getBundle("stay.type.null.message")));
					} else {
						if (StringUtils.isBlank(propertyModel.getStayTypeModel().getStayTypeId())) {
							exceptions.put(messageUtil.getBundle("stay.type.id.null.code"), new Exception(messageUtil.getBundle("stay.type.id.null.message")));
						} else {
							if (!Util.isNumeric(propertyModel.getStayTypeModel().getStayTypeId())) {
								exceptions.put(messageUtil.getBundle("stay.type.id.invalid.code"), new Exception(messageUtil.getBundle("stay.type.id.invalid.message")));
							} else {
								stayTypeEntity = stayTypeDAO.find(Long.parseLong(propertyModel.getStayTypeModel().getStayTypeId()));
								if (Objects.isNull(stayTypeEntity) && stayTypeEntity.getStatus() != Status.ACTIVE.ordinal()) {
									exceptions.put(messageUtil.getBundle("stay.type.id.invalid.code"), new Exception(messageUtil.getBundle("stay.type.id.invalid.message")));
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
								validateLanguage(propertyVsDescriptionModel.getLanguageId());
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
					if (StringUtils.isEmpty(propertyModel.getSexCategory())) {
						exceptions.put(messageUtil.getBundle("property.pgcs.null.code"), new Exception(messageUtil.getBundle("property.pgcs.null.message")));
					} else {
						if (!Util.sexContains(propertyModel.getSexCategory())) {
							exceptions.put(messageUtil.getBundle("property.pgcs.invalid.code"), new Exception(messageUtil.getBundle("property.pgcs.invalid.message")));
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
					if (Objects.isNull(propertyModel.getHostVsAccountModel())) {
						exceptions.put(messageUtil.getBundle("property.user.null.code"), new Exception(messageUtil.getBundle("property.user.null.message")));
					} else {
						
						//User Vs Account Id Validate
						if(StringUtils.isBlank(String.valueOf(propertyModel.getHostVsAccountModel().getHostVsAccountId()))){
							exceptions.put(messageUtil.getBundle("uservsacc.id.null.code"), new Exception(messageUtil.getBundle("uservsacc.id.null.message")));
						} else {
							if(Util.isNumeric(String.valueOf(propertyModel.getHostVsAccountModel().getHostVsAccountId()))){
								
								HostVsAccountEntity userVsAccountEntity = userVsAccountDAO.find(Long.valueOf(propertyModel.getHostVsAccountModel().getHostVsAccountId()));
								
								if(Objects.isNull(userVsAccountEntity)){
									exceptions.put(messageUtil.getBundle("uservsacc.id.invalid.code"), new Exception(messageUtil.getBundle("uservsacc.id.invalid.message")));
								}
							} else {
								exceptions.put(messageUtil.getBundle("uservsacc.id.numeric.code"), new Exception(messageUtil.getBundle("uservsacc.id.numeric.message")));
							}
						}
						
						
						if (Util.isEmpty(propertyModel.getHostVsAccountModel().getAccountHolderName())) {
							exceptions.put(messageUtil.getBundle("accholder.name.null.code"), new Exception(messageUtil.getBundle("accholder.name.null.message")));
						}
						if (Util.isEmpty(propertyModel.getHostVsAccountModel().getAccountNumber())) {
							exceptions.put(messageUtil.getBundle("account.no.null.code"), new Exception(messageUtil.getBundle("account.no.null.message")));
						}
						if (Util.isEmpty(propertyModel.getHostVsAccountModel().getAccountType())) {
							exceptions.put(messageUtil.getBundle("account.type.null.code"), new Exception(messageUtil.getBundle("account.type.null.message")));
						}
						if (Util.isEmpty(propertyModel.getHostVsAccountModel().getIfscCode())) {
							exceptions.put(messageUtil.getBundle("ifsc.code.null.code"), new Exception(messageUtil.getBundle("ifsc.code.null.message")));
						}
					}
		
					// Property Vs Document
					if (Objects.isNull(propertyModel.getPropertyVsDocumentModels())) {
						exceptions.put(messageUtil.getBundle("property.document.null.code"), new Exception(messageUtil.getBundle("property.document.null.message")));
					} else {
		
						for (PropertyVsDocumentModel propertyVsDocumentModel : propertyModel.getPropertyVsDocumentModels()) {
							
							//Validate Property Vs Document Id
							if(StringUtils.isBlank(String.valueOf(propertyVsDocumentModel.getPropertyVsDocumentId()))){
								exceptions.put(messageUtil.getBundle("property.document.id.null.code"), new Exception(messageUtil.getBundle("property.document.id.null.message")));
							} else {
								if(Util.isNumeric(String.valueOf(propertyVsDocumentModel.getPropertyVsDocumentId()))){
									
									PropertyVsDocumentEntity propertyVsDocumentEntity = propertyVsDocumentDAO.find(Long.valueOf(propertyVsDocumentModel.getPropertyVsDocumentId()));
									
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
							
							roomModel.setOraRoomName("ORA"+new Date().getTime());
		
							// Shared Space
							if (StringUtils.isBlank(roomModel.getSharedSpace())) {
								exceptions.put(messageUtil.getBundle("room.sharedSpace.null.code"),new Exception(messageUtil.getBundle("room.sharedSpace.null.message")));
							} else {
		
								if (!(roomModel.getSharedSpace().equals(PropertyAddConstant.STR_Y) || roomModel.getSharedSpace().equals(PropertyAddConstant.STR_N))) {
									exceptions.put(messageUtil.getBundle("room.sharedSpace.invalid.code"), new Exception(messageUtil.getBundle("room.sharedSpace.invalid.message")));
								} else {
									
									if(roomModel.getSharedSpace().equals(PropertyAddConstant.STR_Y)){
										if(StringUtils.isEmpty(roomModel.getSharedBedPrice())){
											exceptions.put(messageUtil.getBundle("room.sharedprice.null.code"), new Exception(messageUtil.getBundle("room.sharedprice.null.message")));
										} else {
											if(!Util.isNumeric(roomModel.getSharedBedPrice())) {
												exceptions.put(messageUtil.getBundle("room.sharedprice.numeric.code"), new Exception(messageUtil.getBundle("room.sharedprice.numeric.message")));
											}
										}
										
									}
									
								}
							}
		
							// CotAvailable
							if (!StringUtils.isBlank(roomModel.getCotAvailable())) {
								if (!(roomModel.getCotAvailable().equals(PropertyAddConstant.STR_Y) || roomModel.getCotAvailable().equals(PropertyAddConstant.STR_N))) {
									exceptions.put(messageUtil.getBundle("room.cotavail.invalid.code"), new Exception(messageUtil.getBundle("room.cotavail.invalid.message")));
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
		
							// Host Discount Weekly
							if (!StringUtils.isBlank(roomModel.getHostDiscountWeekly())) {
								if (!Util.isNumeric(roomModel.getHostDiscountWeekly())) {
									exceptions.put(messageUtil.getBundle("room.host.discount.numeric.code"), new Exception(messageUtil.getBundle("room.host.discount.numeric.message")));
								}
							}
							
							// Host Discount Monthly
							if (!StringUtils.isBlank(roomModel.getHostDiscountMonthly())) {
								if (!Util.isNumeric(roomModel.getHostDiscountMonthly())) {
									exceptions.put(messageUtil.getBundle("room.host.dis.monthly.numeric.code"), new Exception(messageUtil.getBundle("room.host.dis.monthly.numeric.message")));
								}
							}
							
							// Ora Discount Percentage
							if (!StringUtils.isBlank(roomModel.getOraDiscountPercentage())) {
								if (!Util.isNumeric(roomModel.getOraDiscountPercentage())) {
									exceptions.put(messageUtil.getBundle("room.ora.dis.per.numeric.code"), new Exception(messageUtil.getBundle("room.ora.dis.per.numeric.message")));
								}
							}
							
							// Commission Validate
							if (StringUtils.isEmpty(roomModel.getCommission())) {
								exceptions.put(messageUtil.getBundle("room.commission.null.code"), new Exception(messageUtil.getBundle("room.commission.null.message")));
							} else {
								if (!Util.isNumeric(roomModel.getCommission())) {
									exceptions.put(messageUtil.getBundle("room.commission.numeric.code"), new Exception(messageUtil.getBundle("room.commission.numeric.message")));
								} else {
									if (Integer.valueOf(roomModel.getCommission()) >= 100) {
										exceptions.put(messageUtil.getBundle("room.commission.less100.code"), new Exception(messageUtil.getBundle("room.commission.less100.message")));
									}
								}
							}
							
							// Accommodation Check
							if (StringUtils.isEmpty(roomModel.getAccommodationName())) {
								exceptions.put(messageUtil.getBundle("room.accommodation.null.code"), new Exception(messageUtil.getBundle("room.accommodation.null.message")));
							} else {
		
								if (!Util.accommodationContains(roomModel.getAccommodationName())) {
									exceptions.put(messageUtil.getBundle("room.accommodation.invalid.code"), new Exception(messageUtil.getBundle("room.accommodation.invalid.message")));
								} else {
									
									// Price Logic For Shared
									if(roomModel.getAccommodationName().equals(Accommodation.SHARED.name())){
										
										// Room Vs Bed
										if (StringUtils.isEmpty(roomModel.getNumOfBed())) {
											exceptions.put(messageUtil.getBundle("room.vs.bed.null.code"), new Exception(messageUtil.getBundle("room.vs.bed.null.message")));
										} else if (!Util.isNumeric(roomModel.getNumOfBed())) {
												exceptions.put(messageUtil.getBundle("room.no.of.bed.numeric.code"), new Exception(messageUtil.getBundle("room.no.of.bed.numeric.message")));
										}
										
										// Check Stay type Long term
										if(stayTypeEntity.getStayTypeId() == StayType.LONGTERM.ordinal()){
											
											// Validate Shared Bed Price Per Month
											if (StringUtils.isEmpty(roomModel.getSharedBedPricePerMonth())) {
												exceptions.put(messageUtil.getBundle("shared.bed.price.pm.null.code"), new Exception(messageUtil.getBundle("shared.bed.price.pm.null.message")));
											} else {
												if (!Util.isNumeric(roomModel.getSharedBedPricePerMonth())) {
													exceptions.put(messageUtil.getBundle("shared.bed.price.pm.numeric.code"), new Exception(messageUtil.getBundle("shared.bed.price.pm.numeric.message")));
												}
											}
										}
										
										// Check Stay type Short term
										if(stayTypeEntity.getStayTypeId() == StayType.SHORTTERM.ordinal()){
											
											// Validate Shared Bed Price Per Night
											if (StringUtils.isEmpty(roomModel.getSharedBedPricePerNight())) {
												exceptions.put(messageUtil.getBundle("shared.bed.price.pn.null.code"), new Exception(messageUtil.getBundle("shared.bed.price.pn.null.message")));
											} else {
												if (!Util.isNumeric(roomModel.getSharedBedPricePerNight())) {
													exceptions.put(messageUtil.getBundle("shared.bed.price.pn.numeric.code"), new Exception(messageUtil.getBundle("shared.bed.price.pn.numeric.message")));
												}
											}
										}
										
										// Check Stay type Both term
										if(stayTypeEntity.getStayTypeId() == StayType.BOTH.ordinal()){
											
											// Validate Shared Bed Price Per Month
											if (StringUtils.isEmpty(roomModel.getSharedBedPricePerMonth())) {
												exceptions.put(messageUtil.getBundle("shared.bed.price.pm.null.code"), new Exception(messageUtil.getBundle("shared.bed.price.pm.null.message")));
											} else {
												if (!Util.isNumeric(roomModel.getSharedBedPricePerMonth())) {
													exceptions.put(messageUtil.getBundle("shared.bed.price.pm.numeric.code"), new Exception(messageUtil.getBundle("shared.bed.price.pm.numeric.message")));
												}
											}
											
											// Validate Shared Bed Price Per Night
											if (StringUtils.isEmpty(roomModel.getSharedBedPricePerNight())) {
												exceptions.put(messageUtil.getBundle("shared.bed.price.pn.null.code"), new Exception(messageUtil.getBundle("shared.bed.price.pn.null.message")));
											} else {
												if (!Util.isNumeric(roomModel.getSharedBedPricePerNight())) {
													exceptions.put(messageUtil.getBundle("shared.bed.price.pn.numeric.code"), new Exception(messageUtil.getBundle("shared.bed.price.pn.numeric.message")));
												}
											}
											
										}
										
										// Room Vs Bed
										if (StringUtils.isEmpty(roomModel.getNumOfBed())) {
											exceptions.put(messageUtil.getBundle("room.vs.bed.null.code"), new Exception(messageUtil.getBundle("room.vs.bed.null.message")));
										} else if (!Util.isNumeric(roomModel.getNumOfBed())) {
												exceptions.put(messageUtil.getBundle("room.no.of.bed.numeric.code"), new Exception(messageUtil.getBundle("room.no.of.bed.numeric.message")));
										}
										
									}
									
									// Price Logic For Private
									if(roomModel.getAccommodationName().equals(Accommodation.PRIVATE.name())){
										
										// No Of Guest
										if (StringUtils.isEmpty(roomModel.getNoOfGuest())) {
											exceptions.put(messageUtil.getBundle("room.noofguest.null.code"), new Exception(messageUtil.getBundle("room.noofguest.null.message")));
										} else {
											if (!Util.isNumeric(roomModel.getNoOfGuest())) {
												exceptions.put(messageUtil.getBundle("room.noofguest.numeric.code"), new Exception(messageUtil.getBundle("room.noofguest.numeric.message")));
											}
										}
										
										// Validate Cot Price
										if(roomModel.getCotAvailable().equals(PropertyAddConstant.STR_Y)){
											if(StringUtils.isEmpty(roomModel.getCotPrice())){
												exceptions.put(messageUtil.getBundle("cot.price.null.code"), new Exception(messageUtil.getBundle("cot.price.null.message")));
											} else {
												if(!Util.isNumeric(roomModel.getCotPrice())) {
													exceptions.put(messageUtil.getBundle("cot.price.numeric.code"), new Exception(messageUtil.getBundle("cot.price.numeric.message")));
												}
											}
											
										}
										
										// Check Stay type Long term
										if(stayTypeEntity.getStayTypeId() == StayType.LONGTERM.ordinal()){
											
											// Validate Room Price Per Month
											if (StringUtils.isEmpty(roomModel.getRoomPricePerMonth())) {
												exceptions.put(messageUtil.getBundle("room.price.pm.null.code"), new Exception(messageUtil.getBundle("room.price.pm.null.message")));
											} else {
												if (!Util.isNumeric(roomModel.getRoomPricePerMonth())) {
													exceptions.put(messageUtil.getBundle("room.price.pm.numeric.code"), new Exception(messageUtil.getBundle("room.price.pm.numeric.message")));
												}
											}
										}
										
										// Check Stay type Short term
										if(stayTypeEntity.getStayTypeId() == StayType.SHORTTERM.ordinal()){
											
											// Validate Room Price Per Night
											if (StringUtils.isEmpty(roomModel.getRoomPricePerNight())) {
												exceptions.put(messageUtil.getBundle("room.price.pn.null.code"), new Exception(messageUtil.getBundle("room.price.pn.null.message")));
											} else {
												if (!Util.isNumeric(roomModel.getRoomPricePerNight())) {
													exceptions.put(messageUtil.getBundle("room.price.pn.numeric.code"), new Exception(messageUtil.getBundle("room.price.pn.numeric.message")));
												}
											}
										}
										
										// Check Stay type Both term
										if(stayTypeEntity.getStayTypeId() == StayType.BOTH.ordinal()){
											
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
													// Express Flag Calculation
													if(amenitiesEntity.getExpressFlag().equals(PropertyAddConstant.STR_Y)){
														expressFlagY++;
													}
													//Premium Flag Calculation
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
								String roomStd = "";
								boolean flag = true;
										// Premium
										if(premiumFlagY >= Integer.valueOf(messageUtil.getBundle("premium.flag.count"))) {
											roomStd = RoomStandard.PREMIUM.name();
											flag = false;
										} 
								if(flag) {
										// Express
										if(expressFlagY >= Integer.valueOf(messageUtil.getBundle("express.flag.count"))) {
											roomStd = RoomStandard.EXPRESS.name();
											flag = false;
										} 
									}
								
								if(flag) {
											// Normal
									roomStd = RoomStandard.NORMAL.name();
								}
								
								roomModel.setRoomStandard(roomStd);
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
							// Room Vs Meal
							if(Objects.nonNull(roomModel.getRoomVsMealModels())){
								for(RoomVsMealModel roomVsMealModel : roomModel.getRoomVsMealModels()){
									
									//Validate Meal Plan
									if (Objects.nonNull(roomVsMealModel.getMealPlanModel())) {
										if (StringUtils.isEmpty(roomVsMealModel.getMealPlanModel().getMealPlanId())) {
											exceptions.put(messageUtil.getBundle("meal.plan.null.code"), new Exception(messageUtil.getBundle("meal.plan.null.message")));
										} else {
											if (!Util.isNumeric(roomVsMealModel.getMealPlanModel().getMealPlanId())) {
												exceptions.put(messageUtil.getBundle("meal.plan.numeric.code"), new Exception(messageUtil.getBundle("meal.plan.numeric.message")));
											} else {
												MealPlanEntity mealPlanEntity = mealPlanDAO.find(Long.valueOf(roomVsMealModel.getMealPlanModel().getMealPlanId()));
												if (Objects.isNull(mealPlanEntity) && mealPlanEntity.getStatus() != Status.ACTIVE.ordinal()) {
													exceptions.put(messageUtil.getBundle("meal.plan.id.invalid.code"), new Exception(messageUtil.getBundle("meal.plan.id.invalid.message")));
												}
											}
										}
									} else {
										exceptions.put(messageUtil.getBundle("meal.plan.null.code"), new Exception(messageUtil.getBundle("meal.plan.null.message")));
									}
									
									//Meal Days Sunday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysSunday())){
										if (!(roomVsMealModel.getMealDaysSunday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysSunday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.sunday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.sunday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysSunday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Sunday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeSunday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeSunday())){
														exceptions.put(messageUtil.getBundle("meal.type.sunday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.sunday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.sunday.null.code"), new Exception(messageUtil.getBundle("meal.type.sunday.null.message")));
												}
												
												// Validate Meal Price Category Sunday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategorySunday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategorySunday())){
														exceptions.put(messageUtil.getBundle("meal.price.sunday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.sunday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.sunday.null.code"), new Exception(messageUtil.getBundle("meal.price.sunday.null.message")));
												}
												
											}
										}
									}
									
									//Meal Days Monday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysMonday())){
										if (!(roomVsMealModel.getMealDaysMonday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysMonday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.monday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.monday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysMonday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Monday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeMonday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeMonday())){
														exceptions.put(messageUtil.getBundle("meal.type.monday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.monday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.monday.null.code"), new Exception(messageUtil.getBundle("meal.type.monday.null.message")));
												}
												
												// Validate Meal Price Category Monday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategoryMonday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategoryMonday())){
														exceptions.put(messageUtil.getBundle("meal.price.monday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.monday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.monday.null.code"), new Exception(messageUtil.getBundle("meal.price.monday.null.message")));
												}
												
											}
										}
									}
									
									//Meal Days Tuesday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysTuesday())){
										if (!(roomVsMealModel.getMealDaysTuesday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysTuesday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.tuesday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.tuesday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysTuesday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Tuesday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeTuesday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeTuesday())){
														exceptions.put(messageUtil.getBundle("meal.type.tuesday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.tuesday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.tuesday.null.code"), new Exception(messageUtil.getBundle("meal.type.tuesday.null.message")));
												}
												
												// Validate Meal Price Category Tuesday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategoryTuesday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategoryTuesday())){
														exceptions.put(messageUtil.getBundle("meal.price.tuesday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.tuesday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.tuesday.null.code"), new Exception(messageUtil.getBundle("meal.price.tuesday.null.message")));
												}
												
											}
										}
									}
									
									//Meal Days Wednesday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysWednesday())){
										if (!(roomVsMealModel.getMealDaysWednesday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysWednesday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.wednesday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.wednesday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysWednesday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Wednesday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeWednesday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeWednesday())){
														exceptions.put(messageUtil.getBundle("meal.type.wednesday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.wednesday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.wednesday.null.code"), new Exception(messageUtil.getBundle("meal.type.wednesday.null.message")));
												}
												
												// Validate Meal Price Category Wednesday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategoryWednesday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategoryWednesday())){
														exceptions.put(messageUtil.getBundle("meal.price.wednesday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.wednesday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.wednesday.null.code"), new Exception(messageUtil.getBundle("meal.price.wednesday.null.message")));
												}
												
											}
										}
									}
									
									//Meal Days Thursday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysThursday())){
										if (!(roomVsMealModel.getMealDaysThursday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysThursday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.thursday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.thursday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysThursday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Thursday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeThursday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeThursday())){
														exceptions.put(messageUtil.getBundle("meal.type.thursday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.thursday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.thursday.null.code"), new Exception(messageUtil.getBundle("meal.type.thursday.null.message")));
												}
												
												// Validate Meal Price Category Thursday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategoryThursday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategoryThursday())){
														exceptions.put(messageUtil.getBundle("meal.price.thursday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.thursday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.thursday.null.code"), new Exception(messageUtil.getBundle("meal.price.thursday.null.message")));
												}
												
											}
										}
									}
									
									//Meal Days Friday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysFriday())){
										if (!(roomVsMealModel.getMealDaysFriday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysFriday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.friday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.friday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysFriday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Friday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeFriday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeFriday())){
														exceptions.put(messageUtil.getBundle("meal.type.friday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.friday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.friday.null.code"), new Exception(messageUtil.getBundle("meal.type.friday.null.message")));
												}
												
												// Validate Meal Price Category Friday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategoryFriday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategoryFriday())){
														exceptions.put(messageUtil.getBundle("meal.price.friday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.friday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.friday.null.code"), new Exception(messageUtil.getBundle("meal.price.friday.null.message")));
												}
												
											}
										}
									}
									
									//Meal Days Saturday
									if(!StringUtils.isEmpty(roomVsMealModel.getMealDaysSaturday())){
										if (!(roomVsMealModel.getMealDaysSaturday().equals(PropertyAddConstant.STR_Y) || roomVsMealModel.getMealDaysSaturday().equals(PropertyAddConstant.STR_N))) {
											exceptions.put(messageUtil.getBundle("meal.days.saturday.invalid.code"), new Exception(messageUtil.getBundle("meal.days.saturday.invalid.message")));
										} else {
											if (roomVsMealModel.getMealDaysSaturday().equals(PropertyAddConstant.STR_Y)){
												
												// Validate Meal Type Saturday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealTypeSaturday())){
													if(!Util.mealTypeContains(roomVsMealModel.getMealTypeSaturday())){
														exceptions.put(messageUtil.getBundle("meal.type.saturday.invalid.code"), new Exception(messageUtil.getBundle("meal.type.saturday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.type.saturday.null.code"), new Exception(messageUtil.getBundle("meal.type.saturday.null.message")));
												}
												
												// Validate Meal Price Category Saturday
												if(!StringUtils.isEmpty(roomVsMealModel.getMealPriceCategorySaturday())){
													if(!Util.mealPriceContains(roomVsMealModel.getMealPriceCategorySaturday())){
														exceptions.put(messageUtil.getBundle("meal.price.saturday.invalid.code"), new Exception(messageUtil.getBundle("meal.price.saturday.invalid.message")));
													}
												} else {
													exceptions.put(messageUtil.getBundle("meal.price.saturday.null.code"), new Exception(messageUtil.getBundle("meal.price.saturday.null.message")));
												}
												
											}
										}
									}
									
								}
								
							} else {
								exceptions.put(messageUtil.getBundle("meal.plan.null.code"), new Exception(messageUtil.getBundle("meal.category.null.message")));
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