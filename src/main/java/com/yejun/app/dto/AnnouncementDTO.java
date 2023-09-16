package com.yejun.app.dto;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDTO {
	private int id;
	
	@NotNull(message = "회사명이 전달되지 않았습니다.")
	@NotBlank(message = "회사명은 필수 입력 항목입니다.")
	@Size(min = 1, max = 20, message = "회사명은 한 글자 이상 20자 미만으로 입력하세요.")
	private String companyName;
	
	@NotNull(message = "공고명이 전달되지 않았습니다.")
	@NotBlank(message = "공고명은 필수 입력 항목입니다.")
	@Size(min = 1, max = 20, message = "공고명은 한 글자 이상 30자 미만으로 입력하세요.")
	private String announcementName;
	
	
	@NotNull(message = "직무가 전달되지 않았습니다.")
	@NotBlank(message = "직무는 필수 입력 항목입니다.")
	@Size(min = 1, max = 20, message = "직무는 한 글자 이상 10자 미만으로 입력하세요.")
	private String job;
	
	@NotNull(message = "종료일이 전달되지 않았습니다.")
	@NotBlank(message = "종료일은 필수 입력 항목입니다.")
	private Timestamp endDate;
}
