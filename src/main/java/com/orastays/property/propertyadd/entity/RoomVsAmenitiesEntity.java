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
@Table(name = "room_vs_amenities")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomVsAmenitiesEntity extends CommonEntity {

	private static final long serialVersionUID = 4056695926643993773L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_vs_ami_id")
	private Long roomVsAmiId;

	@Override
	public String toString() {
		return Long.toString(roomVsAmiId);
	}

}
