package com.orastays.propertyadd.controller;

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

import com.orastays.propertyadd.exceptions.FormExceptions;
import com.orastays.propertyadd.helper.PropertyAddConstant;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.CommonModel;
import com.orastays.propertyadd.model.PropertyModel;
import com.orastays.propertyadd.model.ResponseModel;
import com.orastays.propertyadd.model.booking.BookingModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@Api(value = "report", tags = "Report API")
public class ReportController extends BaseController {

	private static final Logger logger = LogManager.getLogger(ReportController.class);
	
	@PostMapping(value = "/get-property-bookings", produces = "application/json")
	@ApiOperation(value = "Property Booking List For Host", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> viewPropertyBookingList(@RequestBody PropertyModel propertyModel) {

		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyBookingList -- START");
		}

		ResponseModel responseModel = new ResponseModel();
		Util.printLog(propertyModel, PropertyAddConstant.INCOMING, "View Property Booking List", request);
		try {
			responseModel.setResponseBody(reportService.viewPropertyBookingList(propertyModel));
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));
			
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in View Property Booking List -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Property Booking List -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "View Property Booking List", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyBookingList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/get-user-bookings", produces = "application/json")
	@ApiOperation(value = "User Booking List", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> viewUserBookingList(@RequestBody CommonModel commonModel) {

		if (logger.isInfoEnabled()) {
			logger.info("viewUserBookingList -- START");
		}

		ResponseModel responseModel = new ResponseModel();
		Util.printLog(commonModel, PropertyAddConstant.INCOMING, "View User Booking List", request);
		try {
			responseModel.setResponseBody(reportService.viewUserBookingList(commonModel));
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));
			
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in View User Booking List -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in User Booking List -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "View User Booking List", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("viewUserBookingList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/get-property-cancellations", produces = "application/json")
	@ApiOperation(value = "Property Cancellation List", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> viewPropertyCancellationsList(@RequestBody BookingModel bookingModel) {

		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyCancellationsList -- START");
		}

		ResponseModel responseModel = new ResponseModel();
		Util.printLog(bookingModel, PropertyAddConstant.INCOMING, "View Property Cancellation List", request);
		try {
			responseModel.setResponseBody(reportService.viewPropertyCancellationList(bookingModel));
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));
			
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in View Property Cancellation List -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Property Cancellation List -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "View Property Cancellation List", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyCancellationsList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/get-user-cancellations", produces = "application/json")
	@ApiOperation(value = "User Cancellation List", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> viewUserCancellationList(@RequestBody BookingModel bookingModel) {

		if (logger.isInfoEnabled()) {
			logger.info("viewUserCancellationList -- START");
		}

		ResponseModel responseModel = new ResponseModel();
		Util.printLog(bookingModel, PropertyAddConstant.INCOMING, "View User Cancellation List", request);
		try {
			responseModel.setResponseBody(reportService.viewUserCancellationList(bookingModel));
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));
			
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in View User Cancellation List -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in User Cancellation List -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "View User Cancellation List", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("viewUserCancellationList -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/request-toiletry", produces = "application/json")
	@ApiOperation(value = "Request For Toiletry", response = ResponseModel.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Please Try after Sometime!!!"),
			@ApiResponse(code = 202, message = "Token Required"),
			@ApiResponse(code = 203, message = "Token Expires!!!Please login to continue..."),
			@ApiResponse(code = 204, message = "Language Id Required"),
			@ApiResponse(code = 205, message = "Invalid Language ID") })
	public ResponseEntity<ResponseModel> requestToiletry(@RequestBody PropertyModel propertyModel) {

		if (logger.isInfoEnabled()) {
			logger.info("requestToiletry -- START");
		}

		ResponseModel responseModel = new ResponseModel();
		Util.printLog(propertyModel, PropertyAddConstant.INCOMING, "Request For Toiletry", request);
		try {
			responseModel.setResponseBody(reportService.requestToiletry(propertyModel));
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_MESSAGE));
			
		} catch (FormExceptions fe) {

			for (Entry<String, Exception> entry : fe.getExceptions().entrySet()) {
				responseModel.setResponseCode(entry.getKey());
				responseModel.setResponseMessage(entry.getValue().getMessage());
				if (logger.isInfoEnabled()) {
					logger.info("FormExceptions in Request For Toiletry -- "+Util.errorToString(fe));
				}
				break;
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in Request For Toiletry -- "+Util.errorToString(e));
			}
			responseModel.setResponseCode(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_CODE));
			responseModel.setResponseMessage(messageUtil.getBundle(PropertyAddConstant.COMMON_ERROR_MESSAGE));
		}
		
		Util.printLog(responseModel, PropertyAddConstant.OUTGOING, "Request For Toiletry", request);
		
		if (logger.isInfoEnabled()) {
			logger.info("requestToiletry -- END");
		}
		
		if (responseModel.getResponseCode().equals(messageUtil.getBundle(PropertyAddConstant.COMMON_SUCCESS_CODE))) {
			return new ResponseEntity<>(responseModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
		}
	}
}
