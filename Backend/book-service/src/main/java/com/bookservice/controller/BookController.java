package com.bookservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.dto.LoginDto;
import com.bookservice.dto.RequestDto;
import com.bookservice.dto.ResponseDto;
import com.bookservice.entity.Author;
import com.bookservice.service.BookService;
import com.bookservice.service.ReaderService;

@CrossOrigin
@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@Autowired
	private ReaderService ReaderService;

	@PostMapping("/book")
	public Integer createBook(@RequestBody RequestDto book) {
		Integer id = bookService.savebook(book);
		return id;
	}

	@PostMapping("/author")
	public Integer saveAuthor(@Valid @RequestBody Author author) {
		Integer id = bookService.saveAuthor(author);
		return id;
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginAuthor(@Valid @RequestBody LoginDto login ) {
		Author author = bookService.loginAuthor(login);
		if (author.getPassword().equals(login.getPassword())) {
			return ResponseEntity.ok(author);
		} else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}

	@GetMapping("/books/all")
	public List<ResponseDto> getBooks() throws Exception {
		return ReaderService.getAllBooks();
	}

	@GetMapping("/books/byPrice/{price}")
	public List<ResponseDto> getBooksByPrice(@PathVariable Double price) throws Exception {
		return ReaderService.getBookByPrice(price);
	}

	@GetMapping("/books/byTitle/{title}")
	public List<ResponseDto> getBooksByTitle(@PathVariable String title) throws Exception {
		return ReaderService.getBookByTitle(title);
	}

	@GetMapping("/books/byCategory/{category}")
	public List<ResponseDto> getBooksByCategory(@PathVariable String category) throws Exception {
		return ReaderService.getBookByCategory(category);
	}

}
