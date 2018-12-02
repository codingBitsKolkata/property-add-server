package com.orastays.property.propertyadd.model;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class MealPlanCategoryVsMealPlanModel extends CommonModel {

	private String mpcmpId;
	private String name;
	private MealPlanCategoryModel mealPlanCategoryModel;
	private MealPlanModel mealPlanModel;
	private List<RoomVsMealModel> roomVsMealModels;
}
