package com.yejun.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ViewController {
	
	@GetMapping({"", "/"})
	public String indexView(HttpServletRequest request) {
		return "index";
	}
	
	@GetMapping("/view/login")
	public String loginView() {
		return "/system/login";
	}
	
	@GetMapping("/view/insertUser")
	public String insertUserView() {
		return "/system/insertUser";
	}
	
	@GetMapping("/view/updateUser")
	public String updateUserView() {
		return "/system/updateUser";
	}
	
	@GetMapping("/view/insertAnnouncement")
	public String insertAnnouncementView() {
		return "/announcement/insertAnnouncement";
	}
	
	@GetMapping("/view/insertQuestion")
	public String insertQuestionView() {
		return "/question/insertQuestion";
	}
}
