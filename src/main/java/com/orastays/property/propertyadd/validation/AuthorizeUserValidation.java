package com.orastays.property.propertyadd.validation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orastays.property.propertyadd.dao.AccommodationDAO;
import com.orastays.property.propertyadd.dao.AmenitiesDAO;
import com.orastays.property.propertyadd.dao.CancellationSlabDAO;
import com.orastays.property.propertyadd.dao.DiscountCategoryHostDAO;
import com.orastays.property.propertyadd.dao.DiscountCategoryOraDAO;
import com.orastays.property.propertyadd.dao.DocumentDAO;
import com.orastays.property.propertyadd.dao.MealCategoryDAO;
import com.orastays.property.propertyadd.dao.MealDaysDAO;
import com.orastays.property.propertyadd.dao.MealPriceCategoryDAO;
import com.orastays.property.propertyadd.dao.MealTypeDAO;
import com.orastays.property.propertyadd.dao.PGCategorySexDAO;
import com.orastays.property.propertyadd.dao.PriceTypeDAO;
import com.orastays.property.propertyadd.dao.PropertyDAO;
import com.orastays.property.propertyadd.dao.PropertyTypeDAO;
import com.orastays.property.propertyadd.dao.PropertyVsDescriptionDAO;
import com.orastays.property.propertyadd.dao.PropertyVsDocumentDAO;
import com.orastays.property.propertyadd.dao.PropertyVsGuestAccessDAO;
import com.orastays.property.propertyadd.dao.PropertyVsImageDAO;
import com.orastays.property.propertyadd.dao.PropertyVsNearbyDAO;
import com.orastays.property.propertyadd.dao.PropertyVsSpaceRuleDAO;
import com.orastays.property.propertyadd.dao.PropertyVsSpecialExperienceDAO;
import com.orastays.property.propertyadd.dao.RoomCategoryDAO;
import com.orastays.property.propertyadd.dao.RoomStandardDAO;
import com.orastays.property.propertyadd.dao.RoomVsAmenitiesDAO;
import com.orastays.property.propertyadd.dao.RoomVsBedDAO;
import com.orastays.property.propertyadd.dao.RoomVsCancellationDAO;
import com.orastays.property.propertyadd.dao.RoomVsHostDiscountDAO;
import com.orastays.property.propertyadd.dao.RoomVsImageDAO;
import com.orastays.property.propertyadd.dao.RoomVsMealDAO;
import com.orastays.property.propertyadd.dao.RoomVsOraDiscountDAO;
import com.orastays.property.propertyadd.dao.RoomVsOraPricePercentageDAO;
import com.orastays.property.propertyadd.dao.RoomVsPriceDAO;
import com.orastays.property.propertyadd.dao.RoomVsSpecialitiesDAO;
import com.orastays.property.propertyadd.dao.SpaceRuleDAO;
import com.orastays.property.propertyadd.dao.SpecialExperienceDAO;
import com.orastays.property.propertyadd.dao.SpecialtiesDAO;
import com.orastays.property.propertyadd.dao.UserVsAccountDAO;
import com.orastays.property.propertyadd.exceptions.FormExceptions;
import com.orastays.property.propertyadd.helper.MessageUtil;
import com.orastays.property.propertyadd.model.BookingModel;
import com.orastays.property.propertyadd.model.CommonModel;
import com.orastays.property.propertyadd.model.ResponseModel;
import com.orastays.property.propertyadd.model.UserModel;

@Component
public class AuthorizeUserValidation {

	private static final Logger logger = LogManager.getLogger(AuthorizeUserValidation.class);
	
	@Value("${entitymanager.packagesToScan}")
	protected String entitymanagerPackagesToScan;
	
	@Autowired
	protected MessageUtil messageUtil;
	
	@Autowired
	protected RestTemplate restTemplate;
	
	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	protected PropertyTypeDAO propertyTypeDAO;
	
