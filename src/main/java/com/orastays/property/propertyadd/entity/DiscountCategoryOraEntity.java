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
@Table(name = "master_discount_category_ora")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class DiscountCategoryOraEntity extends CommonEntity{

	private static final long serialVersionUID = 2752461122831226327L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dco_id")
	private Long dcoId;
	
	@Column(name = "dis_cat_ora_name")
	private String disCatOraname;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "discountCategoryOraEntity", cascade = { CascadeType.ALL })
	private List<RoomVsOraDiscountEntity> roomVsOraDiscountEntities;
	
	@Override
	public String toString() {
		return Long.toString(dcoId);
	}
}