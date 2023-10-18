package com.yejun.app.persistence;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yejun.app.domain.Announcement;
import com.yejun.app.domain.User;

// 생각해보면 모든 검색에 User가 같이 들어가줘야 함. 근데 이걸 여기서 처리해야 하나? 그냥 user에 딸려있는 애들을 정렬하는게 낫지 않나?
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
//	List<Announcement> findByEndDateAfterAndUserOrderByEndDateAsc(Timestamp date, User user);
//	List<Announcement> findAllByUserOrderById();  // AllBy 써줘야함
//	List<Announcement> findByCompanyNameAndUser(String companyName);
//	List<Announcement> findByAnnouncementNameAndUser(String announcementName);
//	List<Announcement> findByJobAndUser(String job);
	Page<Announcement> findByUserOrderByEndDateDesc(User user, Pageable pageable);
}