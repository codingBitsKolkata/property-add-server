package com.orastays.property.propertyadd.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class RoomVsSpecialitiesModel extends CommonModel {

	private String roomspecId;
	private SpecialtiesModel specialtiesModel;
	private RoomModel roomModel;
}
