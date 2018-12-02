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
@Table(name = "meal_plan_cat_vs_meal_plan")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MealPlanCatVsMealPlanEntity extends CommonEntity{

	private static final long serialVersionUID = -2218223338060085395L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mpcmp_id")
	private Long mpcmpId;
	
	@Column(name = "name")
	private String name;
}
