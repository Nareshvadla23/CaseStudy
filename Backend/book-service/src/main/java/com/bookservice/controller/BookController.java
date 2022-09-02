package com.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.entity.Author;
import com.bookservice.entity.Book;
import com.bookservice.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/savebook")
	public Integer savebook(@RequestBody Author auth) {
		return bookService.saveBooks(auth);
	}
	
	@GetMapping("/getAllBooks")
	public List<Author> getBooks() 
	{
		return bookService.getAllBooks(); 
	}
	
	

}
