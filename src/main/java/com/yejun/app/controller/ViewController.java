package com.yejun.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yejun.app.service.AnnouncementService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ViewController {
	
	@Autowired
	private AnnouncementService announcementService;
	
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
	
	@GetMapping("/view/insertQuestion/{id}")
	public String insertQuestionView(@PathVariable int id, Model model) {
		model.addAttribute("announcement", announcementService.getAnnouncement(id));
		return "/question/insertQuestion";
	}
	
	@GetMapping("/view/updateAnswer/{id}")
	public String updateAnswerView(@PathVariable int id, Model model) {
		model.addAttribute("announcement", announcementService.getAnnouncement(id));
		return "/question/updateAnswer";
	}
}
