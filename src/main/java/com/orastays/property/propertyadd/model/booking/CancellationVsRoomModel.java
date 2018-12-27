package com.orastays.property.propertyadd.model.booking;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.orastays.property.propertyadd.model.CommonModel;

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
