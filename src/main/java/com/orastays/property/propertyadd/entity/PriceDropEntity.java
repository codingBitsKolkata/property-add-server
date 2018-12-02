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
@Table(name = "master_price_drop")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PriceDropEntity extends CommonEntity {

	private static final long serialVersionUID = 4697022789596398163L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "price_drop_id")
	private Long priceDropId;

	@Column(name = "after_time")
	private String afterTime;

	@Override
	public String toString() {
		return Long.toString(priceDropId);
	}

}
