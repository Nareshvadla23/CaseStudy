package com.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.answer.dto.AnswerDto;
import com.answer.entity.Answer;
import com.answer.entity.Question;
import com.answer.entity.User;
import com.answer.repo.AnsRepo;
import com.answer.util.FeignService;

@RestController
@RequestMapping("/QU")
public class AnsController {

	@Autowired
	public AnsRepo arepo;

	@Autowired
	public FeignService service;

	@PostMapping("/answer")
	public Answer addAnswer(@RequestBody AnswerDto answer) {
		Question q = service.getQuestionById(answer.getQuestionId());
		User u = service.getUserById(answer.getUserId());
		Answer ans = new Answer();
		ans.setAnswerz(answer.getAnswer());
		ans.setQuestion(q);
		ans.setUser(u);
		return arepo.save(ans);

	}

}
