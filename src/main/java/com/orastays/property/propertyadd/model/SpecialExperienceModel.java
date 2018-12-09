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
public class SpecialExperienceModel extends CommonModel {

	@JsonProperty("specialitiesName")
	private String experienceId;
	
	@JsonProperty("languageId")
	private String languageId;
	
	@JsonProperty("parentId")
	private String parentId;
	
	@JsonProperty("specialitiesName")
	private String experienceName;
}
