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
import com.orastays.property.propertyadd.model.PropertyVsDocumentModel;
import com.orastays.property.propertyadd.model.PropertyVsGuestAccessModel;
import com.orastays.property.propertyadd.model.PropertyVsNearbyModel;
import com.orastays.property.propertyadd.model.PropertyVsSpaceRuleModel;
import com.orastays.property.propertyadd.model.PropertyVsSpecialExperienceModel;
import com.orastays.property.propertyadd.model.RoomModel;
import com.orastays.property.propertyadd.model.UserModel;

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
		UserModel userModel = getUserDetails(propertyModel.getUserToken());
	
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		
		//if(Objects.nonNull(userModel)) {
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
					} else {
						if(propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_Y)){
							//Logic For Property vs PriceDrop
						}
					} 
				}
				
				//Validate Property Type
				if(Objects.isNull(propertyModel.getPropertyTypeModel())) {
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
				if(Objects.isNull(propertyModel.getPropertyVsDescriptionModels())) {
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
				if(Objects.isNull(propertyModel.getPropertyVsGuestAccessModels())) {
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
				if(Objects.isNull(propertyModel.getPropertyVsNearbyModels())) {
					exceptions.put(messageUtil.getBundle("property.nearby.null.code"), new Exception(messageUtil.getBundle("property.nearby.null.message")));
				} else {
					// Address Validation
					for(PropertyVsNearbyModel propertyVsNearbyModel:propertyModel.getPropertyVsNearbyModels()){
						if(StringUtils.isBlank(propertyVsNearbyModel.getAddress())){
							exceptions.put(messageUtil.getBundle("property.address.null.code"), new Exception(messageUtil.getBundle("property.address.null.message")));
						}
					}
				}
				
				//PropertyVs PGCS 
				if(Objects.isNull(propertyModel.getPgCategorySexModel())){
					exceptions.put(messageUtil.getBundle("property.pgcs.null.code"), new Exception(messageUtil.getBundle("property.pgcs.null.message")));
				} else {
					if(StringUtils.isEmpty(propertyModel.getPgCategorySexModel().getPgcsId())){
						exceptions.put(messageUtil.getBundle("property.pgcs.null.code"), new Exception(messageUtil.getBundle("property.pgcs.null.message")));
					} else {
						if(!Util.isNumeric(propertyModel.getPgCategorySexModel().getPgcsId())){
							exceptions.put(messageUtil.getBundle("property.pgcs.numeric.code"), new Exception(messageUtil.getBundle("property.pgcs.numeric.message")));
						} else {
							if(Objects.isNull(pgCategorySexDAO.find(Long.valueOf(propertyModel.getPgCategorySexModel().getPgcsId())))){
								exceptions.put(messageUtil.getBundle("property.pgcs.invalid.code"), new Exception(messageUtil.getBundle("property.pgcs.invalid.message")));
							}
						}
					}
				}
				
				//Property Vs Space Rule
				if(Objects.isNull(propertyModel.getPropertyVsSpaceRuleModels())) {
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
						if(Objects.isNull(propertyVsSpaceRuleModel.getSpaceRuleModel())){
							exceptions.put(messageUtil.getBundle("space.rule.null.code"), new Exception(messageUtil.getBundle("space.rule.null.message")));
						} else {
	
							if(StringUtils.isBlank(propertyVsSpaceRuleModel.getSpaceRuleModel().getSpruleId())) {
								exceptions.put(messageUtil.getBundle("space.rule.null.code"), new Exception(messageUtil.getBundle("space.rule.null.message")));
							} else {
							
								if(!Util.isNumeric(propertyVsSpaceRuleModel.getSpaceRuleModel().getSpruleId())) {
									exceptions.put(messageUtil.getBundle("sprule.nonnumeric.code"), new Exception(messageUtil.getBundle("sprule.nonnumeric.message")));
								} else {
									if(Objects.isNull(spaceRuleDAO.find(Long.parseLong(propertyVsSpaceRuleModel.getSpaceRuleModel().getSpruleId())))) {
										exceptions.put(messageUtil.getBundle("sprule.invalid.code"), new Exception(messageUtil.getBundle("sprule.invalid.message")));
									}
								}
							}
							
						}
					}
				}
				
				//Property vs Special Experience
				
				if(Objects.isNull(propertyModel.getPropertyVsSpecialExperienceModels())) {
					exceptions.put(messageUtil.getBundle("special.expe.null.code"), new Exception(messageUtil.getBundle("special.expe.null.message")));
				} else {
					// Answer Validation
					for(PropertyVsSpecialExperienceModel propertyVsExperienceModel:propertyModel.getPropertyVsSpecialExperienceModels()){
						if(Objects.isNull(propertyVsExperienceModel.getSpecialExperienceModel())){
							exceptions.put(messageUtil.getBundle("special.expe.null.code"), new Exception(messageUtil.getBundle("special.expe.null.message")));
						} else {
							
							if(StringUtils.isEmpty(propertyVsExperienceModel.getSpecialExperienceModel().getExperienceId())){
								exceptions.put(messageUtil.getBundle("special.expe.null.code"), new Exception(messageUtil.getBundle("special.expe.null.message")));
							} else {
								if(!Util.isNumeric(propertyVsExperienceModel.getSpecialExperienceModel().getExperienceId())){
									exceptions.put(messageUtil.getBundle("special.expe.invalid.code"), new Exception(messageUtil.getBundle("special.expe.invalid.message")));
								} else {
									if(Objects.isNull(specialExperienceDAO.find(Long.parseLong(propertyVsExperienceModel.getSpecialExperienceModel().getExperienceId())))) {
										exceptions.put(messageUtil.getBundle("special.expe.invalid.code"), new Exception(messageUtil.getBundle("special.expe.invalid.message")));
									}
								}
							}
							
						}
						
					}
				}
				
				//User vs Account
				if(Objects.isNull(propertyModel.getUserVsAccountModel())) {
					exceptions.put(messageUtil.getBundle("property.user.null.code"), new Exception(messageUtil.getBundle("property.user.null.message")));
				} else {
					//propertyModel.getUserVsAccountModel().setUserId(userModel.getUserId());
					if(Util.isEmpty(propertyModel.getUserVsAccountModel().getAccountHolderName())){
						exceptions.put(messageUtil.getBundle("accholder.name.null.code"), new Exception(messageUtil.getBundle("accholder.name.null.message")));
					}
					if(Util.isEmpty(propertyModel.getUserVsAccountModel().getAccountNumber())){
						exceptions.put(messageUtil.getBundle("account.no.null.code"), new Exception(messageUtil.getBundle("account.no.null.message")));
					} 
					if(Util.isEmpty(propertyModel.getUserVsAccountModel().getAccountType())){
						exceptions.put(messageUtil.getBundle("account.type.null.code"), new Exception(messageUtil.getBundle("account.type.null.message")));
					} 
					if(Util.isEmpty(propertyModel.getUserVsAccountModel().getIfscCode())){
						exceptions.put(messageUtil.getBundle("ifsc.code.null.code"), new Exception(messageUtil.getBundle("ifsc.code.null.message")));
					} 
				}
				
				
				//Property Vs Document
				if(Objects.isNull(propertyModel.getPropertyVsDocumentModels())) {
					exceptions.put(messageUtil.getBundle("property.document.null.code"), new Exception(messageUtil.getBundle("property.document.null.message")));
				} else {
					
					for(PropertyVsDocumentModel propertyVsDocumentModel:propertyModel.getPropertyVsDocumentModels()){
						if(Util.isEmpty(propertyVsDocumentModel.getDocumentNumber())){
							exceptions.put(messageUtil.getBundle("property.documentNo.null.code"), new Exception(messageUtil.getBundle("property.documentNo.null.message")));
						}
						
						if(Objects.isNull(propertyVsDocumentModel.getDocumentModel())) {
							exceptions.put(messageUtil.getBundle("document.null.code"), new Exception(messageUtil.getBundle("document.null.message")));
						} else {
							if(Util.isEmpty(propertyVsDocumentModel.getDocumentModel().getDocumentId())){
								exceptions.put(messageUtil.getBundle("document.null.code"), new Exception(messageUtil.getBundle("document.null.message")));
							} else {
								if(!Util.isNumeric(propertyVsDocumentModel.getDocumentModel().getDocumentId())){
									exceptions.put(messageUtil.getBundle("document.id.nonnumeric.code"), new Exception(messageUtil.getBundle("document.id.nonnumeric.message")));
								} else {
									if(Objects.isNull(documentDAO.find(Long.valueOf(propertyVsDocumentModel.getDocumentModel().getDocumentId())))){
										exceptions.put(messageUtil.getBundle("document.id.invalid.code"), new Exception(messageUtil.getBundle("document.id.invalid.message")));
									}
								}
							}
						}
						
						if(StringUtils.isBlank(propertyVsDocumentModel.getFileUrl())){
							exceptions.put(messageUtil.getBundle("property.document.file.null.code"), new Exception(messageUtil.getBundle("property.document.file.null.message")));
						}
					}
				}
				
				
				
				
				////////////////////////////////////////////////////////////////// Room Data Validation //////////////////////////////////////////////////////
				
				if(Objects.nonNull(propertyModel.getRoomModels())){
					
					for(RoomModel roomModel:propertyModel.getRoomModels()){
						
						//Shared Space
						if(StringUtils.isBlank(roomModel.getSharedSpace())){
							exceptions.put(messageUtil.getBundle("room.sharedSpace.null.code"), new Exception(messageUtil.getBundle("room.sharedSpace.null.message")));
						} else {
							
							if(!(roomModel.getSharedSpace().equals(PropertyAddConstant.STR_Y) || roomModel.getSharedSpace().equals(PropertyAddConstant.STR_N))){
								exceptions.put(messageUtil.getBundle("room.sharedSpace.invalid.code"), new Exception(messageUtil.getBundle("room.sharedSpace.invalid.message")));
							} else {
								if(roomModel.getSharedSpace().equals(PropertyAddConstant.STR_Y)){
									//Logic For Shared Space Logic
								}
							} 
						}
						
						// CotAvailable
						if(StringUtils.isBlank(roomModel.getCotAvailable())){
							exceptions.put(messageUtil.getBundle("room.cotavail.null.code"), new Exception(messageUtil.getBundle("room.cotavail.null.message")));
						} else {
							
							if(!(roomModel.getCotAvailable().equals(PropertyAddConstant.STR_Y) || roomModel.getCotAvailable().equals(PropertyAddConstant.STR_N))){
								exceptions.put(messageUtil.getBundle("room.cotavail.invalid.code"), new Exception(messageUtil.getBundle("room.cotavail.invalid.message")));
							} else {
								if(roomModel.getCotAvailable().equals(PropertyAddConstant.STR_Y)){
									//Logic For Cot Available Logic
								}
							} 
						}
						
						//No Of Guest
						if(StringUtils.isBlank(roomModel.getNoOfGuest())){
							exceptions.put(messageUtil.getBundle("room.noofguest.null.code"), new Exception(messageUtil.getBundle("room.noofguest.null.message")));
						} else {
							if(!Util.isNumeric(roomModel.getNoOfGuest())){
								exceptions.put(messageUtil.getBundle("room.noofguest.numeric.code"), new Exception(messageUtil.getBundle("room.noofguest.numeric.message")));
							}
						}
						
						//No of Child
						if(StringUtils.isBlank(roomModel.getNoOfChild())){
							exceptions.put(messageUtil.getBundle("room.noofchild.null.code"), new Exception(messageUtil.getBundle("room.noofchild.null.message")));
						} else {
							if(!Util.isNumeric(roomModel.getNoOfChild())){
								exceptions.put(messageUtil.getBundle("room.noofchild.numeric.code"), new Exception(messageUtil.getBundle("room.noofchild.numeric.message")));
							}
						}
						
						// not of Cot
						if(StringUtils.isBlank(roomModel.getNumOfCot())){
							exceptions.put(messageUtil.getBundle("room.numofCot.null.code"), new Exception(messageUtil.getBundle("room.numofCot.null.message")));
						} else {
							if(!Util.isNumeric(roomModel.getNumOfCot())){
								exceptions.put(messageUtil.getBundle("room.numofCot.numeric.code"), new Exception(messageUtil.getBundle("room.numofCot.numeric.message")));
							}
						}
						
						// Room Current Status
						if(StringUtils.isBlank(roomModel.getRoomCurrentStatus())){
							exceptions.put(messageUtil.getBundle("room.roomcstatus.null.code"), new Exception(messageUtil.getBundle("room.roomcstatus.null.message")));
						} else {
							if(!(roomModel.getRoomCurrentStatus().equals(PropertyAddConstant.STR_Y) || roomModel.getRoomCurrentStatus().equals(PropertyAddConstant.STR_N))){
								exceptions.put(messageUtil.getBundle("room.roomcstatus.invalid.code"), new Exception(messageUtil.getBundle("room.roomcstatus.invalid.message")));
							} else {
								if(roomModel.getRoomCurrentStatus().equals(PropertyAddConstant.STR_Y)){
									//Logic For Room Current Status
								}
							} 
						}
						
						// Accommodation Check
						if(Objects.isNull(roomModel.getAccommodationModel())){
							exceptions.put(messageUtil.getBundle("room.accommodation.null.code"), new Exception(messageUtil.getBundle("room.accommodation.null.message")));
						} else {
							
							if(StringUtils.isEmpty(roomModel.getAccommodationModel().getAccommodationId())){
								exceptions.put(messageUtil.getBundle("room.accommodation.null.code"), new Exception(messageUtil.getBundle("room.accommodation.null.message")));
							} else {
								if(!Util.isNumeric(roomModel.getAccommodationModel().getAccommodationId())){
									exceptions.put(messageUtil.getBundle("room.accommodation.invalid.code"), new Exception(messageUtil.getBundle("room.accommodation.invalid.message")));
								} else {
									if(Objects.isNull(accommodationDAO.find(Long.parseLong(roomModel.getAccommodationModel().getAccommodationId())))) {
										exceptions.put(messageUtil.getBundle("room.accommodation.invalid.code"), new Exception(messageUtil.getBundle("room.accommodation.invalid.message")));
									}
								}
							}
							
						}
						
						// Discount Category Ora Validation
						
						
						//Room Category Validation
						
						// Room Standard Validation
						
						//Room Vs Bed
						
						//Room Vs Amenities
						
						//Room Vs Cancellation
						
						//Room Vs Image
						
						//Room Vs Price
						
						//Room vs host discount
						
						//Room Vs Ora discount
						
						//Room Vs Ora Price Percentage
						
						//Room Vs Specilities
						
						//Room Vs Meal
						
						
						
					}
					
				}
				
			}
		/*} else {
			exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message")));
		}*/
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isDebugEnabled()) {
			logger.debug("validatePropertyAdd -- End");
		}
		
	}
	
}