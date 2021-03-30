package com.app.service;

import com.app.pojos.Patient;
import com.app.pojos.Room;

public interface IRoomService {
	String registerRoom(Room room, Patient patient);

	Room findByPatientID(Patient pid);
}
