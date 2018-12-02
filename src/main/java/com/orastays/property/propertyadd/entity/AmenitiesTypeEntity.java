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
@Table(name = "master_amenities_type")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AmenitiesTypeEntity extends CommonEntity{

	private static final long serialVersionUID = -7850034465030929606L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ami_type_id")
	private Long amiTypeId;
	
	@Column(name = "name")
	private String amiTypeName;
}
