package com.orastays.property.propertyadd.model;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class RoomModel extends CommonModel {

	@JsonProperty("room")
	private String roomId;
	
	@JsonProperty("sharedSpace")
	private String sharedSpace;
	
	@JsonProperty("cotAvailable")
	private String cotAvailable;
	
	@JsonProperty("noOfGuest")
	private String noOfGuest;
	
	@JsonProperty("noOfChild")
	private String noOfChild;
	
	@JsonProperty("numOfCot")
	private String numOfCot;
	
	@JsonProperty("roomCurrentStatus")
	private String roomCurrentStatus;
	
	@JsonProperty("roomPricePerNight")
	private String roomPricePerNight;
	
	@JsonProperty("roomPricePerMonth")
	private String roomPricePerMonth;
	
	@JsonProperty("sharedBedPricePerNight")
	private String sharedBedPricePerNight;
	
	@JsonProperty("sharedBedPricePerMonth")
	private String sharedBedPricePerMonth;
	
	@JsonProperty("cotPrice")
	private String cotPrice;
	
	@JsonProperty("sharedBedPrice")
	private String sharedBedPrice;
	
	@JsonProperty("commission")
	private String commission;
	
	@JsonProperty("oraPercentage")
	private String oraPercentage;
	
	@JsonProperty("hostDiscountWeekly")
	private String hostDiscountWeekly;
	
	@JsonProperty("hostDiscountMonthly")
	private String hostDiscountMonthly;
	
	@JsonProperty("property")
	private PropertyModel propertyModel;
	
	@JsonProperty("accommodation")
	private AccommodationModel accommodationModel;
	
	@JsonProperty("roomCategory")
	private RoomCategoryModel roomCategoryModel;
	
	@JsonProperty("roomStandard")
	private RoomStandardModel roomStandardModel;
	
	@JsonProperty("roomVsBed")
	private RoomVsBedModel roomVsBedModel;
	
	@JsonProperty("roomVsAmenities")
	private List<RoomVsAmenitiesModel> roomVsAmenitiesModels;
	
	@JsonProperty("roomVsCancellation")
	private List<RoomVsCancellationModel> roomVsCancellationModels;
	
	@JsonProperty("roomVsImage")
	private List<RoomVsImageModel> roomVsImageModels;
	
	/*@JsonProperty("roomVsPrice")
	private List<RoomVsPriceModel> roomVsPriceModels;*/
	
	/*@JsonProperty("roomVsHostDiscount")
	private List<RoomVsHostDiscountModel> roomVsHostDiscountModels;*/
	
	@JsonProperty("roomVsOraDiscount")
	private List<RoomVsOraDiscountModel> roomVsOraDiscountModels;
	
	/*@JsonProperty("roomVsOrapricePerc")
	private List<RoomVsOrapricePercModel> roomVsOrapricePercModels;*/
	
	@JsonProperty("roomVsSpecialities")
	private List<RoomVsSpecialitiesModel> roomVsSpecialitiesModels;
	
	@JsonProperty("roomVsMeal")
	private List<RoomVsMealModel> roomVsMealModels;

}
