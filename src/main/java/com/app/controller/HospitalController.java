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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Hospital;
import com.app.service.IHospitalService;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
	public HospitalController() {
		System.out.println("In Constructor of --> " + getClass().getName());
	}

	@Autowired
	private IHospitalService hospitalService;

	// USER--> HOSPITAL
	@GetMapping("/login")
	public String showHospitalLoginPage() {
		System.out.println("In Hospital Admin Login Page");
		return "/hospital/login";
	}

	@PostMapping("/login")
	public String processHospitalLoginForm(@RequestParam String hospital_id, @RequestParam String password,
			RedirectAttributes flashMap, HttpSession session) {
		System.out.println("In Hospital Admin Login Form--> " + hospital_id + " " + password);
		Hospital hospital = hospitalService.findByHospitalAdminIDAndHospitalAdminPassword(hospital_id, password);
		if (hospital == null) {
//			map.addAttribute("message", "Invalid Hospital Data");
			flashMap.addFlashAttribute("message", "Invalid Hospital Data");
			return "redirect:/hospital/login";
		}
		session.setAttribute("hospital_details", hospital);
		return "redirect:/hospital/welcome";
	}

	@GetMapping("/welcome")
	public String getHospitalWelcomePage() {
		System.out.println("Showing Hospital Welcome Page");
		return "/hospital/welcome";
	}

	@GetMapping("/register")
	public String showHospitalRegistrationForm(Model map) {
		System.out.println("In Hospital Registration form--> ");
		map.addAttribute("hospital", new Hospital());
		return "/hospital/register";
	}

	@PostMapping("/register")
	public String processHospitalRegistrationForm(@Valid Hospital hospital, BindingResult result,
			RedirectAttributes flashMap, HttpSession session) {
		System.out.println("In process new Hospital reg form--> " + hospital);
		System.out.println("Binding Result--> " + result);
		if (result.hasErrors()) {
			System.out.println("P.L Error");
			return "/hospital/register";
		}
		session.setAttribute("newhospital", hospital);
		flashMap.addFlashAttribute("message", hospitalService.registerHospital(hospital));
		return "redirect:/roomtype/form";

	}

	@GetMapping("/logout")
	public String showLogoutPage(HttpSession session) {
		System.out.println("In Hospital Logot Page");
		session.invalidate();
		return "/hospital/logout";
	}

	@GetMapping("/delete")
	public String deleteHospital(@RequestParam String vhid, RedirectAttributes flashMap) {
		System.out.println("In Hospital Delete Method with Hopsital Admin ID--> " + vhid);
		flashMap.addFlashAttribute("message", hospitalService.deleteHospital(vhid));
		return "redirect:/admin/welcome";
	}

}
