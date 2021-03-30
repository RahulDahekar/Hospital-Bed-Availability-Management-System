package com.app.service;

import static java.time.LocalDate.now;

import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BillRepository;
import com.app.pojos.Bill;
import com.app.pojos.Patient;
import com.app.pojos.Room;
import com.app.pojos.RoomType;

@Service
@Transactional
public class BillServiceImpl implements IBillService {

	public BillServiceImpl() {
		System.out.println("In Default Constructor of--> " + getClass().getName());
	}

	@Autowired
	private BillRepository billRepo;

	@Override
	public String generateBill(Patient patient, Bill bill) {
		patient.addBill(bill);
		Bill newBill = billRepo.save(bill);
		return "Bill Registered with ID--> " + newBill.getBillID() + " ,for Patient ID--> " + newBill.getPatientID();
	}

	@Override
	public Bill saveBill(Patient patient, Room room, RoomType roomType) {

		Bill bill = new Bill();
		bill.setPatientID(patient);
		bill.setRoomType(room.getRoomType());
		bill.setRoomID(room.getRoomID());
		bill.setAdmittedDays((ChronoUnit.DAYS.between(patient.getAdmitDate(), now())) + 1);

		if (room.getRoomType().equalsIgnoreCase(roomType.getGeneral())) {
			bill.setRoomCharge(roomType.getGeneralPrice());

		} else if (room.getRoomType().equalsIgnoreCase(roomType.getIcu())) {
			bill.setRoomCharge(roomType.getIcuPrice());

		} else
			bill.setRoomCharge(roomType.getNonicuPrice());

		Bill newBill = billRepo.save(bill);
		newBill.setTotalBill(newBill.getRoomCharge()*newBill.getAdmittedDays());

		return newBill;
	}
}