	@Autowired
	protected SpaceRuleDAO spaceRuleDAO;
	
	@Autowired
	protected SpecialExperienceDAO specialExperienceDAO;
	
	@Autowired
	protected PGCategorySexDAO pgCategorySexDAO;
	
	@Autowired
	protected DocumentDAO documentDAO;
	
	@Autowired
	protected AccommodationDAO accommodationDAO;
	
	@Autowired
	protected DiscountCategoryOraDAO discountCategoryOraDAO;
	
	@Autowired
	protected RoomCategoryDAO roomCategoryDAO;
	
	@Autowired
	protected RoomStandardDAO roomStandardDAO;
	
	@Autowired
	protected RoomVsBedDAO roomVsBedDAO;
	
	@Autowired
	protected RoomVsAmenitiesDAO roomVsAmenitiesDAO;
	
	@Autowired
	protected RoomVsCancellationDAO roomVsCancellationDAO;
	
	@Autowired
	protected CancellationSlabDAO cancellationSlabDAO;
	
	@Autowired
	protected PriceTypeDAO priceTypeDAO;
	
	@Autowired
	protected DiscountCategoryHostDAO discountCategoryHostDAO;	
	
	@Autowired
	protected SpecialtiesDAO specialtiesDAO;
	
	@Autowired
	protected MealCategoryDAO mealCategoryDAO;
	
	@Autowired
	protected MealDaysDAO mealDaysDAO;
	
	@Autowired
	protected MealPriceCategoryDAO mealPriceCategoryDAO;
	
	@Autowired
	protected MealTypeDAO mealTypeDAO;
	
	@Autowired
	protected AmenitiesDAO amenitiesDAO;
	
	@Autowired
	protected PropertyDAO propertyDAO;
	
	@Autowired
	protected PropertyVsDescriptionDAO propertyVsDescriptionDAO;
	
	@Autowired
	protected PropertyVsGuestAccessDAO propertyVsGuestAccessDAO;
	
	@Autowired
	protected PropertyVsNearbyDAO propertyVsNearbyDAO;
	
	@Autowired
	protected PropertyVsSpaceRuleDAO propertyVsSpaceRuleDAO;
	
	@Autowired
	protected PropertyVsSpecialExperienceDAO propertyVsSpecialExperienceDAO;
	
	@Autowired
	protected PropertyVsDocumentDAO propertyVsDocumentDAO;
	
	@Autowired
	protected RoomVsPriceDAO roomVsPriceDAO;
	
	@Autowired
	protected RoomVsHostDiscountDAO roomVsHostDiscountDAO;
	
	@Autowired
	protected RoomVsSpecialitiesDAO roomVsSpecialitiesDAO;
	
	@Autowired
	protected RoomVsMealDAO roomVsMealDAO;
	
	@Autowired
	protected UserVsAccountDAO userVsAccountDAO;
	
	@Autowired
	protected PropertyVsImageDAO propertyVsImageDAO;
	
	@Autowired
	protected RoomVsImageDAO roomVsImageDAO;
	
	@Autowired
	protected RoomVsOraDiscountDAO roomVsOraDiscountDAO;
	
	@Autowired
	protected RoomVsOraPricePercentageDAO roomVsOraPricePercentageDAO;
	
