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
@Table(name = "master_meal_category")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MasterMealCategoryEntity extends CommonEntity{
	
	private static final long serialVersionUID = 1428625624687027747L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "meal_category_id")
	private Long mealCategoryId;
	
	@Column(name = "name")
	private String MealCatName;
	
	@Column(name = "language_id")
	private Long languageId;

	@Column(name = "parent_id")
	private Long parentId;

}
