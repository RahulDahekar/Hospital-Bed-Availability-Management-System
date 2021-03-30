package com.app.service;

import java.util.List;

import com.app.pojos.Hospital;
import com.app.pojos.Patient;

public interface IPatientService {
	String registerPatient(Patient patient, Hospital hospital);

	List<Patient> getAllPatient(Hospital hospital);

	Patient findPatientByID(int pid);

	String updateStatus(int pid);

	List<Patient> getAllPatientByHospitalIDAndStatus(Hospital hospital, String status);
}
