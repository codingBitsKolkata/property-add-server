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
@Table(name = "master_meal_type")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MealTypeEntity extends CommonEntity{
	
	private static final long serialVersionUID = -8486375113883948188L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "meal_type_id")
	private Long mealTypeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "img_url")
	private String imgUrl;
}
