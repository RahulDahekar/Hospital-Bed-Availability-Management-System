package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_id")
	private Integer billID;

	@Column(nullable = false, name = "r_id")
	private int roomID;

	@Column(name = "r_Type")
	private String roomType;

	@Column(name = "r_charge")
	private double roomCharge;

	@Column(name = "admitted_days")
	private long admittedDays;

	@Column(name = "total_bill")
	private double totalBill;

	@OneToOne
	@JoinColumn(name = "patient_id")
	private Patient patientID;

	public Bill() {
		System.out.println("In Constructor of--> " + getClass().getName());
	}

	public Bill(Integer billID, int roomID, String roomType, double roomCharge, long admittedDays, double totalBill,
			Patient patientID) {
		super();
		this.billID = billID;
		this.roomID = roomID;
		this.roomType = roomType;
		this.roomCharge = roomCharge;
		this.admittedDays = admittedDays;
		this.totalBill = totalBill;
		this.patientID = patientID;
	}

	public Integer getBillID() {
		return billID;
	}

	public void setBillID(Integer billID) {
		this.billID = billID;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getRoomCharge() {
		return roomCharge;
	}

	public void setRoomCharge(double roomCharge) {
		this.roomCharge = roomCharge;
	}

	public long getAdmittedDays() {
		return admittedDays;
	}

	public void setAdmittedDays(long admittedDays) {
		this.admittedDays = admittedDays;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public Patient getPatientID() {
		return patientID;
	}

	public void setPatientID(Patient patientID) {
		this.patientID = patientID;
	}

	@Override
	public String toString() {
		return "Bill [billID=" + billID + ", roomID=" + roomID + ", roomType=" + roomType + ", roomCharge=" + roomCharge
				+ ", admittedDays=" + admittedDays + ", totalBill=" + totalBill + ", patientID=" + patientID + "]";
	}

}
