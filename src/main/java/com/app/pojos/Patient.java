package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private Integer patientID;

	@Column(length = 50, nullable = false)
	@NotBlank(message = "Please insert Patient Name")
	private String name;

	@Column(length = 20, nullable = false)
	@NotBlank(message = "Please insert Patient Gender")
	private String gender;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false, name = "contact_no")
	private long contactNo;

	@Column(length = 50, nullable = false)
	@NotBlank(message = "Please insert Patient Address")
	private String address;

	@Column(length = 20, nullable = false)
	@NotBlank(message = "Please insert City Name")
	private String city;

	@Column(length = 20, nullable = false)
	@NotBlank(message = "Please insert State")
	private String state;

	@Column(length = 50)
	@NotBlank(message = "Please insert Patient Disease")
	private String disease;

	@Column(nullable = false, name = "admit_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate admitDate;

	@Column(nullable = false)
	private String status;

	@OneToOne(mappedBy = "patientId", cascade = CascadeType.ALL)
	private Room roomId;

	@ManyToOne
	@JoinColumn(name = "hospital_id", nullable = false)
	private Hospital hospitalID;

	@OneToOne(mappedBy = "patientID", cascade = CascadeType.ALL)
	private Bill billId;

	public Patient() {
		System.out.println("In Constructor of--> " + getClass().getName());
	}

//	public Patient(Integer patientID, @NotBlank(message = "Please insert Patient Name") String name,
//			@NotBlank(message = "Please insert Patient Geneder") String gender, int age, long contactNo,
//			@NotBlank(message = "Please insert Patient Adress") String address,
//			@NotBlank(message = "Please insert City Name") String city,
//			@NotBlank(message = "Please insert State") String state,
//			@NotBlank(message = "Please insert Patient Disease") String disease, LocalDate admitDate, Room roomId,
//			Hospital hospitalID) {
//		super();
//		this.patientID = patientID;
//		this.name = name;
//		this.gender = gender;
//		this.age = age;
//		this.contactNo = contactNo;
//		this.address = address;
//		this.city = city;
//		this.state = state;
//		this.disease = disease;
//		this.admitDate = admitDate;
//		this.roomId = roomId;
//		this.hospitalID = hospitalID;
//	}
//	public Patient(Integer patientID, @NotBlank(message = "Please insert Patient Name") String name,
//			@NotBlank(message = "Please insert Patient Geneder") String gender, int age, long contactNo,
//			@NotBlank(message = "Please insert Patient Adress") String address,
//			@NotBlank(message = "Please insert City Name") String city,
//			@NotBlank(message = "Please insert State") String state,
//			@NotBlank(message = "Please insert Patient Disease") String disease, LocalDate admitDate, boolean status,
//			Room roomId, Hospital hospitalID) {
//		super();
//		this.patientID = patientID;
//		this.name = name;
//		this.gender = gender;
//		this.age = age;
//		this.contactNo = contactNo;
//		this.address = address;
//		this.city = city;
//		this.state = state;
//		this.disease = disease;
//		this.admitDate = admitDate;
//		this.status = status;
//		this.roomId = roomId;
//		this.hospitalID = hospitalID;
//	}

	public Integer getPatientID() {
		return patientID;
	}

	public void setPatientID(Integer patientID) {
		this.patientID = patientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public LocalDate getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(LocalDate admitDate) {
		this.admitDate = admitDate;
	}

	public Room getRoomId() {
		return roomId;
	}

	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}

	public Hospital getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(Hospital hospitalID) {
		this.hospitalID = hospitalID;
	}

	public String getStatus() {
		return status;
	}

	
	
	public void setStatus(String status) {
		this.status = status;
	}

	public Bill getBillId() {
		return billId;
	}

	public void setBillId(Bill billId) {
		this.billId = billId;
	}

	
	// HELPER METHOD
	public void addRoom(Room room) {
		roomId = room;
		room.setPatientId(this);
	}

	public void removeRoom(Room room) {
		roomId = null;
		room.setPatientId(null);
	}

	//HELPER METHOD 2
	public void addBill(Bill bill) {
		billId=bill;
		bill.setPatientID(this);
	}

	public void removeBill(Bill bill) {
		billId=null;
		bill.setPatientID(null);
	}
	
	public Patient(Integer patientID, @NotBlank(message = "Please insert Patient Name") String name,
			@NotBlank(message = "Please insert Patient Geneder") String gender, int age, long contactNo,
			@NotBlank(message = "Please insert Patient Adress") String address,
			@NotBlank(message = "Please insert City Name") String city,
			@NotBlank(message = "Please insert State") String state,
			@NotBlank(message = "Please insert Patient Disease") String disease, LocalDate admitDate, String status,
			Room roomId, Hospital hospitalID, Bill billId) {
		super();
		this.patientID = patientID;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.contactNo = contactNo;
		this.address = address;
		this.city = city;
		this.state = state;
		this.disease = disease;
		this.admitDate = admitDate;
		this.status = status;
		this.roomId = roomId;
		this.hospitalID = hospitalID;
		this.billId = billId;
	}

	@Override
	public String toString() {
		return "Patient [patientID=" + patientID + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", contactNo=" + contactNo + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", disease=" + disease + ", admitDate=" + admitDate + ", status=" + status + ", roomId=" + roomId
				+ ", hospitalID=" + hospitalID + ", billId=" + billId + "]";
	}

	// NEW
//	public Patient(Integer patientID, @NotBlank(message = "Please insert Patient Name") String name,
//			@NotBlank(message = "Please insert Patient Geneder") String gender, int age, long contactNo,
//			@NotBlank(message = "Please insert Patient Adress") String address,
//			@NotBlank(message = "Please insert City Name") String city,
//			@NotBlank(message = "Please insert State") String state,
//			@NotBlank(message = "Please insert Patient Disease") String disease, LocalDate admitDate, String status,
//			Room roomId, Hospital hospitalID) {
//		super();
//		this.patientID = patientID;
//		this.name = name;
//		this.gender = gender;
//		this.age = age;
//		this.contactNo = contactNo;
//		this.address = address;
//		this.city = city;
//		this.state = state;
//		this.disease = disease;
//		this.admitDate = admitDate;
//		this.status = status;
//		this.roomId = roomId;
//		this.hospitalID = hospitalID;
//	}
//
//	@Override
//	public String toString() {
//		return "Patient [patientID=" + patientID + ", name=" + name + ", gender=" + gender + ", age=" + age
//				+ ", contactNo=" + contactNo + ", address=" + address + ", city=" + city + ", state=" + state
//				+ ", disease=" + disease + ", admitDate=" + admitDate + ", status=" + status + ", roomId=" + roomId
//				+ ", hospitalID=" + hospitalID + "]";
//	}

	// OLD
//	public boolean isStatus() {
//		return status;
//	}
//
//	public void setStatus(boolean status) {
//		this.status = status;
//	}
//
//	@Override
//	public String toString() {
//		return "Patient [patientID=" + patientID + ", name=" + name + ", gender=" + gender + ", age=" + age
//				+ ", contactNo=" + contactNo + ", address=" + address + ", city=" + city + ", state=" + state
//				+ ", disease=" + disease + ", admitDate=" + admitDate + ", status=" + status + ", roomId=" + roomId
//				+ ", hospitalID=" + hospitalID + "]";
//	}

//	@Override
//	public String toString() {
//		return "Patient [patientID=" + patientID + ", name=" + name + ", gender=" + gender + ", age=" + age
//				+ ", contactNo=" + contactNo + ", address=" + address + ", city=" + city + ", state=" + state
//				+ ", disease=" + disease + ", admitDate=" + admitDate + ", roomId=" + roomId + ", hospitalID="
//				+ hospitalID + "]";
//	}
}
