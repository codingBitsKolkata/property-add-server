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
@Table(name = "master_room_standard")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MasterRoomStandardEntity extends CommonEntity {
	
	private static final long serialVersionUID = 6541222811110498279L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_standard_id")
	private Long roomStandardId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "language_id")
	private Long languageId;

	@Column(name = "parent_id")
	private Long parentId;

}
