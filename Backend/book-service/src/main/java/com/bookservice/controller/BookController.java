package com.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.dto.RequestDto;
import com.bookservice.dto.ResponseDto;
import com.bookservice.entity.Book;
import com.bookservice.service.BookService;

@CrossOrigin
@RestController
@RequestMapping("/digitalbooks")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/book")
	public Integer createBook(@RequestBody RequestDto book) {
		return bookService.savebook(book);
	}

	@PutMapping("/book/{bookId}")
	public Book updateBook(@RequestBody RequestDto requestDto, @PathVariable Integer bookId) {
		return bookService.updateBook(requestDto, bookId);
	}

	@GetMapping("/ByAuthorId/{authorId}")
	public List<ResponseDto> getByAuthorId(@PathVariable Integer authorId) {
		return bookService.BooksbyAuthorId(authorId);
	}

	@GetMapping("/ByBookId/{id}/mail/{authormail}")
	public RequestDto getByBookId(@PathVariable Integer id,@PathVariable String authorMail) throws Exception {
		return bookService.getbyBookId(id,authorMail);
	}

	@GetMapping("/ByAuthorMailId/{mail}")
	public List<ResponseDto> getByAuthorMail(@PathVariable String mail) {
		return bookService.BooksbyAuthorMail(mail); 
	}

}
