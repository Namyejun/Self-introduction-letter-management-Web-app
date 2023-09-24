package com.yejun.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/insert")
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
	
	@PutMapping("/updateAnswer")
	public @ResponseBody ResponseDTO<?> updateAnswer(@RequestBody Question question) {
		 questionService.updateAnswer(question);
		 return new ResponseDTO<>(HttpStatus.OK.value(), "답변 업데이트 완료");
	}
	
	@GetMapping("/get")
	public @ResponseBody ResponseDTO<?> getQuestionListByKeyword(@RequestParam("keyword") String keyword, Model model) {
		List<Question> questions = questionService.getQuestionListByKeyword(keyword);
		model.addAttribute("questions", questions);
		return new ResponseDTO<>(HttpStatus.OK.value(), "검색 완료");
	}
	
}
