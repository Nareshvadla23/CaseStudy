package com.bookservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookservice.AuthorRepository;
import com.bookservice.BookRepository;
import com.bookservice.dto.Category;
import com.bookservice.dto.RequestDto;
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
		book.setImage("image1");
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
		book.setImage("image1");
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
		Integer id = service.saveAuthor(author);
		assertEquals(1, id);
	}

	@Test
	void testSavebook() {
		Book book = book();
		RequestDto requestBook = requestBook();
	
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
	

		Book book1 = service.updateBook(requestDto,1);
		assertEquals(1, book1.getId());

	}
}
