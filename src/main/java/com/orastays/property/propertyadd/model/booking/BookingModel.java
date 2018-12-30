package com.orastays.property.propertyadd.model.booking;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orastays.property.propertyadd.model.CommonModel;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class BookingModel extends CommonModel {

	@JsonProperty("bookingId")
	private String bookingId;

	@JsonProperty("orabookingId")
	private String orabookingId;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("propertyId")
	private String propertyId;

	@JsonProperty("propertyLoc")
	private String propertyLoc;

	@JsonProperty("checkinDate")
	private String checkinDate;

	@JsonProperty("checkoutDate")
	private String checkoutDate;

	@JsonProperty("numOfDays")
	private String numOfDays;

	@JsonProperty("totalPaybleWithoutGST")
	private String totalPaybleWithoutGST;

	@JsonProperty("totalPaybleWithGST")
	private String totalPaybleWithGST;

	@JsonProperty("grandTotal")
	private String grandTotal;


	@JsonProperty("bookingApproval")
	private String bookingApproval;
	
	@JsonProperty("convenienceAmtWgst")
	private String convenienceAmtWgst;
	
	
	@JsonProperty("cancellations")
	private CancellationModel cancellations;
}



