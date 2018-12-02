package com.orastays.property.propertyadd.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_room_category")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomCategoryEntity extends CommonEntity {

	private static final long serialVersionUID = -2294186374416004239L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_cat_id")
	private Long roomCatId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "language_id")
	private Long languageId;

	@Column(name = "parent_id")
	private Long parentId;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomCategoryEntity", cascade = { CascadeType.ALL })
	private List<RoomEntity> roomEntities;
	
	@Override
	public String toString() {
		return Long.toString(roomCatId);
	}
}
