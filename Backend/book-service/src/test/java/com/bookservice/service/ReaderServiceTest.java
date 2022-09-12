package com.bookservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookservice.AuthorRepository;
import com.bookservice.BookRepository;
import com.bookservice.dto.ResponseDto;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;

@ExtendWith(MockitoExtension.class)
class ReaderServiceTest {

	
	@Mock
	BookRepository mbookRepository;
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

	public static List<ResponseDto> responseBook() {
		List<ResponseDto> books = new ArrayList<>();
		for (Book mb : books()) {
			ResponseDto book = new ResponseDto();
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
		List<ResponseDto> books = redService.getAllBooks();
		assertEquals(1, books.size());
	}

	@Test
	void testGetBookByPrice() {
		when(mbookRepository.findByPrice(2000d)).thenReturn(books());
		List<ResponseDto> books = redService.getBookByPrice(2000d);
		assertEquals(responseBook().size(), books.size());
	}

	@Test
	void testGetBookByAuthor() {
		when(mbookRepository.findByAuthor(book().getAuthor().getName())).thenReturn(books());
		List<ResponseDto> books = redService.getBookByAuthor(book().getAuthor().getName());
		assertEquals(responseBook().size(), books.size());
	}

	@Test
	void testGetBookByCategory() {
		when(mbookRepository.findByCategory(book().getCategory())).thenReturn(books());
		List<ResponseDto> books = redService.getBookByCategory(book().getCategory());
		assertEquals(responseBook().size(), books.size());
	}

}
