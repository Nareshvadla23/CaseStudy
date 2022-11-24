package com.question.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.Dto.QuestionUserDto;
import com.question.entity.Question;
import com.question.entity.User;
import com.question.repo.QuestionRepo;
import com.question.repo.UserRepo;

@RestController
@RequestMapping("/QU")
public class QuestionController {

	@Autowired
	QuestionRepo qrepo;

	@Autowired
	UserRepo urepo;

	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return urepo.save(user);
	}
	
	

	@PostMapping("/question")
	public Question addQuestion(@RequestBody QuestionUserDto question) {

		Question q1 = new Question();
		Optional<User> ou = urepo.findById(question.getUserId());
		User u1 = ou.get();
		q1.setDescription(question.getDescription());
		q1.setTitle(question.getTitle());
		q1.setUser(u1);
		return qrepo.save(q1);
	}

	@GetMapping("/questions")
	public List<Question> getQuestions() {
		return qrepo.findAll();
	}

	@GetMapping("/user/id/{id}")
	public User getUserById(@PathVariable Integer id) {
		return urepo.findById(id).get();
	}

	@GetMapping("/question/id/{id}")
	public Question getQuestionById(@PathVariable Integer id) {
		return qrepo.findById(id).get();
	}

}
