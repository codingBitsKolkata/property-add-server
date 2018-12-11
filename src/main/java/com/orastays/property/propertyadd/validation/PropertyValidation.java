package com.orastays.property.propertyadd.validation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.orastays.property.propertyadd.exceptions.FormExceptions;
import com.orastays.property.propertyadd.helper.PropertyAddConstant;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.CommonModel;
import com.orastays.property.propertyadd.model.PropertyModel;
import com.orastays.property.propertyadd.model.PropertyVsDescriptionModel;
import com.orastays.property.propertyadd.model.PropertyVsGuestAccessModel;
import com.orastays.property.propertyadd.model.PropertyVsNearbyModel;
import com.orastays.property.propertyadd.model.PropertyVsSpaceRuleModel;
import com.orastays.property.propertyadd.model.PropertyVsSpecialExperienceModel;

@Component
@Transactional
public class PropertyValidation extends AuthorizeUserValidation {

	private static final Logger logger = LogManager.getLogger(PropertyValidation.class);
	
	public void validateLanguageWithUserToken(Object object, String message) throws FormExceptions {

		if (logger.isDebugEnabled()) {
			logger.debug("validateLanguageWithUserToken -- Start");
		}

		Util.printLog(object, PropertyAddConstant.INCOMING, message, request);
		if (object instanceof CommonModel) {
			CommonModel commonModel = (CommonModel) object;
			validateTokenAndLanguage(commonModel, message);
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("validateLanguageWithUserToken -- End");
		}
	}
	
