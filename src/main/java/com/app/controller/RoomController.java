package com.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Hospital;
import com.app.pojos.Patient;
import com.app.pojos.Room;
import com.app.pojos.RoomType;
import com.app.service.IRoomService;
import com.app.service.IRoomTypeService;

@Controller
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private IRoomService roomService;

	@Autowired
	private IRoomTypeService roomTypeService;

	@GetMapping("/allocate")
	public String showRoomAllocationForm(Model map) {
		System.out.println("In room allocation form");
		map.addAttribute("room", new Room());
		return "/room/allocate";
	}

	@PostMapping("/allocate")
	public String processRoomAllocationForm(@Valid Room room, BindingResult result, RedirectAttributes flashMap,
			HttpSession session) {
		System.out.println("In process Room allocation form  " + room);
		System.out.println("Binding Result--> " + result);
		if (result.hasErrors()) {
			System.out.println("P.L Errors");
			return "/room/allocate";
		}
		Patient patient = (Patient) session.getAttribute("patient_details");

		Hospital hospital = (Hospital) session.getAttribute("hospital_details");

		RoomType roomType = roomTypeService.checkRoomQuantity(hospital);
		// BUSINESS LOGIC
		// for updation in RoomType table of corresponding Hospital whenever a patient
		// is admitted
		if (room.getRoomType().equalsIgnoreCase("ICU") && roomType.getIcuQuantity() > 0) 
		{
			flashMap.addFlashAttribute("message", roomService.registerRoom(room, patient));
			roomTypeService.updateICURoom(hospital);
			return "redirect:/hospital/welcome";
		} 
		
		else if (room.getRoomType().equalsIgnoreCase("non-ICU") && roomType.getNonicuQuantity() > 0) 
		{
			flashMap.addFlashAttribute("message", roomService.registerRoom(room, patient));
			roomTypeService.updateNonICURoom(hospital);
			return "redirect:/hospital/welcome";
		} 
		
		else if (room.getRoomType().equalsIgnoreCase("General") && roomType.getGeneralQuantity() > 0) 
		{
			flashMap.addFlashAttribute("message", roomService.registerRoom(room, patient));
			roomTypeService.updateGeneralRoom(hospital);
			return "redirect:/hospital/welcome";
		} 
		
		else 
		{
			flashMap.addFlashAttribute("message", "Room Not Available");
			return "redirect:/room/allocate";
		}
	}

	@GetMapping("/deallocate")
	public String deallocateRoom(HttpSession session, RedirectAttributes flashMap) {
		Hospital hospital = (Hospital) session.getAttribute("hospital_details");
		Patient p = (Patient) session.getAttribute("patient_details");
		Room r = roomService.findByPatientID(p);
		if (r.getRoomType().equalsIgnoreCase("ICU")) {
			roomTypeService.updateICURoomDeallocation(hospital);
		} else if (r.getRoomType().equalsIgnoreCase("non-ICU")) {
			roomTypeService.updateNonICURoomDeallocation(hospital);
		} else {
			roomTypeService.updateGeneralRoomDeallocation(hospital);
		}
		flashMap.addFlashAttribute("message", "Patient de-allocate the room  with id--> " + r.getRoomID());
		return "/bill/generatedbill";
	}
}
