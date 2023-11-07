package com.yejun.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yejun.app.domain.Announcement;
import com.yejun.app.domain.User;
import com.yejun.app.service.AnnouncementService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ViewController {
	
	@Autowired
	private AnnouncementService announcementService;
	
	@GetMapping({"", "/"})
	public String indexView(HttpServletRequest request, HttpSession session, Model model, @PageableDefault(size = 10) Pageable pageable) {
		User principal = (User) session.getAttribute("principal");
		if (principal != null) {
			model.addAttribute("announcementList", announcementService.getAnnouncementByUserOrderByEndDate(principal, pageable));
		}
		return "index";
	}
	
	@GetMapping("/view/insertUser")
	public String insertUserView() {
		return "/user/insertUser";
	}
	
	@GetMapping("/view/login")
	public String loginView() {
		return "/system/login";
	}
	
	@GetMapping("/view/insertAnnouncement")
	public String insertAnnouncementView(HttpSession session) {
		if (session.getAttribute("principal") == null) { // 급한대로 그냥 권한 설정
			return "/";
		}
		return "/announcement/insertAnnouncement";
	}
	
	@GetMapping("/view/updateUser")
	public String updateUserView(HttpSession session) {
		return "/user/updateUser";
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
