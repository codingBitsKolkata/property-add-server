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
@Table(name = "room_vs_cancellation")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomVsCancellationEntity extends CommonEntity {

	private static final long serialVersionUID = -8225974515594117532L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rc_id")
	private Long rcId;

	@Column(name = "percentage")
	private String percentage;

	@Override
	public String toString() {
		return Long.toString(rcId);
	}

}
