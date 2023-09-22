package com.yejun.app.dto;

import com.yejun.app.domain.Announcement;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
	private int id;
	
	@NotNull(message = "문항이 전달되지 않았습니다.")
	@NotBlank(message = "문항은 필수 입력 항목입니다.")
	private String question;
	
	@NotNull(message = "최대 글자수가 전달되지 않았습니다.")
	@NotBlank(message = "최대 글자수는 필수 입력 항목입니다.")
	private int maxLength;
	
	private String answer;
}
