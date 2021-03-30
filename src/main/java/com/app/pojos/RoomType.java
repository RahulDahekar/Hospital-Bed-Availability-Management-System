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
public class RoomType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "r_cid")
	private Integer roomCategoryId;

	@Column(length = 20, name = "icu")
	private String icu;

	@Column(name = "icuquantity")
	private int icuQuantity;

	@Column(name = "icuprice")
	private int icuPrice;

	@Column(length = 20, name = "nonicu")
	private String nonicu;

	@Column(name = "nonicuquantity")
	private int nonicuQuantity;

	@Column(name = "nonicuprice")
	private int nonicuPrice;

	@Column(length = 20, name = "general")
	private String general;

	@Column(name = "generalquantity")
	private int generalQuantity;

	@Column(name = "generalprice")
	private int generalPrice;

	@OneToOne
	@JoinColumn(name = "hospital_id")
	private Hospital hospitalId;

	public RoomType() {
		System.out.println("In Constructor of--> " + getClass().getName());
	}

	public RoomType(Integer roomCategoryId, String icu, int icuQuantity, int icuPrice, String nonicu,
			int nonicuQuantity, int nonicuPrice, String general, int generalQuantity, int generalPrice,
			Hospital hospitalId) {
		super();
		this.roomCategoryId = roomCategoryId;
		this.icu = icu;
		this.icuQuantity = icuQuantity;
		this.icuPrice = icuPrice;
		this.nonicu = nonicu;
		this.nonicuQuantity = nonicuQuantity;
		this.nonicuPrice = nonicuPrice;
		this.general = general;
		this.generalQuantity = generalQuantity;
		this.generalPrice = generalPrice;
		this.hospitalId = hospitalId;
	}

	public Integer getRoomCategoryId() {
		return roomCategoryId;
	}

	public void setRoomCategoryId(Integer roomCategoryId) {
		this.roomCategoryId = roomCategoryId;
	}

	public String getIcu() {
		return icu;
	}

	public void setIcu(String icu) {
		this.icu = icu;
	}

	public int getIcuQuantity() {
		return icuQuantity;
	}

	public void setIcuQuantity(int icuQuantity) {
		this.icuQuantity = icuQuantity;
	}

	public int getIcuPrice() {
		return icuPrice;
	}

	public void setIcuPrice(int icuPrice) {
		this.icuPrice = icuPrice;
	}

	public String getNonicu() {
		return nonicu;
	}

	public void setNonicu(String nonicu) {
		this.nonicu = nonicu;
	}

	public int getNonicuQuantity() {
		return nonicuQuantity;
	}

	public void setNonicuQuantity(int nonicuQuantity) {
		this.nonicuQuantity = nonicuQuantity;
	}

	public int getNonicuPrice() {
		return nonicuPrice;
	}

	public void setNonicuPrice(int nonicuPrice) {
		this.nonicuPrice = nonicuPrice;
	}

	public String getGeneral() {
		return general;
	}

	public void setGeneral(String general) {
		this.general = general;
	}

	public int getGeneralQuantity() {
		return generalQuantity;
	}

	public void setGeneralQuantity(int generalQuantity) {
		this.generalQuantity = generalQuantity;
	}

	public int getGeneralPrice() {
		return generalPrice;
	}

	public void setGeneralPrice(int generalPrice) {
		this.generalPrice = generalPrice;
	}

	public Hospital getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Hospital hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
	public String toString() {
		return "RoomType [roomCategoryId=" + roomCategoryId + ", icu=" + icu + ", icuQuantity=" + icuQuantity
				+ ", icuPrice=" + icuPrice + ", nonicu=" + nonicu + ", nonicuQuantity=" + nonicuQuantity
				+ ", nonicuPrice=" + nonicuPrice + ", general=" + general + ", generalQuantity=" + generalQuantity
				+ ", generalPrice=" + generalPrice + ", hospitalId=" + hospitalId + "]";
	}

}
