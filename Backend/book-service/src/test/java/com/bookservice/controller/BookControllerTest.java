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

import com.bookservice.entity.Author;
import com.bookservice.entity.Mbook;
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

	@Test
	void testCreateBook() {

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

		when(service.SaveMbook(book)).thenReturn(book.getId());

		Integer id = control.createBook(book);

		assertEquals(1, id); 
 
	}

	@Test
	void testLoginAuthor() {

		String mail = "naresh@gmail.com";
		String password = "12345";

		when(service.loginAuthor(mail, password)).thenReturn(1);
		Integer id = control.loginAuthor(mail, password);

		assertEquals(1, id);

	}

	@Test
	void testSaveAuthor() {

		Author auth = new Author();
		auth.setId(1);
		auth.setMail("naresh@gmail.com");
		auth.setName("naresh");
		auth.setPassword("naresh@23");

		when(service.saveAuthor(auth)).thenReturn(auth.getId());

		Integer id = control.saveAuthor(auth);

		assertEquals(1, id);

	}

	@Test
	void testGetBooks() throws Exception {
		Mbook book = new Mbook();

		Author auth = new Author();
		auth.setId(1);
		auth.setMail("naresh@gmail.com");
		auth.setName("naresh");
		auth.setPassword("naresh@23");

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

		List<Mbook> books = new ArrayList<>();
		books.add(book);

		List<ResponseBook> list = new ArrayList<>();

		for (Mbook mb : books) {
			ResponseBook b1 = new ResponseBook();
			b1.setCategory(mb.getCategory());
			b1.setPrice(mb.getPrice());
			b1.setPublisherDate(mb.getPublishedDate());
			b1.setPublisher(mb.getPublisher());
			b1.setTitle(mb.getTitle());

			Optional<Author> check = Optional.of(auth);

			if (check.isPresent()) {
				b1.setAuthor(check.get().getName());
			}

			b1.setImage(mb.getImage());
			list.add(b1);
		}

		when(Rservice.getAllBooks()).thenReturn(list);

		List<ResponseBook> list1 = control.getBooks();

		assertEquals(list, list1);

	}

	@Test
	void testGetBooksByPrice() throws Exception {

		Mbook book = new Mbook();

		Author auth = new Author();
		auth.setId(1);
		auth.setMail("naresh@gmail.com");
		auth.setName("naresh");
		auth.setPassword("naresh@23");

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

		List<Mbook> books = new ArrayList<>();
		books.add(book);

		List<ResponseBook> list = new ArrayList<>();

		for (Mbook mb : books) {
			ResponseBook b1 = new ResponseBook();
			b1.setCategory(mb.getCategory());
			b1.setPrice(mb.getPrice());
			b1.setPublisherDate(mb.getPublishedDate());
			b1.setPublisher(mb.getPublisher());
			b1.setTitle(mb.getTitle());

			Optional<Author> check = Optional.of(auth);

			if (check.isPresent()) {
				b1.setAuthor(check.get().getName());
			}

			b1.setImage(mb.getImage());
			list.add(b1);
		}

		when(Rservice.getBookByPrice(2000d)).thenReturn(list);

		List<ResponseBook> list1 = control.getBooksByPrice(2000d);

		assertEquals(list, list1);

	}

	@Test
	void testGetBooksByTitle() throws Exception {

		Mbook book = new Mbook();

		Author auth = new Author();
		auth.setId(1);
		auth.setMail("naresh@gmail.com");
		auth.setName("naresh");
		auth.setPassword("naresh@23");

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

		List<Mbook> books = new ArrayList<>();
		books.add(book);

		List<ResponseBook> list = new ArrayList<>();

		for (Mbook mb : books) {
			ResponseBook b1 = new ResponseBook();
			b1.setCategory(mb.getCategory());
			b1.setPrice(mb.getPrice());
			b1.setPublisherDate(mb.getPublishedDate());
			b1.setPublisher(mb.getPublisher());
			b1.setTitle(mb.getTitle());

			Optional<Author> check = Optional.of(auth);

			if (check.isPresent()) {
				b1.setAuthor(check.get().getName());
			}

			b1.setImage(mb.getImage());
			list.add(b1);
		}

		when(Rservice.getBookByTitle(book.getTitle())).thenReturn(list);

		List<ResponseBook> list1 = control.getBooksByTitle(book.getTitle());

		assertEquals(list, list1);

	}

	@Test
	void testGetBooksByCategory() throws Exception {

		Mbook book = new Mbook();

		Author auth = new Author();
		auth.setId(1);
		auth.setMail("naresh@gmail.com");
		auth.setName("naresh");
		auth.setPassword("naresh@23");

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

		List<Mbook> books = new ArrayList<>();
		books.add(book);

		List<ResponseBook> list = new ArrayList<>();

		for (Mbook mb : books) {
			ResponseBook b1 = new ResponseBook();
			b1.setCategory(mb.getCategory());
			b1.setPrice(mb.getPrice());
			b1.setPublisherDate(mb.getPublishedDate());
			b1.setPublisher(mb.getPublisher());
			b1.setTitle(mb.getTitle());

			Optional<Author> check = Optional.of(auth);

			if (check.isPresent()) {
				b1.setAuthor(check.get().getName());
			}

			b1.setImage(mb.getImage());
			list.add(b1);
		}

		when(Rservice.getBookByCategory(book.getCategory())).thenReturn(list);

		List<ResponseBook> list1 = control.getBooksByCategory(book.getCategory());

		assertEquals(list, list1);

	}

}
