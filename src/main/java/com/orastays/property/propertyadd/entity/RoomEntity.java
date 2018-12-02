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
@Table(name = "master_room")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomEntity extends CommonEntity{
	
	private static final long serialVersionUID = 6058717921502574720L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private Long roomId;
	
	@Column(name = "shared_space")
	private String sharedSpace;
	
	@Column(name = "cot_available")
	private String cotAvailable;

	@Column(name = "no_of_guest")
	private String noOfGuest;
	
	@Column(name = "no_of_child")
	private String noOfChild;
	
	@Column(name = "num_of_cot")
	private String numOfCot;
	
	@Column(name = "commision")
	private String commision;
	
	@Column(name = "floor_no")
	private String floorNo;
}
