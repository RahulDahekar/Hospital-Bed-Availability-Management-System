package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Hospital;
import com.app.service.IHospitalService;
import com.app.service.IRoomTypeService;

@Controller
@RequestMapping("/user")
public class UserController {

	public UserController() {
		System.out.println("In constructor of--> " + getClass().getName());
	}

	@Autowired
	private IHospitalService hospitalService;

	@Autowired
	private IRoomTypeService roomTypeService;

	// USER--> END-USER
	@GetMapping("/enduserlist")
	public String showEndUserList() {
		System.out.println("In End User Hospital List Page");
		return "/user/enduserlist";
	}

	@PostMapping("/enduserlist")
	public String processEndUserList(@RequestParam String city, RedirectAttributes flashMap, HttpSession session) {
		System.out.println("In show hospital list of city--> " + city);
		List<Hospital> hospital = hospitalService.getHospitalByCity(city);
		if (hospital == null) {
			flashMap.addFlashAttribute("message", "No Hospital Available");
			return "redirect:/user/enduserlist";
		}
		session.setAttribute("hospital_list", hospitalService.getHospitalByCity(city));
		return "redirect:/user/enduserlist";
	}

	@GetMapping("/bedlist")
	public String showBedList(@RequestParam Hospital hid, HttpSession session) {
		System.out.println("In Show Beds list");

//		RoomType roomTypeList =(RoomType)roomTypeService.showBedList(hospitalId);
		session.setAttribute("room_details", roomTypeService.showBedList(hid));
		return "/user/bedlist";
	}
}
