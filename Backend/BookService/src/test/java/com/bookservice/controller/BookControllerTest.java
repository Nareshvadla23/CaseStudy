package com.bookservice.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookservice.requestentity.Cbook;
import com.bookservice.service.BookService;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

	@Mock
	BookService bookService;

	@InjectMocks
	BookController bookController;

	@Test
	void testSaveBook() {

		Cbook c1 = new Cbook();
		c1.setAuthorId(1);
		c1.setAuthorName("Naresh");
		c1.setCategory("sports");
		c1.setId(2);
		c1.setContent("cricket");
		c1.setImage("image1");
		c1.setPrice(20000d);
		LocalDate d1 = LocalDate.of(2022, 02, 21);
		c1.setPublishedDate(d1);
		c1.setPublisher("VKS");
		c1.setStatus(true);
		c1.setTitle("Asia cup");

		when(bookService.saveBook(c1)).thenReturn(c1.getId());
		
		Integer val =bookService.saveBook(c1);

		assertEquals(2, val);

	}

	@Test
	void testSaveBook1() {

	}

	@Test
	void testGetBooks() {

	}

}
