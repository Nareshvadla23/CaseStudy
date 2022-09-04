package com.bookservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.entity.Author;
import com.bookservice.entity.RequestBook;
import com.bookservice.entity.ResponseBook;
import com.bookservice.entity.Mbook;
import com.bookservice.service.BookService;
import com.bookservice.service.ReaderService;

@CrossOrigin
@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@Autowired
	private ReaderService ReaderService;

	
	@PostMapping("/createbook")
	public Integer createBook(@RequestBody RequestBook book) {

		Integer id = bookService.SaveMbook(book);
		return id;
	}
 
	@PostMapping("/saveAuthor")
	public Integer saveAuthor(@RequestBody Author author) {
		Integer id = bookService.saveAuthor(author);

		return id; 
	}

	@GetMapping("/allbooks")
	public List<ResponseBook> getBooks() throws Exception {
		return ReaderService.getAllBooks();
	}

	
	@GetMapping("/ByPrice/{price}")
	public List<ResponseBook> getBooksByPrice(@PathVariable Double price) throws Exception
	{
		return ReaderService.getBookByPrice(price);
	}

}
