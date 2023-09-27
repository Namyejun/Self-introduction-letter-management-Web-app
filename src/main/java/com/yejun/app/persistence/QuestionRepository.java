package com.yejun.app.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yejun.app.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	List<Question> findByTitleOrAnswerContaining(String keyword1, String keyword2); // keyword 2개여야함 or 붙으면
}
