package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Admin {

	@Id
	@Column(name = "admin_id")
	private Integer adminID;

	@Column(length = 20, name = "user_name", nullable = false, unique = true)
	@NotBlank(message = "Please insert Admin User Name")
	private String userName;

	@Column(length = 20, name = "password", nullable = false)
	@NotBlank(message = "Must Insert Password")
	private String password;

	public Admin() {
		System.out.println("In Constructor of--> " + getClass().getName());
	}

	public Admin(Integer adminID, @NotBlank(message = "Please insert Admin User Name") String userName,
			@NotBlank(message = "Must Insert Password") String password) {
		super();
		this.adminID = adminID;
		this.userName = userName;
		this.password = password;
	}

	public Integer getAdminID() {
		return adminID;
	}

	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", userName=" + userName + ", password=" + password + "]";
	}
}
