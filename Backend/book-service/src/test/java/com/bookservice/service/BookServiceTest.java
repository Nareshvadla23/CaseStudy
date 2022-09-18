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
import com.bookservice.dto.Category;
import com.bookservice.dto.LoginDto;
import com.bookservice.dto.RequestDto;
import com.bookservice.dto.ResponseDto;
import com.bookservice.dto.Status;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

	@Mock
	AuthorRepository authorRepository;

	@Mock
	BookRepository mbookRepository;

	@InjectMocks
	BookService service;

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
		book.setAuthor("naresh");
		book.setCategory(Category.COMIC);
		book.setContent("Asia cup");
		book.setId(1);
		book.setImage("image1Iimage");
		book.setPrice(2000d);
		book.setPublishedDate(LocalDate.now());
		book.setPublisher("BCCI");
		book.setStatus(Status.ACTIVE);
		book.setTitle("cricket");
		return book;
	}

	public static Book book() {
		Author author = author();
		Book book = new Book();
		book.setAuthor(author);
		book.setCategory(Category.COMIC);
		book.setContent("Asia cup");
		book.setId(1);
		book.setImage("image1Iimage");
		book.setPrice(2000d);
		book.setPublishedDate(LocalDate.now());
		book.setPublisher("BCCI");
		book.setStatus(Status.ACTIVE);
		book.setTitle("cricket");
		return book; 
	}

	@Test
	void testSaveAuthor() {
		Author author = author();
		when(authorRepository.save(author)).thenReturn(author);
		Author author1 = service.saveAuthor(author);
		assertEquals(1, author1.getId());
	}

	@Test
	void testSavebook() {
		Book book = book();
		Author author = author();
		RequestDto requestBook = requestBook();
		when(authorRepository.findByName("naresh")).thenReturn(author);
		when(mbookRepository.save(book)).thenReturn(book);
		Integer id = service.savebook(requestBook);
		assertEquals(1, id);
	}

	@Test
	void testUpdateBook() {

		Book book = book();
		Optional<Book> optionalBook = Optional.of(book);
		when(mbookRepository.findById(1)).thenReturn(optionalBook);
		RequestDto requestDto = requestBook();
		Book book1 = service.updateBook(requestDto, 1);
		assertEquals(1, book1.getId());

	}

	@Test
	void testGetbyBookId() throws Exception {
		Book book = book();
		Optional<Book> optionalBook = Optional.of(book);
		when(mbookRepository.findById(1)).thenReturn(optionalBook);
		RequestDto requestDto = service.getbyBookId(1, "naresh@gmail.com");
		assertEquals("naresh", requestDto.getAuthor());
	}

	@Test
	void testloginAuthor() {

		LoginDto login = new LoginDto();
		login.setMailId("naresh@gmail.com");
		login.setPassword("naresh@123");
		Author author = author();
		when(authorRepository.findByMailId("naresh@gmail.com")).thenReturn(author);
		Author auth = service.loginAuthor(login);
		assertEquals("naresh", auth.getName());
	}

	@Test
	void testBooksbyAuthorId() {
		Book book = book();
		List<Book> books = new ArrayList<>();
		books.add(book);
		Author author = author();
		Optional<Author> option = Optional.of(author);
		when(authorRepository.findById(1)).thenReturn(option);
		when(mbookRepository.findByAuthor(author)).thenReturn(books);
		List<ResponseDto> responseDtos = service.BooksbyAuthorId(1);
		assertEquals(1, responseDtos.size());

	}

	@Test
	void testBooksbyAuthorMail() {
		Book book = book();
		List<Book> books = new ArrayList<>();
		books.add(book);
		Author author = author();
		when(authorRepository.findByMailId("naresh@gmail.com")).thenReturn(author);
		when(mbookRepository.findByAuthor(author)).thenReturn(books);
		List<ResponseDto> responseDtos = service.BooksbyAuthorMail("naresh@gmail.com");
		assertEquals(1, responseDtos.size());

	}
}
