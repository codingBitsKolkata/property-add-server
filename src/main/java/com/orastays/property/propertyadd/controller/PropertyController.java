package com.orastays.property.propertyadd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orastays.property.propertyadd.helper.AuthConstant;
import com.orastays.property.propertyadd.model.CommonModel;
import com.orastays.property.propertyadd.model.PropertyTypeModel;
import com.orastays.property.propertyadd.model.ResponseModel;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@Api(value = "property", description = "Rest API for Property Type", tags = "Property Type API")
public class PropertyController extends BaseController{
	
	private static final Logger logger = LogManager.getLogger(PropertyController.class);

	
	@RequestMapping(value = "/property-type", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Property Type Listing", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!") })
	public ResponseEntity<ResponseModel> fetchPropertyTypeList(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyTypeList -- START");
		}

		ResponseModel responseModel = new ResponseModel();
		
		try {
		
			List<PropertyTypeModel> propertyTypeModels = propertyService.fetchAllPropertyTypeByLanguage(commonModel.getLanguageId());
			responseModel.setResponseBody(propertyTypeModels);
			responseModel.setResponseCode(messageUtil.getBundle(AuthConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(AuthConstant.COMMON_SUCCESS_MESSAGE));

		} catch (Exception e) {
			e.printStackTrace();
			responseModel.setResponseCode(messageUtil.getBundle(AuthConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(AuthConstant.COMMON_ERROR_MESSAGE));
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyTypeList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(AuthConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
}
