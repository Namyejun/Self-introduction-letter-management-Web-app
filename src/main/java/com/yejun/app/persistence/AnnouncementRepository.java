package com.yejun.app.persistence;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yejun.app.domain.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
	List<Announcement> findByEndDateAfterOrderByEndDateAsc(Timestamp date);
	List<Announcement> findAllOrderByIdDesc();
	List<Announcement> findByCompanyName(String companyName);
	List<Announcement> findByAnnouncementName(String announcementName);
	List<Announcement> findByJob(String job);
}
