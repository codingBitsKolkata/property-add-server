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
@Table(name = "master_amenities")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AmenitiesEntity extends CommonEntity{
	
	private static final long serialVersionUID = 5562924720677171528L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aminities_id")
	private Long aminitiesId;
	
	@Column(name = "name")
	private String amiName;
	
	@Column(name = "language_id")
	private Long languageId;

	@Column(name = "parent_id")
	private Long parentId;

}
