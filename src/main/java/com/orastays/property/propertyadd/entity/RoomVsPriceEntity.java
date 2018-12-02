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
@Table(name = "room_vs_price")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomVsPriceEntity extends CommonEntity {

	private static final long serialVersionUID = -2273919889166166287L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_vs_price_id")
	private Long roomVsPriceId;

	@Column(name = "price")
	private String price;

	@Override
	public String toString() {
		return Long.toString(roomVsPriceId);
	}

}
