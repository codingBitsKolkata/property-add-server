package com.orastays.property.propertyadd.controller;

import java.util.List;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orastays.property.propertyadd.exceptions.FormExceptions;
import com.orastays.property.propertyadd.helper.PropertyAddConstant;
import com.orastays.property.propertyadd.helper.Util;
import com.orastays.property.propertyadd.model.AccommodationModel;
import com.orastays.property.propertyadd.model.AmenitiesModel;
import com.orastays.property.propertyadd.model.AmenitiesTypeModel;
import com.orastays.property.propertyadd.model.CancellationSlabModel;
import com.orastays.property.propertyadd.model.CommonModel;
import com.orastays.property.propertyadd.model.PGCategorySexModel;
import com.orastays.property.propertyadd.model.PriceTypeModel;
import com.orastays.property.propertyadd.model.PropertyModel;
import com.orastays.property.propertyadd.model.PropertyTypeModel;
import com.orastays.property.propertyadd.model.ResponseModel;
import com.orastays.property.propertyadd.model.RoomCategoryModel;
import com.orastays.property.propertyadd.model.SpaceRuleModel;
import com.orastays.property.propertyadd.model.SpecialExperienceModel;
import com.orastays.property.propertyadd.model.SpecialtiesModel;
import com.orastays.property.propertyadd.model.StayTypeModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@Api(value = "property", tags = "Property Add Form API")
public class PropertyController extends BaseController{
	
	private static final Logger logger = LogManager.getLogger(PropertyController.class);
	
