package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hospitalID;

	@Column(length = 20, name = "hospital_admin_id", unique = true, nullable = false)
	@NotBlank(message = "Please insert Unique Hospital Admin ID")
	
	private String hospitalAdminID;

	@Column(length = 50, nullable = false)
	@NotBlank(message = "Please insert Hospital Name")
	private String name;

	@Column(length = 50, nullable = false)
	@NotBlank(message = "Please insert Hospital Address")
	private String address;

	@Column(length = 20, nullable = false)
	@NotBlank(message = "Please insert City name")
	private String city;

	@Column(length = 20, nullable = false)
	@NotBlank(message = "Please insert State Name")
	private String state;

	@Column(nullable = false, name = "contact_no")
	private long contactNo;

	@Column(length = 20, name = "password", nullable = false)
	@NotBlank(message = "Hospital Admin Password can't be null")
	private String hospitalAdminPassword;

	@OneToMany(mappedBy = "hospitalID", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Patient> patientID;

	@OneToOne(mappedBy = "hospitalId", cascade = CascadeType.ALL)
	private RoomType roomId;

	public Hospital() {
		System.out.println("In Constructor of--> " + getClass().getName());
	}

	public Hospital(Integer hospitalID,
			@NotBlank(message = "Please insert Unique Hospital Admin ID") String hospitalAdminID,
			@NotBlank(message = "Please insert Hospital Name") String name,
			@NotBlank(message = "Please insert Hospital Address") String address,
			@NotBlank(message = "Please insert City name") String city,
			@NotBlank(message = "Please insert State Name") String state, long contactNo,
			@NotBlank(message = "Hospital Admin Password can't be null") String hospitalAdminPassword,
			List<Patient> patientID, RoomType roomId) {
		super();
		this.hospitalID = hospitalID;
		this.hospitalAdminID = hospitalAdminID;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.contactNo = contactNo;
		this.hospitalAdminPassword = hospitalAdminPassword;
		this.patientID = patientID;
		this.roomId = roomId;
	}

	public Integer getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(Integer hospitalID) {
		this.hospitalID = hospitalID;
	}

	public String getHospitalAdminID() {
		return hospitalAdminID;
	}

	public void setHospitalAdminID(String hospitalAdminID) {
		this.hospitalAdminID = hospitalAdminID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getHospitalAdminPassword() {
		return hospitalAdminPassword;
	}

	public void setHospitalAdminPassword(String hospitalAdminPassword) {
		this.hospitalAdminPassword = hospitalAdminPassword;
	}

	public List<Patient> getPatientID() {
		return patientID;
	}

	public void setPatientID(List<Patient> patientID) {
		this.patientID = patientID;
	}

	public RoomType getRoomId() {
		return roomId;
	}

	public void setRoomId(RoomType roomId) {
		this.roomId = roomId;
	}

	// HELPER METHODS
	public void addPatient(Patient patient) {
		patientID.add(patient);
		patient.setHospitalID(this);
	}

	public void removePatient(Patient patient) {
		patientID.remove(patient);
		patient.setHospitalID(null);
	}

	// HELPER METHOD
	public void addRoomType(RoomType roomType) {
		roomId = roomType;
		roomType.setHospitalId(this);
	}

	public void removeRoomType(RoomType roomType) {
		roomId = null;
		roomType.setHospitalId(null);
	}

	@Override
	public String toString() {
		return "Hospital [hospitalID=" + hospitalID + ", hospitalAdminID=" + hospitalAdminID + ", name=" + name
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", contactNo=" + contactNo
				+ ", hospitalAdminPassword=" + hospitalAdminPassword + ", patientID=" + patientID + ", roomId=" + roomId
				+ "]";
	}

}
