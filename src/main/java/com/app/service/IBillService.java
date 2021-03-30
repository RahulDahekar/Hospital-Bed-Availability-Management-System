package com.app.service;

import com.app.pojos.Bill;
import com.app.pojos.Patient;
import com.app.pojos.Room;
import com.app.pojos.RoomType;

public interface IBillService {

	String generateBill(Patient patient, Bill bill);

	Bill saveBill(Patient patient, Room room, RoomType roomType);

	
}
