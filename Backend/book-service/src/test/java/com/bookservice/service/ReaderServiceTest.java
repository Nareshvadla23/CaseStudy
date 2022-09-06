package com.bookservice.service;

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

import com.bookservice.AuthorRepository;
import com.bookservice.BookRepository;
import com.bookservice.MbookRepository;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;
import com.bookservice.entity.ResponseBook;

@ExtendWith(MockitoExtension.class)
class ReaderServiceTest {

	@Mock
	BookRepository bookRepository;
	@Mock
	MbookRepository mbookRepository;
	@Mock
	AuthorRepository authorRepository;
	@InjectMocks
	ReaderService redService;

	public static Author author() {
		Author auth = new Author();
		auth.setId(1);
		auth.setMail("naresh@gmail.com");
		auth.setName("naresh");
		auth.setPassword("naresh@23");
		return auth;
	}

	public static Book book() {
		Book book = new Book();
		book.setAuthor(author());
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
		List<Book> books = new ArrayList<>();
		books.add(book());
		return books;
	}

	public static List<ResponseBook> responseBook() {
		List<ResponseBook> list = new ArrayList<>();
		for (Book mb : books()) {
			ResponseBook b1 = new ResponseBook();
			b1.setCategory(mb.getCategory());
			b1.setPrice(mb.getPrice());
			b1.setPublisherDate(mb.getPublishedDate());
			b1.setPublisher(mb.getPublisher());
			b1.setTitle(mb.getTitle());
			b1.setAuthor(author().getName());
			b1.setImage(mb.getImage());
			b1.setAuthor(mb.getAuthor().getName());
			list.add(b1);
		}
		return list;
	}

	@Test
	void testGetAllBooks() {
		when(bookRepository.findAll()).thenReturn(books());
		List<ResponseBook> Rbooks = redService.getAllBooks();
		assertEquals(responseBook().size(), Rbooks.size());
	}

	@Test
	void testGetBookByPrice() {
		when(mbookRepository.findByPrice(2000d)).thenReturn(books());
		List<ResponseBook> Rbooks = redService.getBookByPrice(2000d);
		assertEquals(responseBook().size(), Rbooks.size());
	}

	@Test
	void testGetBookByTitle() {
		when(mbookRepository.findByTitle(book().getTitle())).thenReturn(books());
		List<ResponseBook> Rbooks = redService.getBookByTitle(book().getTitle());
		assertEquals(responseBook().size(), Rbooks.size());

	}

	@Test
	void testGetBookByCategory() {
		when(mbookRepository.findByCategory(book().getCategory())).thenReturn(books());
		List<ResponseBook> Rbooks = redService.getBookByCategory(book().getCategory());
		assertEquals(responseBook().size(), Rbooks.size());

	}

}
