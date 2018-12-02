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
@Table(name = "master_discount_category_host")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MasterDiscountCategoryHostEntity extends CommonEntity {
	
	private static final long serialVersionUID = -4056330502466224589L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dch_id")
	private Long dch_id;
	
	@Column(name = "name")
	private String DisCatHostname;
	
	@Column(name = "language_id")
	private Long languageId;

	@Column(name = "parent_id")
	private Long parentId;

}
