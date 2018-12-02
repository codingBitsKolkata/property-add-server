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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_property")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PropertyEntity extends CommonEntity {

	private static final long serialVersionUID = -7666760673115186373L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_id")
	private Long propertyId;

	@Column(name = "name")
	private String name;

	@Column(name = "oraname")
	private String oraname;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "property_type_id", nullable = false)
	private PropertyTypeEntity propertyTypeEntity;

	@Column(name = "entire_apartment")
	private String entireApartment;

	@Column(name = "dedicated_space")
	private String dedicatedSpace;

	@Column(name = "apartment_name")
	private String apartmentName;

	@Column(name = "apartment_number")
	private String apartmentNumber;

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "longitude")
	private String longitude;

	@Column(name = "address")
	private String address;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "checkin_time")
	private String checkinTime;

	@Column(name = "checkout_time")
	private String checkoutTime;

	@Column(name = "cover_image_url")
	private String coverImageUrl;

	@Column(name = "price_drop")
	private String priceDrop;

	@Override
	public String toString() {
		return Long.toString(propertyId);
	}

}
