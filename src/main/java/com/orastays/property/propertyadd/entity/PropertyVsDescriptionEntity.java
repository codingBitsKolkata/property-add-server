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
@Table(name = "property_vs_description")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PropertyVsDescriptionEntity extends CommonEntity  {
	
	private static final long serialVersionUID = 7334573917152398666L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_desc_id")
	private Long propertyDescId;

	@Column(name = "description")
	private String description;
	
	@Column(name = "language_id")
	private Long languageId;
	
	@Override
	public String toString() {
		return Long.toString(propertyDescId);
	}
}
