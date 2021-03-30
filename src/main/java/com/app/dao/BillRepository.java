package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {
	

}
