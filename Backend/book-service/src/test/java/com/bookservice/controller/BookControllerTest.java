package com.bookservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.bookservice.dto.LoginDto;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;
import com.bookservice.entity.RequestBook;
import com.bookservice.entity.ResponseBook;
import com.bookservice.service.BookService;
import com.bookservice.service.ReaderService;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

	@Mock
	BookService service;

	@Mock
	ReaderService Rservice;

	@InjectMocks
	BookController control;

	public static Author author() {
		Author author = new Author();
		author.setId(1);
		author.setMailId("naresh@gmail.com");
		author.setName("naresh");
		author.setPassword("naresh@23");
		return author;
	}

	public static RequestBook requestBook() {
		RequestBook book = new RequestBook();
		book.setAuthor("Naresh");
		book.setCategory("sports");
		book.setContent("Asia cup");
		book.setId(1);
		book.setImage("image1");
		book.setPrice(2000d);
		Date date = new Date(2000, 12, 12);
		book.setPublishedDate(date);
		book.setPublisher("BCCI");
		book.setStatus(true);
		book.setTitle("cricket");
		return book;
	}

	public static List<Book> books() {
		Book book = new Book();
		Author auth = author();
		book.setAuthor(auth);
		book.setCategory("sports");
		book.setContent("Asia cup");
		book.setId(1);
		book.setImage("image1");
		book.setPrice(2000d);
		Date date = new Date(2000, 12, 12);
		book.setPublishedDate(date);
		book.setPublisher("BCCI");
		book.setStatus(true);
		book.setTitle("cricket");
		List<Book> books = new ArrayList<>();
		books.add(book);
		return books;
	}

	public static List<ResponseBook> responsebooks() {
		List<ResponseBook> responseBooks = new ArrayList<>();
		Author author = author();
		for (Book book : books()) {
			ResponseBook responseBook = new ResponseBook();
			responseBook.setCategory(book.getCategory());
			responseBook.setPrice(book.getPrice());
			responseBook.setPublisherDate(book.getPublishedDate());
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
		RequestBook book = requestBook();
		when(service.savebook(book)).thenReturn(book.getId());
		Integer id = control.createBook(book);
		assertEquals(1, id);
	}

	@Test
	void testLoginAuthor() {
		Author author = author();
		LoginDto login = new LoginDto();
		login.setMailId("naresh@gmail.com");
		login.setPassword("naresh@23");
		when(service.loginAuthor(login)).thenReturn(author);
		ResponseEntity<?> response = control.loginAuthor(login);
		assertEquals(ResponseEntity.ok(author), response);
	}

	@Test
	void testSaveAuthor() {
		Author author = author();
		when(service.saveAuthor(author)).thenReturn(author.getId());
		Integer id = control.saveAuthor(author);
		assertEquals(1, id);
	}

	@Test
	void testGetBooks() throws Exception {
		List<ResponseBook> books = responsebooks();
		when(Rservice.getAllBooks()).thenReturn(books);
		List<ResponseBook> responsebooks = control.getBooks();
		assertEquals(books, responsebooks);
	}

	@Test
	void testGetBooksByPrice() throws Exception {
		List<ResponseBook> books = responsebooks();
		when(Rservice.getBookByPrice(2000d)).thenReturn(books);
		List<ResponseBook> list1 = control.getBooksByPrice(2000d);
		assertEquals(books, list1);
	}

	@Test
	void testGetBooksByTitle() throws Exception {
		List<ResponseBook> books = responsebooks();
		when(Rservice.getBookByTitle("cricket")).thenReturn(books);
		List<ResponseBook> responsebook = control.getBooksByTitle("cricket");
		assertEquals(books, responsebook);
	}

	@Test
	void testGetBooksByCategory() throws Exception {
		List<ResponseBook> books = responsebooks();
		when(Rservice.getBookByCategory("sports")).thenReturn(books);
		List<ResponseBook> list1 = control.getBooksByCategory("sports");
		assertEquals(books, list1);
	}

}
