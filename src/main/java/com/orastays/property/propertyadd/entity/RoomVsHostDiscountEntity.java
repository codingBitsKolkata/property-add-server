package com.orastays.property.propertyadd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_property")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomVsHostDiscountEntity extends CommonEntity {

	private static final long serialVersionUID = -5073041377859715363L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rhd_id")
	private Long rhdId;

	@Column(name = "percentage")
	private String percentage;

	@Override
	public String toString() {
		return Long.toString(rhdId);
	}

}
