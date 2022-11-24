package com.answer.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.answer.entity.Question;
import com.answer.entity.User;

@Service
@FeignClient("QUESTION")
public interface FeignService {

	@GetMapping("QU/user/id/{id}")
	public User getUserById(@PathVariable Integer id);

	@GetMapping("QU/question/id/{id}")
	public Question getQuestionById(@PathVariable Integer id);
}
