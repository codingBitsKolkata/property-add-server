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
@Table(name = "master_wishlist")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class WishlistEntity extends CommonEntity {

	private static final long serialVersionUID = 4668857794991186192L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlist_id")
	private Long wishlistId;

	@Override
	public String toString() {
		return Long.toString(wishlistId);
	}

}
