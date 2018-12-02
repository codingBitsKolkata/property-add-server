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
@Table(name = "room_vs_image")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomVsImageEntity extends CommonEntity {

	private static final long serialVersionUID = -3792169192286757956L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_vs_image_id")
	private Long roomVsImageId;

	@Column(name = "image_url")
	private String imageUrl;

	@Override
	public String toString() {
		return Long.toString(roomVsImageId);
	}

}
