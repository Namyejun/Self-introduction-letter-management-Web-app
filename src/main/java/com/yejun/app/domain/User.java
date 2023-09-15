package com.yejun.app.domain;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 20)
	private String name;
	
	@Column(nullable = false, length = 50, unique = true)
	private String userId;
	
	@Column(nullable = false, length = 100)
	private String pw;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	@Enumerated(EnumType.STRING)
	private OAuthType oauth;
}
