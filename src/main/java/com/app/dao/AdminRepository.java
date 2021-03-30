package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByUserNameAndPassword(String user_name, String password);

}
