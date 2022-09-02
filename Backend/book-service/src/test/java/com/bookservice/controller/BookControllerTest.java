package com.bookservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookservice.entity.Author;
import com.bookservice.entity.Book;
import com.bookservice.service.BookService;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

	@Mock
	BookService service;

	@InjectMocks
	BookController controller;

	@Test
	void testSavebook() {

		Author auth = new Author();
		auth.setId(2);
		auth.setName("naresh");

		List<Book> list = new ArrayList<>();
		Book b1 = new Book();
		b1.setId(101);
		b1.setCategory("sports");
		b1.setImage("post1");
		b1.setPrice(2000d);
		b1.setPublishedDate("2022-02-22");
		b1.setPublisher("publisher");
		b1.setStatus(true);
		b1.setTitle("cricket");
		b1.setContent("About cricket");

		when(service.saveBooks(auth)).thenReturn(auth.getId());

		Integer id = service.saveBooks(auth);

		assertEquals(2, id);

	}

	@Test
	void testGetBooks() {

		Author auth = new Author();
		auth.setId(2);
		auth.setName("naresh");

		List<Book> list = new ArrayList<>();
		Book b1 = new Book();
		b1.setId(101);
		b1.setCategory("sports");
		b1.setImage("post1");
		b1.setPrice(2000d);
		b1.setPublishedDate("2022-02-22");
		b1.setPublisher("publisher");
		b1.setStatus(true);
		b1.setTitle("cricket");
		b1.setContent("About cricket");

		Book b2 = new Book();
		b2.setId(102);
		b2.setCategory("sports");
		b2.setImage("post2");
		b2.setPrice(2000d);
		b2.setPublishedDate("2022-02-21");
		b2.setPublisher("publisher");
		b2.setStatus(true);
		b2.setTitle("football"); 
		b2.setContent("About football");

		list.add(b1);
		list.add(b2);

		auth.setBook(list);

		List<Author> list1 = new ArrayList<>();
		list1.add(auth);

		when(service.getAllBooks()).thenReturn(list1);

		List<Author> list2 = service.getAllBooks();

		assertEquals(list1, list2);

	}

}
