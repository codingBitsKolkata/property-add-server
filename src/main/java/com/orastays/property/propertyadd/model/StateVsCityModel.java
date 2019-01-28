package com.orastays.property.propertyadd.model;

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
public class StateVsCityModel extends CommonModel {

	@JsonProperty("svcId")
	private Long svcId;

	@JsonProperty("cityName")
	private String cityName;
	
	@JsonProperty("countryVsStates")
	private CountryVsStateModel countryVsStateModel;
}
