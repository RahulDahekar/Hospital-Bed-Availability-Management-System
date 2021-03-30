package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Hospital;
import com.app.pojos.Patient;
import com.app.pojos.Room;
import com.app.pojos.RoomType;
import com.app.service.IBillService;
import com.app.service.IPatientService;
import com.app.service.IRoomService;
import com.app.service.IRoomTypeService;

@Controller
@RequestMapping("/bill")
public class BillController {
	public BillController() {
		System.out.println("In Default Constructor of--> " + getClass().getName());
	}

	@Autowired
	private IPatientService patientService;

	

	@GetMapping("/generatedbill")
	public String dischargePatient(@RequestParam int vpid, HttpSession session) {
		System.out.println("In Discharge Patient");
		Patient patient = patientService.findPatientByID(vpid);
		 if(patient != null) {
			 session.setAttribute("singlepatient_details", patient);
			 return "redirect:/patient/discharge";
		 }
			session.getAttribute("bill_details");	
		return "/bill/generatedbill";
	}
}
