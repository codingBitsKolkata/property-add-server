package com.orastays.property.propertyadd.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class PGCategorySexModel extends CommonModel {

	private String pgcsId;
	private String languageId;
	private String parentId;
	private String categoryName;
}
