package com.question.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.question.entity.Question;
import com.question.entity.User;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

	  public List<Question> findByUser(User user);
	  
}
