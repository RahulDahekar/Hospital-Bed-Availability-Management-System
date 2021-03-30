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
import com.app.service.IBillService;
import com.app.service.IPatientService;
import com.app.service.IRoomService;
import com.app.service.IRoomTypeService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private IPatientService patientService;

	@Autowired
	private IBillService billservice;

	@Autowired
	private IRoomTypeService roomTypeService;

	@Autowired
	private IRoomService roomService;

	@GetMapping("/register")
	public String getPatientRegistrationForm(Model map) {
		System.out.println("In patient registration form ");
		map.addAttribute("patient", new Patient());
		return "/patient/register";
	}

	@PostMapping("/register")
	public String processPatientRegistrationForm(@Valid Patient patient, BindingResult result,
			RedirectAttributes flashMap, HttpSession session) {
		System.out.println("In process patient reg. formof patient -->  " + patient);
		System.out.println("Binding Result--> " + result);
		if (result.hasErrors()) {
			System.out.println("P.L Errors");
			return "/patient/register";

		}

		Hospital hospital = (Hospital) session.getAttribute("hospital_details");
		session.setAttribute("patient_details", patient);
		patient.setStatus("Admitted");
		flashMap.addFlashAttribute("message", patientService.registerPatient(patient, hospital));
		return "redirect:/room/allocate";

	}

	@GetMapping("/admittedlist")
	public String showAdmittedPatientList(HttpSession session) {

		Hospital hospital = (Hospital) session.getAttribute("hospital_details");
		session.setAttribute("patient_list", patientService.getAllPatientByHospitalIDAndStatus(hospital, "Admitted"));
		return "/patient/admittedlist";

	}

	@GetMapping("/dischargedlist")
	public String showDischargedPatientList(HttpSession session) {

		Hospital hospital = (Hospital) session.getAttribute("hospital_details");

		session.setAttribute("patient_list", patientService.getAllPatientByHospitalIDAndStatus(hospital, "Discharged"));
		return "/patient/dischargedlist";
	}

	@GetMapping("/discharge")
	public String initiateDischargeProcess(HttpSession session) {

		Patient patient = (Patient) session.getAttribute("singlepatient_details");
		Hospital hospital = (Hospital) session.getAttribute("hospital_details");
		RoomType roomType = roomTypeService.findRoomTypeByHospitalId(hospital);
		Room room = roomService.findByPatientID(patient);

		patientService.updateStatus(patient.getPatientID());
		session.setAttribute("patient_details", patient);
		session.setAttribute("bill_details", billservice.saveBill(patient, room, roomType));
		
		return "redirect:/room/deallocate";
	}

}
