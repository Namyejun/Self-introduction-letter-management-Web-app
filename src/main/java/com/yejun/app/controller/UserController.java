package com.yejun.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yejun.app.domain.OAuthType;
import com.yejun.app.domain.User;
import com.yejun.app.dto.ResponseDTO;
import com.yejun.app.dto.UserDTO;
import com.yejun.app.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public String login(@RequestBody User user, HttpSession session) {
		User findUser = userService.getUser(user.getUserId());
		if (findUser.getUserId() == null) {
			return "login";
		} else {
			if (user.getPw().equals(findUser.getPw())) {
				session.setAttribute("principal", user);
				return "redirect:/";
			} else {
				return "login";
			}
		}
	}
	
	@PostMapping("/insertUser")
	public @ResponseBody ResponseDTO<?> insertUser(@Valid @RequestBody UserDTO userdto, BindingResult bindingResult) {
		User user = modelMapper.map(userdto, User.class);
		User findUser = userService.getUser(user.getUserId());
		if (findUser.getUserId() == null) {
			userService.insertUser(user);
			return new ResponseDTO<>(HttpStatus.OK.value(), user.getName() + "님 회원가입 됐습니다.");
		} else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getName() + "님 이미 아이디가 존재합니다.");
		}
	}
	
	// 유저 업데이트 페이지에 id를 숨겨 놔야 할 거 같네.
	@PutMapping("/updateUser")
	public @ResponseBody ResponseDTO<?> updateUser(@Valid @RequestBody UserDTO userdto, BindingResult bindingResult, HttpSession session) {
		User principal = (User) session.getAttribute("principal");
		User user = modelMapper.map(userdto, User.class);
		if (principal.getOauth() == OAuthType.DEFAULT) {
			principal = userService.updateUser(user, OAuthType.DEFAULT);
		} else {
			principal = userService.updateUser(user, OAuthType.KAKAO);
		}
		session.setAttribute("principal", principal);
		return new ResponseDTO<>(HttpStatus.OK.value(), "업데이트 완료");
	}
}
