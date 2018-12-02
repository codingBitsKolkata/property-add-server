package com.orastays.property.propertyadd.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class PropertyVsGuestAccessModel extends CommonModel {

	private String propertyGAccessId;
	private String guestAccess;
	private PropertyModel propertyModel;
}