	@PostMapping(value = "/fetch-property-types", produces = "application/json")
	@ApiOperation(value = "Property Type Listing", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> fetchPropertyTypes(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyTypes -- START");
		}

		ResponseModel responseModel = new ResponseModel();
		Util.printLog(responseModel, PropertyAddConstant.INCOMING, "Fetch Property Types", request);
		try {
		
			List<PropertyTypeModel> propertyTypeModels = propertyService.fetchPropertyTypes(commonModel);
			responseModel.setResponseBody(propertyTypeModels);
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));
			
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Fetch Property Types -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Fetch Property Types -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "Fetch Property Types", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyTypes -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/fetch-stay-types", produces = "application/json")
	@ApiOperation(value = "Stay Type Listing", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> fetchStayTypeList(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchStayTypeList -- START");
		}

		ResponseModel responseModel = new ResponseModel();
		Util.printLog(responseModel, PropertyAddConstant.INCOMING, "Stay Type Listing", request);
		try {
			List<StayTypeModel> stayTypeModels = propertyService.fetchStayTypeList(commonModel);
			responseModel.setResponseBody(stayTypeModels);
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));

		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Stay Type Listing -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Stay Type Listing -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "Stay Type Listing", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchStayTypeList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/fetch-accommodation", produces = "application/json")
	@ApiOperation(value = "Accommodation Listing", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> fetchAccommodationList(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchAccommodationList -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(responseModel, PropertyAddConstant.INCOMING, "Accommodation Listing", request);
		try {
			List<AccommodationModel> accommodationModels = propertyService.fetchAccommodationByLanguage(commonModel);
			responseModel.setResponseBody(accommodationModels);
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));

		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Accommodation Listing -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Accommodation Listing -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "Accommodation Listing", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAccommodationList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/fetch-pg-cat-sex", produces = "application/json")
	@ApiOperation(value = "PG Category Sex Listing", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> fetchPgCategorySexList(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchPgCategorySexList -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(responseModel, PropertyAddConstant.INCOMING, "PG Category Sex Listing", request);
		try {
			List<PGCategorySexModel> pgCategorySexModels = propertyService.fetchPgCategorySexListByLanguage(commonModel);
			responseModel.setResponseBody(pgCategorySexModels);
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));

		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in PG Category Sex Listing -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in PG Category Sex Listing -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "PG Category Sex Listing", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPgCategorySexList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/fetch-amenities-type", produces = "application/json")
	@ApiOperation(value = "Amenities Type Listing", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue...") })
	public ResponseEntity<ResponseModel> fetchAmenitiesTypeList(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesTypeList -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(responseModel, PropertyAddConstant.INCOMING, "Amenities Type Listing", request);
		try {
			List<AmenitiesTypeModel> amenitiesTypeModels = propertyService.fetchAmenitiesTypeList();
			responseModel.setResponseBody(amenitiesTypeModels);
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));

		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Amenities Type Listing -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Amenities Type Listing -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "Amenities Type Listing", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesTypeList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/fetch-amenities", produces = "application/json")
	@ApiOperation(value = "Amenities Listing", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> fetchAmenitiesList(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesList -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(responseModel, PropertyAddConstant.INCOMING, "Amenities Listing", request);
		try {
			List<AmenitiesModel> amenitiesModels = propertyService.fetchAmenitiesList(commonModel);
			responseModel.setResponseBody(amenitiesModels);
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));

		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Amenities Listing -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Amenities Listing -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "Amenities Listing", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/fetch-special-experience", produces = "application/json")
	@ApiOperation(value = "Special Experience Listing", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> fetchSpecialExperienceList(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchSpecialExperienceList -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(responseModel, PropertyAddConstant.INCOMING, "Special Experience Listing", request);
		try {
			List<SpecialExperienceModel> specialExperienceModels = propertyService.fetchSpecialExperienceList(commonModel);
			responseModel.setResponseBody(specialExperienceModels);
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));

		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Special Experience Listing -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Special Experience Listing -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "Special Experience Listing", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpecialExperienceList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/fetch-space-rule", produces = "application/json")
	@ApiOperation(value = "Space Rule Listing", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> fetchSpaceRuleList(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchSpaceRuleList -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(responseModel, PropertyAddConstant.INCOMING, "Space Rule Listing", request);
		try {
			List<SpaceRuleModel> spaceRuleModels = propertyService.fetchSpaceRuleList(commonModel);
			responseModel.setResponseBody(spaceRuleModels);
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));

		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Space Rule Listing -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Space Rule Listing -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "Space Rule Listing", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpaceRuleList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/fetch-specialities", produces = "application/json")
	@ApiOperation(value = "Specialties Listing", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> fetchSpecialtiesList(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchSpecialtiesList -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(responseModel, PropertyAddConstant.INCOMING, "Specialties Listing", request);
		try {
			List<SpecialtiesModel> specialtiesModels = propertyService.fetchSpecialtiesList(commonModel);
			responseModel.setResponseBody(specialtiesModels);
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));

		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Specialties Listing -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Specialties Listing -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "Specialties Listing", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpecialtiesList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/fetch-room-category", produces = "application/json")
	@ApiOperation(value = "Room Category Listing", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> fetchRoomCategoryList(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchRoomCategoryList -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(responseModel, PropertyAddConstant.INCOMING, "Room Category Listing", request);
		try {
			List<RoomCategoryModel> roomCategoryModels = propertyService.fetchRoomCategoryList(commonModel);
			responseModel.setResponseBody(roomCategoryModels);
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));

		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Room Category Listing -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Room Category Listing -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "Room Category Listing", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchRoomCategoryList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/fetch-price-type", produces = "application/json")
	@ApiOperation(value = "Price type Listing", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> fetchPriceTypeList(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchPriceTypeList -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(responseModel, PropertyAddConstant.INCOMING, "Price type Listing", request);
		try {
			List<PriceTypeModel> priceTypeModels = propertyService.fetchPriceTypeList(commonModel);
			responseModel.setResponseBody(priceTypeModels);
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));

		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Price type Listing -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Price type Listing -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "Price type Listing", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPriceTypeList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/fetch-cancellation-slab", produces = "application/json")
	@ApiOperation(value = "Cancellation Slab Listing", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue...") })
	public ResponseEntity<ResponseModel> fetchCancellationSlabList(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchCancellationSlabList -- START");
		}
		
		ResponseModel responseModel = new ResponseModel();
		Util.printLog(responseModel, PropertyAddConstant.INCOMING, "FCancellation Slab Listing", request);
		try {
			List<CancellationSlabModel> cancellationSlabModels = propertyService.fetchCancellationSlabList();
			responseModel.setResponseBody(cancellationSlabModels);
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));

		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Cancellation Slab Listing -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Cancellation Slab Listing -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "Cancellation Slab Listing", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchCancellationSlabList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping(value = "/add-property", produces = "application/json")
	@ApiOperation(value = "Add Property", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> addProperty(@RequestBody PropertyModel propertyModel) {

		if (logger.isInfoEnabled()) {
			logger.info("addProperty -- START");
		}

		ResponseModel responseModel = new ResponseModel();
		Util.printLog(propertyModel, PropertyAddConstant.INCOMING, "Add Property", request);
		try {
			propertyService.saveProperty(propertyModel);
			responseModel.setResponseBody(messageUtil.getBundle("property.add.success"));
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));
			
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Add Property -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Add Property -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "Add Property", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("addProperty -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/list-property", produces = "application/json")
	@ApiOperation(value = "List Property", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue...")
			})
	public ResponseEntity<ResponseModel> listProperty(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("listProperty -- START");
		}

		ResponseModel responseModel = new ResponseModel();
		Util.printLog(commonModel, PropertyAddConstant.INCOMING, "List Property", request);
		try {
			List<PropertyModel> propertyModels = propertyService.fetchActivePropertyList(commonModel);
			responseModel.setResponseBody(propertyModels);
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));
			
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in List Property -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in List Property -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "List Property", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("listProperty -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/fetch-property-by-id", produces = "application/json")
	@ApiOperation(value = "Fetch Property By Id", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue...")
			})
	public ResponseEntity<ResponseModel> fetchPropertyById(@RequestBody PropertyModel propertyModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyById -- START");
		}

		ResponseModel responseModel = new ResponseModel();
		Util.printLog(propertyModel, PropertyAddConstant.INCOMING, "Fetch Property By Id", request);
		try {
			responseModel.setResponseBody(propertyService.fetchPropertyById(propertyModel));
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));
			
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Fetch Property by Id -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Fetch Property by Id -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "List Property", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyById -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
}