package com.orastays.propertyadd.service;

import java.util.List;

import com.orastays.propertyadd.exceptions.FormExceptions;
import com.orastays.propertyadd.model.CommonModel;
import com.orastays.propertyadd.model.PropertyModel;
import com.orastays.propertyadd.model.booking.BookingModel;
import com.orastays.propertyadd.model.booking.CancellationModel;

public interface ReportService {

	List<BookingModel> viewPropertyBookingList(PropertyModel propertyModel) throws FormExceptions;
	List<BookingModel> viewUserBookingList(CommonModel commonModel) throws FormExceptions;
	List<CancellationModel> viewPropertyCancellationList(BookingModel bookingModel) throws FormExceptions;
	List<CancellationModel> viewUserCancellationList(BookingModel bookingModel) throws FormExceptions;
	Object requestToiletry(PropertyModel propertyModel) throws FormExceptions;
}