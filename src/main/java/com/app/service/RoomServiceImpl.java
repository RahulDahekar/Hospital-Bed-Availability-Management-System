package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.RoomRepository;
import com.app.pojos.Patient;
import com.app.pojos.Room;

@Service
@Transactional
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private RoomRepository roomRepo;

	@Override
	public String registerRoom(Room room, Patient patient) {
		patient.addRoom(room);
		Room newRoom = roomRepo.save(room);

		return "Room allocated with ID--> " + newRoom.getRoomID();
	}

	@Override
	public Room findByPatientID(Patient pid) {
		return roomRepo.findByPatientId(pid);
	}

}
