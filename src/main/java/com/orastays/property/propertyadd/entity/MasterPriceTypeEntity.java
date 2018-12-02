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
@Table(name = "master_price_type")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MasterPriceTypeEntity extends CommonEntity{
	
	private static final long serialVersionUID = 4482929565346280536L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "price_type_id")
	private Long priceTypeId;
	
	@Column(name = "name")
	private String PriceTypeName;
	
	@Column(name = "language_id")
	private Long languageId;

	@Column(name = "parent_id")
	private Long parentId;
}