	private void validateTokenAndLanguage(CommonModel commonModel, String message) throws FormExceptions {

		if (logger.isDebugEnabled()) {
			logger.debug("validateLanguageWithUserToken -- Start");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		// Validate User Token
		if(StringUtils.isBlank(commonModel.getUserToken())) {
			exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
		} else {
			getUserDetails(commonModel.getUserToken());
		}
		
		// Validate Language
		if(StringUtils.isBlank(commonModel.getLanguageId())) {
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
	
	public void validatePropertyAdd(PropertyModel propertyModel) throws FormExceptions {

		if (logger.isDebugEnabled()) {
			logger.debug("validatePropertyAdd -- Start");
		}

		Util.printLog(propertyModel, PropertyAddConstant.INCOMING, "Property Add", request);

		Map<String, Exception> exceptions = new LinkedHashMap<>();
		
		if(Objects.nonNull(propertyModel)) {
			
			// Validate Property Name
			if(StringUtils.isBlank(propertyModel.getName())) {
				exceptions.put(messageUtil.getBundle("property.name.null.code"), new Exception(messageUtil.getBundle("property.name.null.message")));
			} else {
				if(!Util.checkAlphabet(propertyModel.getName())) {
					exceptions.put(messageUtil.getBundle("property.name.invalid.code"), new Exception(messageUtil.getBundle("property.name.invalid.message")));
				}
			}
			
			// Calculation Pending
			propertyModel.setOraname("ORA000011");
			
			//validate Entire Apartment
			if(StringUtils.isBlank(propertyModel.getEntireApartment())) {
				exceptions.put(messageUtil.getBundle("entire.appartment.null.code"), new Exception(messageUtil.getBundle("entire.appartment.null.message")));
			}
			
			//Validate Latitude
			if(StringUtils.isBlank(propertyModel.getLatitude())) {
				exceptions.put(messageUtil.getBundle("latitude.null.code"), new Exception(messageUtil.getBundle("latitude.null.message")));
			} else {
				if(!Util.checkLatitude(propertyModel.getLatitude())) {
					exceptions.put(messageUtil.getBundle("latitude.invalid.code"), new Exception(messageUtil.getBundle("latitude.invalid.message")));
				}
			}
			
			//Validate Longitude
			if(StringUtils.isBlank(propertyModel.getLongitude())) {
				exceptions.put(messageUtil.getBundle("longitude.null.code"), new Exception(messageUtil.getBundle("longitude.null.message")));
			} else {
				if(!Util.checkLongitude(propertyModel.getLongitude())) {
					exceptions.put(messageUtil.getBundle("longitude.invalid.code"), new Exception(messageUtil.getBundle("longitude.invalid.message")));
				}
			}
			
			//Validate Address
			if(StringUtils.isBlank(propertyModel.getAddress())) {
				exceptions.put(messageUtil.getBundle("address.null.code"), new Exception(messageUtil.getBundle("address.null.message")));
			}
			
			//Validate Start End Date
			if(StringUtils.isBlank(propertyModel.getStartDate())) {
				exceptions.put(messageUtil.getBundle("start.date.null.code"), new Exception(messageUtil.getBundle("start.date.null.message")));
			} else {
				if(StringUtils.isBlank(propertyModel.getEndDate())) {
					exceptions.put(messageUtil.getBundle("end.date.null.code"), new Exception(messageUtil.getBundle("end.date.null.message")));
				} else {
					
					// logic for date difference
				}
			}
			
			//Validate CheckIn Time
			if(StringUtils.isBlank(propertyModel.getCheckinTime())) {
				exceptions.put(messageUtil.getBundle("checkin.time.null.code"), new Exception(messageUtil.getBundle("checkin.time.null.message")));
			} else {
				if(!Util.checkTimeFormat(propertyModel.getCheckinTime())){
					exceptions.put(messageUtil.getBundle("checkin.time.invalid.code"), new Exception(messageUtil.getBundle("checkin.time.invalid.message")));
				}
			}
			
			//Validate CheckOut Time
			if(StringUtils.isBlank(propertyModel.getCheckoutTime())) {
				exceptions.put(messageUtil.getBundle("checkout.time.null.code"), new Exception(messageUtil.getBundle("checkout.time.null.message")));
			} else {
				if(!Util.checkTimeFormat(propertyModel.getCheckoutTime())){
					exceptions.put(messageUtil.getBundle("checkout.time.invalid.code"), new Exception(messageUtil.getBundle("checkout.time.invalid.message")));
				}
			}
			
			//Validate Image Url
			if(StringUtils.isBlank(propertyModel.getCoverImageUrl())) {
				exceptions.put(messageUtil.getBundle("image.url.null.code"), new Exception(messageUtil.getBundle("image.url.null.message")));
			}

			//Validate Price Drop
			if(StringUtils.isBlank(propertyModel.getPriceDrop())) {
				exceptions.put(messageUtil.getBundle("price.drop.null.code"), new Exception(messageUtil.getBundle("price.drop.null.message")));
			} else {
				
				if(!(propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_Y) || propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_N))){
					exceptions.put(messageUtil.getBundle("price.drop.invalid.code"), new Exception(messageUtil.getBundle("price.drop.invalid.message")));
				} 
			}
			
			//Validate Property Type
			if(Objects.nonNull(propertyModel.getPropertyTypeModel())) {
				exceptions.put(messageUtil.getBundle("property.type.null.code"), new Exception(messageUtil.getBundle("property.type.null.message")));
			} else {
				if(StringUtils.isBlank(propertyModel.getPropertyTypeModel().getPropertyTypeId())) {
					exceptions.put(messageUtil.getBundle("property.type.id.null.code"), new Exception(messageUtil.getBundle("property.type.id.null.message")));
				} else {
					if(!Util.isNumeric(propertyModel.getPropertyTypeModel().getPropertyTypeId())){
						exceptions.put(messageUtil.getBundle("property.type.id.invalid.code"), new Exception(messageUtil.getBundle("property.type.id.invalid.message")));
					} else {
							if(Objects.isNull(propertyTypeDAO.find(Long.parseLong(propertyModel.getPropertyTypeModel().getPropertyTypeId())))) {
								exceptions.put(messageUtil.getBundle("property.type.id.invalid.code"), new Exception(messageUtil.getBundle("property.type.id.invalid.message")));
							}
						} 
				}
			}
			
			// Validate Property Vs Description
			if(Objects.nonNull(propertyModel.getPropertyVsDescriptionModels())) {
				exceptions.put(messageUtil.getBundle("property.description.null.code"), new Exception(messageUtil.getBundle("property.description.null.message")));
			} else {
				
				for(PropertyVsDescriptionModel propertyVsDescriptionModel:propertyModel.getPropertyVsDescriptionModels()){
					if(StringUtils.isBlank(propertyVsDescriptionModel.getDescription())){
						exceptions.put(messageUtil.getBundle("property.description.null.code"), new Exception(messageUtil.getBundle("property.description.null.message")));
					}
					
					if(StringUtils.isBlank(propertyVsDescriptionModel.getLanguageId())) {
						exceptions.put(messageUtil.getBundle("language.id.null.code"), new Exception(messageUtil.getBundle("language.id.null.message")));
					} else {
						validateLanguage(propertyVsDescriptionModel.getLanguageId());
					}
				}
			}
			
			//Property Vs Guest Access
			if(Objects.nonNull(propertyModel.getPropertyVsGuestAccessModels())) {
				exceptions.put(messageUtil.getBundle("property.guest.null.code"), new Exception(messageUtil.getBundle("property.guest.null.message")));
			} else {
				
				for(PropertyVsGuestAccessModel propertyVsGuestAccessModel:propertyModel.getPropertyVsGuestAccessModels()){
					if(StringUtils.isBlank(propertyVsGuestAccessModel.getGuestAccess())){
						exceptions.put(messageUtil.getBundle("property.guest.null.code"), new Exception(messageUtil.getBundle("property.guest.null.message")));
					}
					
					if(StringUtils.isBlank(propertyVsGuestAccessModel.getLanguageId())) {
						exceptions.put(messageUtil.getBundle("language.id.null.code"), new Exception(messageUtil.getBundle("language.id.null.message")));
					} else {
						validateLanguage(propertyVsGuestAccessModel.getLanguageId());
					}
				}
			}
			
				//Immediate Booking
				if(StringUtils.isBlank(propertyModel.getImmediateBooking())){
					exceptions.put(messageUtil.getBundle("property.immbooking.null.code"), new Exception(messageUtil.getBundle("property.immbooking.null.message")));
				} else{
					if(!(propertyModel.getImmediateBooking().equals(PropertyAddConstant.STR_Y) || propertyModel.getImmediateBooking().equals(PropertyAddConstant.STR_N))){
						exceptions.put(messageUtil.getBundle("property.immbooking.invalid.code"), new Exception(messageUtil.getBundle("property.immbooking.invalid.message")));
					}
				}
				
				//Strict Checkin
				if(StringUtils.isBlank(propertyModel.getStrictCheckin())){
					exceptions.put(messageUtil.getBundle("property.checkin.null.code"), new Exception(messageUtil.getBundle("property.checkin.null.message")));
				} else{
					if(!(propertyModel.getStrictCheckin().equals(PropertyAddConstant.STR_Y) || propertyModel.getStrictCheckin().equals(PropertyAddConstant.STR_N))){
						exceptions.put(messageUtil.getBundle("property.checkin.invalid.code"), new Exception(messageUtil.getBundle("property.checkin.invalid.message")));
					}
				}
				 
			
			// Property Vs Image **Optional
			
			//Property Vs NearBy
			if(Objects.nonNull(propertyModel.getPropertyVsNearbyModels())) {
				exceptions.put(messageUtil.getBundle("property.nearby.null.code"), new Exception(messageUtil.getBundle("property.nearby.null.message")));
			} else {
				// Address Validation
				for(PropertyVsNearbyModel propertyVsNearbyModel:propertyModel.getPropertyVsNearbyModels()){
					if(StringUtils.isBlank(propertyVsNearbyModel.getAddress())){
						exceptions.put(messageUtil.getBundle("property.address.null.code"), new Exception(messageUtil.getBundle("property.address.null.message")));
					}
				}
			}
			
			//PropertyVs PGCS **// Not Found
			
			
			//Property Vs Space Rule
			if(Objects.nonNull(propertyModel.getPropertyVsSpaceRuleModels())) {
				exceptions.put(messageUtil.getBundle("property.spacerule.null.code"), new Exception(messageUtil.getBundle("property.spacerule.null.message")));
			} else {
				// Answer Validation
				for(PropertyVsSpaceRuleModel propertyVsSpaceRuleModel:propertyModel.getPropertyVsSpaceRuleModels()){
					if(StringUtils.isBlank(propertyVsSpaceRuleModel.getAnswer())){
						exceptions.put(messageUtil.getBundle("property.spacerule.answer.null.code"), new Exception(messageUtil.getBundle("property.sp.answer.null.message")));
					} else {
						if(!(propertyVsSpaceRuleModel.getAnswer().equals(PropertyAddConstant.STR_Y) || propertyVsSpaceRuleModel.getAnswer().equals(PropertyAddConstant.STR_N))){
							exceptions.put(messageUtil.getBundle("property.spacerule.invalid.code"), new Exception(messageUtil.getBundle("property.spacerule.invalid.message")));
						}
					}
					
					//Validate Space Rule
					if(Objects.nonNull(propertyVsSpaceRuleModel.getSpaceRuleModel())){
						exceptions.put(messageUtil.getBundle("space.rule.null.code"), new Exception(messageUtil.getBundle("space.rule.null.message")));
					} else {
						if(Objects.isNull(spaceRuleDAO.find(Long.parseLong(propertyVsSpaceRuleModel.getSpaceRuleModel().getSpruleId())))) {
							exceptions.put(messageUtil.getBundle("sprule.invalid.code"), new Exception(messageUtil.getBundle("sprule.invalid.message")));
						}
					}
				}
			}
			
			//Property vs Special Experience
			
			if(Objects.nonNull(propertyModel.getPropertyVsSpecialExperienceModels())) {
				exceptions.put(messageUtil.getBundle("special.expe.null.code"), new Exception(messageUtil.getBundle("special.expe.null.message")));
			} else {
				// Answer Validation
				for(PropertyVsSpecialExperienceModel propertyVsExperienceModel:propertyModel.getPropertyVsSpecialExperienceModels()){
					if(Objects.nonNull(propertyVsExperienceModel.getSpecialExperienceModel())){
						exceptions.put(messageUtil.getBundle("special.expe.null.code"), new Exception(messageUtil.getBundle("special.expe.null.message")));
					} else {
						if(Objects.isNull(specialExperienceDAO.find(Long.parseLong(propertyVsExperienceModel.getSpecialExperienceModel().getExperienceId())))) {
							exceptions.put(messageUtil.getBundle("special.expe.invalid.code"), new Exception(messageUtil.getBundle("special.expe.invalid.message")));
						}
					}
					
				}
			}
			//Property Vs Stay Type
			
			
			
		}
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("validatePropertyAdd -- End");
		}
		
	}
	
}