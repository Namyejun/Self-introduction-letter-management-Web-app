package com.yejun.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yejun.app.domain.Announcement;
import com.yejun.app.domain.AnnouncementResult;
import com.yejun.app.domain.User;
import com.yejun.app.dto.AnnouncementDTO;
import com.yejun.app.dto.ResponseDTO;
import com.yejun.app.service.AnnouncementService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/announcement")
public class AnnouncementController {
	@Autowired
	private AnnouncementService announcementService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/insert")
	public @ResponseBody ResponseDTO<?> insertAnnouncement(@Valid @RequestBody AnnouncementDTO announcementDTO, BindingResult bindingResult, HttpSession session) {
		Announcement announcement = modelMapper.map(announcementDTO, Announcement.class);
		announcement.setSubmit(false);
		announcement.setResult(AnnouncementResult.서류탈락);
		User principal = (User) session.getAttribute("principal");
		announcement.setUser(principal);
		announcementService.insertAnnouncement(announcement);
		return new ResponseDTO<>(HttpStatus.OK.value(), announcement.getAnnouncementName() + "공고를 등록했습니다.");
	}
	
	@PutMapping("/update")
	public @ResponseBody ResponseDTO<?> updateAnnouncement(@Valid @RequestBody AnnouncementDTO announcementDTO, BindingResult bindingResult) {
		Announcement announcement = modelMapper.map(announcementDTO, Announcement.class);
		announcementService.updateAnnouncement(announcement);
		return new ResponseDTO<>(HttpStatus.OK.value(), announcement.getAnnouncementName() + "공고를 변경했습니다.");
	}
	
	@PutMapping("/submit/{id}")
	public @ResponseBody ResponseDTO<?> updateSubmit(@PathVariable int id) {
		announcementService.updateSubmit(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "제출 상태 변경 완료");
	}
}
