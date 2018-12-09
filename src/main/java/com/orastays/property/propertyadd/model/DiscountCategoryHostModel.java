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
public class DiscountCategoryHostModel extends CommonModel {

	@JsonProperty("dchId")
	private String dchId;
	
	@JsonProperty("disCatHostname")
	private String disCatHostname;
	
	@JsonProperty("languageId")
	private String languageId;
	
	@JsonProperty("parentId")
	private String parentId;
	
	@JsonProperty("roomVsHostDiscounts")
	private List<RoomVsHostDiscountModel> roomVsHostDiscountModels;
}
