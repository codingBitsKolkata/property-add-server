package com.orastays.property.propertyadd.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "state_vs_city")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class StateVsCityEntity extends CommonEntity {

	private static final long serialVersionUID = -1048032541832747832L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "svc_id")
	@JsonProperty("svcId")
	private Long svcId;

	@Column(name = "city_name")
	@JsonProperty("cityName")
	private String cityName;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "cvs_id", nullable = false)
	@JsonProperty("countryVsStates")
	private CountryVsStateEntity countryVsStateEntity;

	@Override
	public String toString() {
		return Long.toString(svcId);
	}

}
