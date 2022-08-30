package com.bookservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.entity.Book;
import com.bookservice.service.BookService;

@RestController
@RequestMapping("/bookservice")
public class BookController {

	@Autowired
	BookService bookservice;

	@PostMapping("/create")
	Integer saveBook(@RequestBody Book book) {

		bookservice.saveBook(book);

		return book.getId();
	}

	@PostMapping("/create/author/{authorId}")
	Integer saveBook1(@RequestBody Book book, @PathVariable("authorId") Integer id) {

		bookservice.saveBook(book);

		return book.getId();
	}

	@GetMapping("/search/category/{category}/price/{price}/publisher/{publisher}")
	List<Book> getBooks(@PathVariable("category") String category, @PathVariable("price") Double price,
			@PathVariable("publisher") String publisher) {
		List<Book> list = new ArrayList<>();

		return list;

	}

}
