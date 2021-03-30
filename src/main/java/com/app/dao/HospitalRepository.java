package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	Hospital findByHospitalAdminIDAndHospitalAdminPassword(String hospital_id, String password);

	List<Hospital> findByCity(String city);
	
	String deleteByHospitalAdminID(String hospitalAdminId);
}
