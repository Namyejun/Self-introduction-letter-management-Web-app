package com.yejun.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ViewController {
	
	@GetMapping("/hi")
	public String hi() {
		return "hi"; 
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello"; 
	}
	
	@GetMapping({"", "/"})
	public String indexView(HttpServletRequest request) {
		System.out.println(request.getRequestURL());
		return "index";
	}
	
	@GetMapping("/view/login")
	public String loginView() {
		return "/system/login";
	}
}
