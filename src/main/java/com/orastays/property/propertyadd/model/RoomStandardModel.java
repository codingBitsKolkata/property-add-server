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
public class RoomStandardModel extends CommonModel {

	@JsonProperty("roomStandardId")
	private String roomStandardId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("languageId")
	private String languageId;
	
	@JsonProperty("parentId")
	private String parentId;
	
/*	@JsonProperty("flagCount")
	private String flagCount;
	
	@JsonProperty("flagInd")
	private String flagInd;*/
	
	@JsonProperty("rooms")
	private List<RoomModel> roomModels;
}
