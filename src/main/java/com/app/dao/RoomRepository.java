package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Patient;
import com.app.pojos.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

	Room findByPatientId(Patient pid);

}
