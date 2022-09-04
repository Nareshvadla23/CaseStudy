package com.bookservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
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
import com.bookservice.entity.Mbook;
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

	@Test
	void testGetAllBooks() throws Exception {

		Mbook book = new Mbook();

		Author auth = new Author();
		auth.setId(1);
		auth.setMail("naresh@gmail.com");
		auth.setName("naresh");
		auth.setPassword("naresh@23");

		Optional<Author> option = Optional.of(auth);

		book.setAuthor(auth);

		book.setCategory("sports");
		book.setContent("Asia cup");
		book.setId(1);
		book.setImage("image1");
		book.setPrice(2000d);
		LocalDate date = LocalDate.of(2000, 12, 21);
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
			b1.setAuthor(auth.getName());
			b1.setImage(mb.getImage());
			list.add(b1);
		}

		when(bookRepository.findAll()).thenReturn(books);
		when(authorRepository.findById(auth.getId())).thenReturn(option);

		List<ResponseBook> Rbooks = redService.getAllBooks();

		assertEquals(list.size(), Rbooks.size());

	}

	@Test
	void testGetBookByPrice() throws Exception {
		Mbook book = new Mbook();

		Author auth = new Author();
		auth.setId(1);
		auth.setMail("naresh@gmail.com");
		auth.setName("naresh");
		auth.setPassword("naresh@23");

		Optional<Author> option = Optional.of(auth);

		book.setAuthor(auth);

		book.setCategory("sports");
		book.setContent("Asia cup");
		book.setId(1);
		book.setImage("image1");
		book.setPrice(2000d);
		LocalDate date = LocalDate.of(2000, 12, 21);
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
			b1.setAuthor(auth.getName());
			b1.setImage(mb.getImage());
			list.add(b1);
		}

		when(mbookRepository.findByPrice(2000d)).thenReturn(books);
		when(authorRepository.findById(auth.getId())).thenReturn(option);

		List<ResponseBook> Rbooks = redService.getBookByPrice(2000d);

		assertEquals(list.size(), Rbooks.size());

	}

}
