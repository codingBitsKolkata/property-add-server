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
public class RoomVsBedModel extends CommonModel {

	@JsonProperty("rbId")
	private String rbId;
	
	@JsonProperty("noOfBeds")
	private String noOfBeds;
	
	@JsonProperty("room")
	private RoomModel roomModel;
}
