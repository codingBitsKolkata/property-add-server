package com.orastays.property.propertyadd.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class OfferModel extends CommonModel {

	@JsonProperty("offerId")
	private String offerId;

	@JsonProperty("offerName")
	private String offerName;

	@JsonProperty("percentage")
	private String percentage;

	@JsonProperty("amount")
	private String amount;

	@JsonProperty("startDateRange")
	private String startDateRange;

	@JsonProperty("endDateRange")
	private String endDateRange;

	@JsonProperty("online")
	private String online;

	@JsonProperty("maxAmount")
	private String maxAmount;

	@JsonProperty("roomVsOffers")
	private List<RoomVsOfferModel> roomVsOfferModels;
}
