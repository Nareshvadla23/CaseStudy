package com.bookservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookservice.AuthorRepository;
import com.bookservice.MbookRepository;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;
import com.bookservice.entity.RequestBook;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

	@Mock
	AuthorRepository authorRepository;

	@Mock
	MbookRepository mbookRepository;

	@InjectMocks
	BookService service;

	@Test
	void testSaveAuthor() {

		Author author = new Author();
		author.setId(1);
		author.setName("naresh");
		author.setMailId("naresh@gmail.com");
		author.setPassword("naresh@123");

		when(authorRepository.save(author)).thenReturn(author);
		Integer id = service.saveAuthor(author);
		assertEquals(1, id);
	}

	@Test
	void testSavebook() {

		Author author = new Author();
		author.setId(1);
		author.setName("naresh");
		author.setMailId("naresh@gmail.com");
		author.setPassword("naresh@123");

		RequestBook requestBook = new RequestBook();
		requestBook.setAuthor("naresh");
		requestBook.setCategory("sports");
		requestBook.setContent("Asia cup");
		requestBook.setId(1);
		requestBook.setImage("image1");
		requestBook.setPrice(2000d);
		Date date = new Date(2000, 12, 12);
		requestBook.setPublishedDate(date);
		requestBook.setPublisher("BCCI");
		requestBook.setStatus(true);
		requestBook.setTitle("cricket");

		Book book = new Book();
		book.setId(1);
		book.setCategory(book.getCategory());
		book.setContent(book.getContent());
		book.setImage(book.getImage());
		book.setPrice(book.getPrice());
		book.setPublishedDate(book.getPublishedDate());
		book.setPublisher(book.getPublisher());
		book.setStatus(book.getStatus());
		book.setTitle(book.getTitle());
		book.setAuthor(author);

		when(mbookRepository.save(book)).thenReturn(book);
		Integer id = service.savebook(requestBook);
		assertEquals(1, id);
	}
}
