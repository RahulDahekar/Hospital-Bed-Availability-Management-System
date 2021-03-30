package com.app.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.HospitalRepository;
import com.app.pojos.Hospital;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

	@Autowired
	private HospitalRepository hospitalRepo;

	// Authenticate Hospital Admin
	@Override
	public Hospital findByHospitalAdminIDAndHospitalAdminPassword(String hospital_id, String password) {
		return hospitalRepo.findByHospitalAdminIDAndHospitalAdminPassword(hospital_id, password);
	}

	@Override
	public List<Hospital> getHospitalByCity(String city) {
		return hospitalRepo.findByCity(city);
	}

	// Register New Hospital

	@Override
	public String registerHospital(Hospital hospital) {
		Hospital newHospital = hospitalRepo.save(hospital);
		return "Hospital Regitsered with ID--> " + newHospital.getHospitalID();
	}

	@Override
	public String deleteHospital(String hospitalId) {
		hospitalRepo.deleteByHospitalAdminID(hospitalId);
		return "Hospital Deleted with Hospital ID--> "+hospitalId;
	}

}
