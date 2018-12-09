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
@Table(name = "master_stay_type")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class StayTypeEntity  extends CommonEntity {

	private static final long serialVersionUID = -3614599798351715620L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stay_type_id")
	private Long stayTypeId;
	
	@Column(name = "language_id")
	private Long languageId;

	@Column(name = "parent_id")
	private Long parentId;

	@Column(name = "stay_type_name")
	private String stayTypeName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stayTypeEntity", cascade = { CascadeType.ALL })
	private List<PropertyEntity> propertyEntities;
	
	@Override
	public String toString() {
		return Long.toString(stayTypeId);
	}
	
}
