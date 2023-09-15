package com.yejun.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private int id;
	
	@NotNull(message = "이름이 전달되지 않았습니다.")
	@NotBlank(message = "이름은 필수 입력 항목입니다.")
	@Size(min = 1, max = 20, message = "이름은 한 글자 이상 20자 미만으로 입력하세요.")
	private String name;
	
	@NotNull(message = "아이디가 전달되지 않았습니다.")
	@NotBlank(message = "아이디는 필수 입력 항목입니다.")
	@Size(min = 1, max = 20, message = "아이디는 한 글자 이상 20자 미만으로 입력하세요.")
	private String userId;
	
	@NotNull(message = "비밀번호가 전달되지 않았습니다.")
	@NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
	@Size(min = 1, max = 20, message = "비밀번호는 한 글자 이상 20자 미만으로 입력하세요.")
	private String pw;
	
	@NotNull(message = "이메일이 전달되지 않았습니다.")
	@NotBlank(message = "이메일은 필수 입력 항목입니다.")
	@Email(message = "이메일 형식이 아닙니다.")
	private String email;
}
