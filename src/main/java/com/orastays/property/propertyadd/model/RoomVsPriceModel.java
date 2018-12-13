package com.orastays.property.propertyadd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class RoomVsPriceModel extends CommonModel {

	@JsonProperty("roomVsPriceId")
	private String roomVsPriceId;
	
	@JsonProperty("value")
	private String value;
	
	@JsonProperty("priceType")
	private PriceTypeModel priceTypeModel;
	
	@JsonProperty("room")
	private RoomModel roomModel;
}
