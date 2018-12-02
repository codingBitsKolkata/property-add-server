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
@Table(name = "master_discount_category_ora")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MasterDiscountCategoryOraEntity extends CommonEntity{

	private static final long serialVersionUID = 2752461122831226327L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dco_id")
	private Long dco_id;
	
	@Column(name = "name")
	private String DisCatOraname;
}
