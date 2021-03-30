package com.app.service;

import java.util.List;

import com.app.pojos.Hospital;

public interface IHospitalService {
	Hospital findByHospitalAdminIDAndHospitalAdminPassword(String hospital_id, String password);

	List<Hospital> getHospitalByCity(String city);

	String registerHospital(Hospital hospital);
	
	String deleteHospital(String hospitalId);

}
