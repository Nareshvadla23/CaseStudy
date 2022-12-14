package com.bookservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bookservice.dto.Category;
import com.bookservice.dto.LoginDto;
import com.bookservice.dto.RequestDto;
import com.bookservice.dto.ResponseDto;
import com.bookservice.dto.Status;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;
import com.bookservice.service.BookService;
import com.bookservice.service.ReaderService;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

	@Mock
	BookService service;

	@Mock
	ReaderService Rservice;

	@Mock
	PasswordEncoder encoder;

	@InjectMocks
	BookController control;
	@InjectMocks
	ReaderController readerController;

	public static Author author() {
		Author author = new Author();
		author.setId(1);
		author.setMailId("naresh@gmail.com");
		author.setName("naresh");
		author.setPassword("naresh@23");
		return author;
	}

	public static RequestDto requestBook() {
		RequestDto book = new RequestDto();
		book.setAuthor("Naresh");
		book.setCategory(Category.COMIC);
		book.setContent("Asia cup");
		book.setId(1);
		book.setImage("image1");
		book.setPrice(2000d);

		book.setPublishedDate(LocalDate.now());
		book.setPublisher("BCCI");
		book.setStatus(Status.ACTIVE);
		book.setTitle("cricket");
		return book;
	}

	public static Book book() {
		Book book = new Book();
		Author auth = author();
		book.setAuthor(auth);
		book.setCategory(Category.COMIC);
		book.setContent("Asia cup");
		book.setId(1);
		book.setImage("image1");
		book.setPrice(2000d);
		book.setPublishedDate(LocalDate.now());
		book.setPublisher("BCCI");
		book.setStatus(Status.ACTIVE);
		book.setTitle("cricket");
		return book;
	}

	public static List<Book> books() {

		List<Book> books = new ArrayList<>();
		books.add(book());
		return books;
	}

	public static List<ResponseDto> responsebooks() {
		List<ResponseDto> responseBooks = new ArrayList<>();
		Author author = author();
		for (Book book : books()) {
			ResponseDto responseBook = new ResponseDto();
			responseBook.setCategory(book.getCategory());
			responseBook.setPrice(book.getPrice());
			responseBook.setPublishedDate(book.getPublishedDate());
			responseBook.setPublisher(book.getPublisher());
			responseBook.setTitle(book.getTitle());
			responseBook.setImage(book.getImage());
			responseBook.setAuthor(author.getName());
			responseBooks.add(responseBook);
		}
		return responseBooks;
	}

	@Test
	void testCreateBook() {
		RequestDto book = requestBook();
		when(service.savebook(book)).thenReturn(book.getId());
		Integer id = control.createBook(book);
		assertEquals(1, id);
	}

	@Test
	void testUpdateBook() {
		RequestDto requestDto = requestBook();
		Book book = book();
		when(service.updateBook(requestDto, 1)).thenReturn(book());
		Book book1 = control.updateBook(requestDto, 1);
		assertEquals(1, book1.getId());
	}

	@Test
	void testGetByAuthorId() {
		List<ResponseDto> responseDtos = responsebooks();
		when(service.BooksbyAuthorId(1)).thenReturn(responseDtos);
		List<ResponseDto> books = control.getByAuthorId(1);
		assertEquals(1, books.size());
	}

	@Test
	void testGetByBookId() throws Exception {
		RequestDto requestDto = requestBook();
		when(service.getbyBookId(1, "naresh@gmail.com")).thenReturn(requestDto);
		RequestDto book = control.getByBookId(1,"naresh@gmail.com");
		assertEquals(1, book.getId()); 
	}

	@Test
	void testGetByAuthorMail() {
		List<ResponseDto> responseDtos = responsebooks();
		when(service.BooksbyAuthorMail("naresh@gmail.com")).thenReturn(responseDtos);
		List<ResponseDto> books = control.getByAuthorMail("naresh@gmail.com");
		assertEquals(1, books.size());
	}

}
