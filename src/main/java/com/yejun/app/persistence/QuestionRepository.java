package com.yejun.app.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yejun.app.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
}
