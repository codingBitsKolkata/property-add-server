package com.orastays.property.propertyadd.model.booking;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.orastays.property.propertyadd.model.CommonModel;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class CancellationModel extends CommonModel {

	@JsonProperty("cancellationId")
	private Long cancellationId;

	@JsonProperty("totalPaybleWithoutGst")
	private String totalPaybleWithoutGst;

	@JsonProperty("totalAmountPaid")
	private String totalAmountPaid;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("reasonForCancellation")
	private String reasonForCancellation;

	@JsonProperty("totalAmountRefunded")
	private String totalAmountRefunded;

	@JsonProperty("bookings")
	private BookingModel bookings;
	
	@JsonProperty("cancellationVsRooms")
	private List<CancellationVsRoomModel> cancellationVsRooms;

}



