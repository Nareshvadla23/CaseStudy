package com.bookservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookservice.AuthorRepository;
import com.bookservice.BookRepository;
import com.bookservice.dto.Category;
import com.bookservice.dto.ResponseDto;
import com.bookservice.dto.Status;
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

	public static List<ResponseDto> responseBook() {
		List<ResponseDto> books = new ArrayList<>();
		for (Book mb : books()) {
			ResponseDto book = new ResponseDto();
			book.setCategory(mb.getCategory());
			book.setPrice(mb.getPrice());
			book.setPublishedDate(mb.getPublishedDate());
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
		assertEquals(books().isEmpty(), books.isEmpty());
	}

	@Test
	void testGetBookByPrice() {
		when(mbookRepository.findByPrice(2000d)).thenReturn(books());
		List<ResponseDto> books = redService.getBookByPrice(2000d);
		assertEquals(books().size(), books.size());
	}

	@Test
	void testGetBookByAuthor() {
		
		Author author = author();
		List<Book> books = books();
		when(authorRepository.findByName("naresh")).thenReturn(author);
		when(mbookRepository.findByAuthor(author)).thenReturn(books);
		List<ResponseDto> book = redService.getBookByAuthor("naresh");
		assertEquals(1, book.size());
	}

	@Test
	void testGetBookByCategory() {
		when(mbookRepository.findByCategory(book().getCategory())).thenReturn(books());
		List<ResponseDto> books = redService.getBookByCategory(book().getCategory());
		assertEquals(responseBook().size(), books.size());
	}

}
