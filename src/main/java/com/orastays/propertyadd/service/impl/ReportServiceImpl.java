package com.orastays.propertyadd.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.orastays.propertyadd.entity.PropertyEntity;
import com.orastays.propertyadd.exceptions.FormExceptions;
import com.orastays.propertyadd.model.CommonModel;
import com.orastays.propertyadd.model.PropertyModel;
import com.orastays.propertyadd.model.ResponseModel;
import com.orastays.propertyadd.model.auth.UserModel;
import com.orastays.propertyadd.model.booking.BookingModel;
import com.orastays.propertyadd.model.booking.CancellationModel;
import com.orastays.propertyadd.service.ReportService;

@Service
@Transactional
public class ReportServiceImpl extends BaseServiceImpl implements ReportService {

	private static final Logger logger = LogManager.getLogger(ReportServiceImpl.class);
	

	@Override
	public List<BookingModel> viewPropertyBookingList(PropertyModel propertyModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyBookingList -- START");
		}
		
		
		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyBookingList -- END");
		}
		
		return  reportValidation.validatePropertyBookingList(propertyModel);
	}

	@Override
	public List<BookingModel> viewUserBookingList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("viewUserBookingList -- START");
		}
		
		
		
		if (logger.isInfoEnabled()) {
			logger.info("viewUserBookingList -- END");
		}
		
		return reportValidation.validateUserBookingList(commonModel);
	}

	@Override
	public List<CancellationModel> viewPropertyCancellationList(BookingModel bookingModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyCancellationList -- START");
		}
		

		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyCancellationList -- END");
		}
		
		return reportValidation.validatePropertyCancellationList(bookingModel);
	}

	@Override
	public List<CancellationModel> viewUserCancellationList(BookingModel bookingModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("viewUserCancellationList -- START");
		}
		

		if (logger.isInfoEnabled()) {
			logger.info("viewUserCancellationList -- END");
		}
		return reportValidation.validateUserCancellationList(bookingModel);
	}

	@Override
	public Object requestToiletry(PropertyModel propertyModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("requestToiletry -- START");
		}
		
		String result = messageUtil.getBundle("mail.send.success");
		try {
			List<Object> objects = reportValidation.requestToiletry(propertyModel);
			PropertyEntity propertyEntity = (PropertyEntity) objects.get(0);
			UserModel userModel = (UserModel) objects.get(1);
			String body = "Hi Admin, "+userModel.getName()+" has requested for more toiletry kit";
			String subject = messageUtil.getBundle("toiletry.subject") + propertyEntity.getOraname();
			ResponseModel response = mailHelper.sendMail(messageUtil.getBundle("admin.email"), subject, body);
		} catch (HttpClientErrorException e) {
			result = messageUtil.getBundle("mail.send.failed");
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("requestToiletry -- START");
		}
		
		return result;
	}

}