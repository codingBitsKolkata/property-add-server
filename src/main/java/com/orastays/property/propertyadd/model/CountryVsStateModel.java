package com.orastays.property.propertyadd.model;

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
public class CountryVsStateModel extends CommonModel {

	@JsonProperty("cvsId")
	private String cvsId;

	@JsonProperty("stateName")
	private String stateName;
	
	@JsonProperty("countrys")
	private CountryModel countryModel;
	
	
	/*@JsonProperty("stateVsCitys")
	private List<StateVsCityModel> stateVsCityModels;*/
}
