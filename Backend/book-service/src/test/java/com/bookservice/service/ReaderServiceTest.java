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
	MbookRepository mbookRepository;
	@Mock
	AuthorRepository authorRepository;
	@InjectMocks
	ReaderService redService;

	public static Author author() {
		Author author = new Author();
		author.setId(1);
		author.setMailId("naresh@gmail.com");
		author.setName("naresh");
		author.setPassword("naresh@23");
		return author;
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
		List<ResponseBook> books = new ArrayList<>();
		for (Book mb : books()) {
			ResponseBook book = new ResponseBook();
			book.setCategory(mb.getCategory());
			book.setPrice(mb.getPrice());
			book.setPublisherDate(mb.getPublishedDate());
			book.setPublisher(mb.getPublisher());
			book.setTitle(mb.getTitle());
			book.setAuthor(author().getName());
			book.setImage(mb.getImage());
			book.setAuthor(mb.getAuthor().getName());
			books.add(book);
		}
		return books;
	}

	@Test
	void testGetAllBooks() {
		when(mbookRepository.findAll()).thenReturn(books());
		List<ResponseBook> books = redService.getAllBooks();
		assertEquals(1, books.size());
	}

	@Test
	void testGetBookByPrice() {
		when(mbookRepository.findByPrice(2000d)).thenReturn(books());
		List<ResponseBook> books = redService.getBookByPrice(2000d);
		assertEquals(responseBook().size(), books.size());
	}

	@Test
	void testGetBookByTitle() {
		when(mbookRepository.findByTitle(book().getTitle())).thenReturn(books());
		List<ResponseBook> books = redService.getBookByTitle(book().getTitle());
		assertEquals(responseBook().size(), books.size());
	}

	@Test
	void testGetBookByCategory() {
		when(mbookRepository.findByCategory(book().getCategory())).thenReturn(books());
		List<ResponseBook> books = redService.getBookByCategory(book().getCategory());
		assertEquals(responseBook().size(), books.size());
	}

}
