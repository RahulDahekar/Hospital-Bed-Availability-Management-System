package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "r_id")
	private Integer roomID;

	@Column(length = 20, name = "r_type")
	@NotBlank(message = "Insert Room type which will allot to patient")
	private String roomType;

	@OneToOne
	@JoinColumn(name = "patient_id")
	private Patient patientId;

	public Room() {
		System.out.println("In Constructor of--> " + getClass().getName());
	}

	public Room(Integer roomID, @NotBlank(message = "Insert Room type which will allot to patient") String roomType,
			Patient patientId) {
		super();
		this.roomID = roomID;
		this.roomType = roomType;
		this.patientId = patientId;
	}

	public Integer getRoomID() {
		return roomID;
	}

	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", roomType=" + roomType + ", patientId=" + patientId + "]";
	}

}
