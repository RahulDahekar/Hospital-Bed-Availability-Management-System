package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Hospital;
import com.app.pojos.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	List<Patient> findByHospitalID(Hospital hospitalId);

	Patient findByPatientID(int pid);

//	Patient 

	@Modifying
	@Query(value = "update Patient p set p.status='Discharged' where p.patientID=:id")
	void updateStatus(int id);

	
	List<Patient> findByHospitalIDAndStatus(Hospital hospital,String status);

}
