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
import com.app.pojos.RoomType;
import com.app.service.IRoomTypeService;

@Controller
@RequestMapping("/roomtype")
public class RoomTypeController {

	@Autowired
	private IRoomTypeService roomTypeService;

	public RoomTypeController() {
		System.out.println("In default Constructor of--> " + getClass().getName());
	}

	@GetMapping("/form")
	public String showRoomTypeForm(Model map) {
		System.out.println("In show room type form");
		map.addAttribute("roomtype", new RoomType());
		return "/roomtype/form";
	}

	@PostMapping("/form")
	public String processRoomTypeForm(@Valid RoomType roomType, BindingResult result, RedirectAttributes flashMap,
			HttpSession session) {
		System.out.println("In process Room Type --> " + roomType);
		System.out.println("Binding Result--> " + result);
		if (result.hasErrors()) {
			System.out.println("P.L Errors");
			return "/roomtype/form";
		}
		Hospital hospital = (Hospital) session.getAttribute("newhospital");
		flashMap.addFlashAttribute("message", roomTypeService.registerRoomType(hospital, roomType));
		return "redirect:/hospital/login";
	}

}
