package com.question.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.question.entity.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

}
