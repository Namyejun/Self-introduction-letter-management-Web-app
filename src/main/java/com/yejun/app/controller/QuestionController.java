package com.yejun.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yejun.app.domain.Question;
import com.yejun.app.dto.QuestionDTO;
import com.yejun.app.dto.ResponseDTO;
import com.yejun.app.service.QuestionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/question")
public class QuestionController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private QuestionService questionService;
	
	public @ResponseBody ResponseDTO<?> insertQuestion(@Valid @RequestBody QuestionDTO questionDTO, BindingResult bindingResult) {
		Question question = modelMapper.map(questionDTO, Question.class);
		questionService.insertQuestion(question);
		return new ResponseDTO<>(HttpStatus.OK.value(), "문항 입력 완료");
	}
	
	@PutMapping("/updateQuestion")
	public @ResponseBody ResponseDTO<?> updateQuestion(@Valid @RequestBody QuestionDTO questionDTO, BindingResult bindingResult) {
		 Question question = modelMapper.map(questionDTO, Question.class);
		 questionService.updateQuestion(question);
		 return new ResponseDTO<>(HttpStatus.OK.value(), "문항 업데이트 완료");
	}
	
	
}
