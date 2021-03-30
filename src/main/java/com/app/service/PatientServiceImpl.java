package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PatientRepository;
import com.app.pojos.Hospital;
import com.app.pojos.Patient;

@Service
@Transactional
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientRepository patientRepo;

	@Override
	public String registerPatient(Patient patient, Hospital hospital) {
		hospital.addPatient(patient);
		Patient newPatient = patientRepo.save(patient);
		if (patientRepo.findById(newPatient.getPatientID()).isPresent()) {
			return "Patient registered with ID--> " + newPatient.getPatientID();
		} else
			return "Failed to Admit new Patient";
	}

	@Override
	public List<Patient> getAllPatient(Hospital hospital) {

		return patientRepo.findByHospitalID(hospital);
	}

	@Override
	public Patient findPatientByID(int pid) {
		return patientRepo.findByPatientID(pid);
	}

	@Override
	public String updateStatus(int pid) {
		patientRepo.updateStatus(pid);
		return "Staus updated for pateint id--> " + pid;
	}

	@Override
	public List<Patient> getAllPatientByHospitalIDAndStatus(Hospital hospital, String status) {
		
		return patientRepo.findByHospitalIDAndStatus(hospital, status);
	}

	

}
