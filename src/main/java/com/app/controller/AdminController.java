package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Admin;
import com.app.service.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	public AdminController() {
		System.out.println("In Constructor of--> " + getClass().getName());
	}

	@Autowired
	private IAdminService adminService;

	@GetMapping("/login")
	public String showAdminLoginPage() {
		System.out.println("In Admin Login Page");
		return "/admin/login";
	}

	@PostMapping("/login")
	public String processAdminLoginForm(@RequestParam String user_name, @RequestParam String password,
			RedirectAttributes flashMap, HttpSession session) {

		System.out.println("In Process Admin login form--> " + user_name + " " + password);
		Admin admin = adminService.authenticateAdmin(user_name, password);
		if (admin == null) {
			flashMap.addFlashAttribute("message", "Invalid Admin Details. Please Retry...");
			return "redirect:/admin/login";
		}
		session.setAttribute("admin_details", admin);
		return "redirect:/admin/welcome";
	}

	@GetMapping("/welcome")
	public String getAdminWelcomePage(Model map, HttpSession session) {
		System.out.println("Admin logged in successfully");
		System.out.println("In Admin Welcome Page");
		session.getAttribute("admin_details");
		map.addAttribute("hospital_list", adminService.getAllHospitalList());
		return "/admin/welcome";
	}

	@GetMapping("/logout")
	public String showLogoutPage(HttpSession session) {
		System.out.println("In Logout Page");
		session.getAttribute("admin_details");
		session.invalidate();
		return "/admin/logout";
	}

}
