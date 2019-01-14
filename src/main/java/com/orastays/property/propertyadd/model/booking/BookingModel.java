package com.orastays.property.propertyadd.model.booking;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

	@JsonProperty("conveniences")
	private ConvenienceModel convenienceModel;

	@JsonProperty("bookingInfos")
	private BookingInfoModel bookingInfoModel;

	@JsonProperty("bookingApproval")
	private String bookingApproval;

	@JsonProperty("convenienceAmtWgst")
	private String convenienceAmtWgst;

	@JsonProperty("bookingVsRooms")
	private List<BookingVsRoomModel> bookingVsRoomModels;

	@JsonProperty("bookingVsPayments")
	private List<BookingVsPaymentModel> bookingVsPaymentModels;

	@JsonProperty("formOfPayment")
	private FormOfPayment formOfPayment;

	@JsonProperty("userInfo")
	private UserInfo userInfo;

	@JsonProperty("cancellations")
	private CancellationModel cancellationModel;

	@JsonProperty("oraAmount")
	private String oraAmount;

	@JsonProperty("oraDiscount")
	private String oraDiscount;

	@JsonProperty("hostDiscount")
	private String hostDiscount;

	@JsonProperty("offerAmount")
	private String offerAmount;

	@JsonProperty("gstPercentage")
	private String gstPercentage;

	@JsonProperty("gstAmount")
	private String gstAmount;

	@JsonProperty("priceDropAmount")
	private String priceDropAmount;

	@JsonProperty("priceDropPercentage")
	private String priceDropPercentage;

	@JsonProperty("totalAmount")
	private String totalAmount;
	
	@JsonProperty("propertyName")
	private String propertyName;
	
	@JsonProperty("propertyAddress")
	private String propertyAddress;

}
