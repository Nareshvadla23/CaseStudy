package com.bookservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.dto.LoginDto;
import com.bookservice.dto.RequestDto;
import com.bookservice.dto.ResponseDto;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;
import com.bookservice.service.BookService;

@CrossOrigin
@RestController
public class BookController {
	@Autowired 
	private BookService bookService;

	@PostMapping("/book")
	public Integer createBook(@RequestBody RequestDto book) {
		Integer id = bookService.savebook(book);
		return id;
	}

	@PutMapping("/book/{bookId}")
	public Book updateBook(@RequestBody RequestDto requestDto, @PathVariable Integer bookId) {
		Book book = bookService.updateBook(requestDto, bookId);
		return book;
	}

	@PostMapping("/author")
	public Integer saveAuthor(@Valid @RequestBody Author author) {
		Integer id = bookService.saveAuthor(author);
		return id;
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginAuthor(@Valid @RequestBody LoginDto login) {
		Author author = bookService.loginAuthor(login);
		if (author.getPassword().equals(login.getPassword())) {
			return ResponseEntity.ok(author);
		} else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}

	@GetMapping("/ByAuthorId/{authorId}")
	public List<ResponseDto> getByAuthorId(@PathVariable Integer authorId) {
		return bookService.BooksbyAuthorId(authorId);
	}

}
