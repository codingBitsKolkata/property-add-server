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
@Table(name = "room_vs_ora_price_percentage")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomVsOraPricePercentageEntity extends CommonEntity {

	private static final long serialVersionUID = -8777445238755662208L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rop_id")
	private Long ropId;

	@Column(name = "percentage")
	private String percentage;

	@Override
	public String toString() {
		return Long.toString(ropId);
	}

}
