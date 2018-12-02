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
@Table(name = "room_vs_ora_discount")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomVsOraDiscountEntity extends CommonEntity {

	private static final long serialVersionUID = 4812007616729827126L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rod_id")
	private Long rodId;

	@Column(name = "percentage")
	private String percentage;

	@Override
	public String toString() {
		return Long.toString(rodId);
	}

}
