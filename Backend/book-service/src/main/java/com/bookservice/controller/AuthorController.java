package com.bookservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.AuthorRepository;
import com.bookservice.dto.LoginDto;
import com.bookservice.entity.Author;
import com.bookservice.service.BookService;

@CrossOrigin
@RestController
@RequestMapping("/digitalbooks")
public class AuthorController {
	@Autowired
	private BookService bookService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorRepository authorRepository;

	@PostMapping("/login")
	public ResponseEntity<?> loginAuthor(@Valid @RequestBody LoginDto login) {
		Author author = bookService.loginAuthor(login);
		if (passwordEncoder.matches(login.getPassword(), author.getPassword())) {
			return ResponseEntity.ok(author);
		} else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}
 
	@PostMapping("/author")
	public ResponseEntity<?> saveAuthor(@Valid @RequestBody Author author) {
		if (authorRepository.findByMailId(author.getMailId()) == null) {
			String password = passwordEncoder.encode(author.getPassword());
			Author auth = new Author();
			auth.setMailId(author.getMailId());
			auth.setName(author.getName());
			auth.setPassword(password);
			Author author1 = bookService.saveAuthor(auth);
			return ResponseEntity.ok(author1);
		}else
		{
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}

}
