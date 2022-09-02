package com.bookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.entity.Book;
import com.bookservice.entity.Reader;
import com.bookservice.requestentity.Cbook;
import com.bookservice.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookservice;

	@PostMapping("/create")
	Integer saveBook(@RequestBody Cbook book) {

		bookservice.saveBook(book);

		return book.getId();
	}

	@PostMapping("/create/author/{authorId}")
	Integer saveBook1(@RequestBody Book book, @PathVariable("authorId") Integer id) {

		// bookservice.saveBook(book);

		return book.getId();
	}

	// @GetMapping("/search/category/{category}/price/{price}/publisher/{publisher}")
	// List<Sbook> getBooks(@PathVariable("category") String category,
	// @PathVariable("price") Double price,
	// @PathVariable("publisher") String publisher) {

	// List<Sbook> list = bookservice.getBooks(publisher, price, publisher);

	// return list;

	@PostMapping("/create/reader")
	Integer saveUser(@RequestBody Reader reader) {
		Integer id = bookservice.saveUser(reader);

		return id;

	}

}
