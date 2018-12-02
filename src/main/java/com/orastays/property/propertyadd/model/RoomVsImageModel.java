package com.orastays.property.propertyadd.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class RoomVsImageModel extends CommonModel {

	private String roomVsImageId;
	private String imageUrl;
	private RoomModel roomModel;
}
