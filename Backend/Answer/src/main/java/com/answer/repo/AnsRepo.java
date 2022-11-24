package com.answer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.answer.entity.Answer;

public interface AnsRepo extends JpaRepository<Answer, Integer> {

}
