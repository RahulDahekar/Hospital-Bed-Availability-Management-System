package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminRepository;
import com.app.dao.HospitalRepository;
import com.app.pojos.Admin;
import com.app.pojos.Hospital;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private HospitalRepository hospitalRepo;

	@Override
	public Admin authenticateAdmin(String user_name, String password) {
		return adminRepo.findByUserNameAndPassword(user_name, password);
	}

	@Override
	public List<Hospital> getAllHospitalList() {
		return hospitalRepo.findAll();
	}

}
