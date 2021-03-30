package com.app.service;

import java.util.List;

import com.app.pojos.Admin;
import com.app.pojos.Hospital;

public interface IAdminService {
	Admin authenticateAdmin(String user_name, String password);

	List<Hospital> getAllHospitalList();
}
