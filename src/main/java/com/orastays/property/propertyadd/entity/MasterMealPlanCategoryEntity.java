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
@Table(name = "master_meal_plan_category")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MasterMealPlanCategoryEntity extends CommonEntity {

	private static final long serialVersionUID = -9073085176444953780L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mpc_id")
	private Long mpcId;
	
	@Column(name = "name")
	private String MpcName;
	
	@Column(name = "language_id")
	private Long languageId;

	@Column(name = "parent_id")
	private Long parentId;

}
