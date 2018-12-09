package com.orastays.property.propertyadd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_space_rule")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SpaceRuleEntity extends CommonEntity {

	private static final long serialVersionUID = -1471529831177448152L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sprule_id")
	@JsonProperty("spruleId")
	private Long spruleId;
	
	@Column(name = "language_id")
	@JsonProperty("languageId")
	private Long languageId;

	@Column(name = "parent_id")
	@JsonProperty("parentId")
	private Long parentId;

	@Column(name = "rule_name")
	@JsonProperty("ruleName")
	private String ruleName;

	@Override
	public String toString() {
		return Long.toString(spruleId);
	}
}
