package com.yejun.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yejun.app.domain.Question;
import com.yejun.app.persistence.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Transactional
	public void insertQuestion(Question question) {
		questionRepository.save(question);
	}
	
	@Transactional
	public void updateQuestion(Question question) {
		Question findQuestion = questionRepository.findById(question.getId()).get();
		findQuestion.setQuestion(question.getQuestion());
	}
	
	@Transactional
	public void updateAnswer(Question question) {
		Question findQuestion = questionRepository.findById(question.getId()).get();
		findQuestion.setAnswer(question.getAnswer());
	}
	
	@Transactional(readOnly = true)
	public List<Question> getQuestionListByKeyword(String keyword) {
		List<Question> questionList = questionRepository.findByQuestionOrAnswerContaining(keyword, keyword);
		return questionList;
	}
}
