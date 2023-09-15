package com.yejun.app.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yejun.app.domain.Announcement;
import com.yejun.app.domain.AnnouncementResult;
import com.yejun.app.persistence.AnnouncementRepository;

@Service
public class AnnouncementService {
	
	@Autowired
	private AnnouncementRepository announcementRepository;
	
	@Transactional
	public void insertAnnouncement(Announcement announcement) {
		announcementRepository.save(announcement);
	}
	
	@Transactional
	public void updateAnnouncement(Announcement announcement) {
		Announcement findAnnouncement = announcementRepository.findById(announcement.getId()).get();
		findAnnouncement.setAnnouncementName(announcement.getAnnouncementName());
		findAnnouncement.setCompanyName(announcement.getCompanyName());
		findAnnouncement.setStartDate(announcement.getStartDate());
		findAnnouncement.setEndDate(announcement.getEndDate());
	}
	
	@Transactional
	public void updateSubmit(int id, boolean value) {
		Announcement findAnnouncement = announcementRepository.findById(id).get();
		findAnnouncement.setSubmit(value);
	}
	
	@Transactional
	public void updateResult(int id, AnnouncementResult result) {
		Announcement findAnnouncement = announcementRepository.findById(id).get();
		findAnnouncement.setResult(result);
	}
	
	@Transactional(readOnly = true)
	public List<Announcement> getUnterminatedAnnouncementList() {
		return announcementRepository.findByEndDateAfter(new Timestamp(System.currentTimeMillis()));
	}
	
	@Transactional(readOnly = true)
	public List<Announcement> getAnnouncementList() {
		return announcementRepository.findAllOrderById();
	}
	
	@Transactional(readOnly = true)
	public List<Announcement> getAnnouncementListByCompanyName(String companyName) {
		return announcementRepository.findByCompanyName(companyName);
	}
	
	@Transactional(readOnly = true)
	public List<Announcement> getAnnouncementListByAnnouncementName(String announcementName) {
		return announcementRepository.findByAnnouncementName(announcementName);
	}
	
	@Transactional(readOnly = true)
	public List<Announcement> getAnnouncementListByJob(String job) {
		return announcementRepository.findByJob(job);
	}
	
}
