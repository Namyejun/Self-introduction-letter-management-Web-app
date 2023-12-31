package com.yejun.app.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Announcement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToMany(mappedBy = "announcement", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@OrderBy("questionNum asc")
	private List<Question> questionList;
	
	@Column(nullable = false, length = 60)
	private String companyName;
	
	@Column(nullable = false, length = 100)
	private String announcementName;
	
	@Column(nullable = false, length = 40)
	private String job;
	
	@Column(nullable = true)
	private Date startDate;
	
	@Column(nullable = false)
	private Date endDate;
	
	@Column(nullable = false, columnDefinition = "bool default false")
	private Boolean submit;
	
	@Enumerated(EnumType.STRING)
	private AnnouncementResult result;
}