	public UserModel getUserDetails(String userToken) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("getUserDetails -- START");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		UserModel userModel = null;
		try {
			
			// Validate User Token
			if(StringUtils.isBlank(userToken)) {
				exceptions.put(messageUtil.getBundle("user.token.null.code"), new Exception(messageUtil.getBundle("user.token.null.message")));
			} else {
				ResponseModel responseModel = restTemplate.getForObject(messageUtil.getBundle("auth.server.url") +"check-token?userToken="+userToken, ResponseModel.class);
				Gson gson = new Gson();
				String jsonString = gson.toJson(responseModel.getResponseBody());
				userModel = gson.fromJson(jsonString, UserModel.class);
				if(Objects.isNull(userModel)) {
					exceptions.put(messageUtil.getBundle("session.expires.code"), new Exception(messageUtil.getBundle("session.expires.message")));
				}
				
				if (logger.isInfoEnabled()) {
					logger.info("userModel ==>> "+userModel);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// Disabled the below line to pass the Token Validation
			exceptions.put(messageUtil.getBundle("session.expires.code"), new Exception(messageUtil.getBundle("session.expires.message")));
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isInfoEnabled()) {
			logger.info("getUserDetails -- END");
		}
		
		return userModel;
	}
	
	public CommonModel validateLanguage(String languageId) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("validateLanguage -- START");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		CommonModel commonModel = null;
		try {
			
			if(StringUtils.isBlank(languageId)) {
				exceptions.put(messageUtil.getBundle("language.id.null.code"), new Exception(messageUtil.getBundle("language.id.null.message")));
			} else {
				ResponseModel responseModel = restTemplate.getForObject(messageUtil.getBundle("auth.server.url") +"check-language?languageId="+languageId, ResponseModel.class);
				Gson gson = new Gson();
				String jsonString = gson.toJson(responseModel.getResponseBody());
				commonModel = gson.fromJson(jsonString, CommonModel.class);
				if(Objects.isNull(commonModel)) {
					exceptions.put(messageUtil.getBundle("language.id.invalid.code"), new Exception(messageUtil.getBundle("language.id.invalid.message")));
				}
				
				if (logger.isInfoEnabled()) {
					logger.info("commonModel ==>> "+commonModel);
				}
			}
			
		} catch (Exception e) {
			// Disabled the below line to pass the Language Validation
			exceptions.put(messageUtil.getBundle("language.id.invalid.code"), new Exception(messageUtil.getBundle("language.id.invalid.message")));
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isInfoEnabled()) {
			logger.info("validateLanguage -- END");
		}
		
		return commonModel;
	}
	
	public List<BookingModel> getPropertyBookingList(String propertyId) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("getPropertyBookingList -- START");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<BookingModel> bookingModels = null;
		BookingModel bookingModel = new BookingModel();
		bookingModel.setPropertyId(propertyId);
		try {
			String url = messageUtil.getBundle("booking.server.url") +"get-property-bookings";
			ResponseModel responseModel = restTemplate.postForObject(url, bookingModel,ResponseModel.class);
			
			Gson gson = new Gson();
			String jsonString = gson.toJson(responseModel.getResponseBody());
			bookingModels = gson.fromJson(jsonString,new TypeToken<List<BookingModel>>(){}.getType());
			
			if (logger.isInfoEnabled()) {
				logger.info("bookingModels ==>> "+bookingModels);
			}
		} catch (Exception e) {
			// Disabled the below line to pass the Token Validation
			e.printStackTrace();
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isInfoEnabled()) {
			logger.info("getPropertyBookingList -- END");
		}
		
		return bookingModels;
	}
	
	public List<BookingModel> getUserBookingList(String userId) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("getUserBookingList -- START");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<BookingModel> bookingModels = null;
		BookingModel bookingModel = new BookingModel();
		bookingModel.setUserId(userId);
		try {
			String url = messageUtil.getBundle("booking.server.url") +"get-user-bookings";
			ResponseModel responseModel = restTemplate.postForObject(url, bookingModel,ResponseModel.class);
			
			Gson gson = new Gson();
			String jsonString = gson.toJson(responseModel.getResponseBody());
			bookingModels = gson.fromJson(jsonString,new TypeToken<List<BookingModel>>(){}.getType());
			
			if (logger.isInfoEnabled()) {
				logger.info("bookingModels ==>> "+bookingModels);
			}
		} catch (Exception e) {
			// Disabled the below line to pass the Token Validation
			e.printStackTrace();
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isInfoEnabled()) {
			logger.info("getUserBookingList -- END");
		}
		
		return bookingModels;
	}
	
}