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
@Table(name = "room_vs_specialties")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomVsSpecialitiesEntity extends CommonEntity {

	private static final long serialVersionUID = 3003716361946912468L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roomspec_id")
	private Long roomspecId;

	@Override
	public String toString() {
		return Long.toString(roomspecId);
	}

}
