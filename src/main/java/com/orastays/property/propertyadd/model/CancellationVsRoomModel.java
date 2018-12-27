package com.orastays.property.propertyadd.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class CancellationVsRoomModel extends CommonModel {

	@JsonProperty("cancellationVsRoomId")
	private Long cancellationVsRoomId;
	
	@JsonProperty("cancellationSlabId")
	private String cancellationSlabId;
	
	@JsonProperty("cancellations")
	private CancellationModel cancellations;
	
}
