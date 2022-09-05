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
import com.bookservice.entity.Mbook;
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
		author.setMail("naresh@gmail.com");
		author.setPassword("naresh@123");

		when(authorRepository.save(author)).thenReturn(author);

		Integer id = service.saveAuthor(author);

		assertEquals(1, id);

	}

	@Test
	void testSaveMbook() {

		Author author = new Author();
		author.setId(1);
		author.setName("naresh");
		author.setMail("naresh@gmail.com");
		author.setPassword("naresh@123");

		RequestBook book = new RequestBook();
		book.setAuthor("naresh");
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
		

		Mbook bk = new Mbook();
        bk.setId(1);
		bk.setCategory(book.getCategory());
		bk.setContent(book.getContent());
		bk.setImage(book.getImage());
		bk.setPrice(book.getPrice());
		bk.setPublishedDate(book.getPublishedDate());
		bk.setPublisher(book.getPublisher());
		bk.setStatus(book.getStatus());
		bk.setTitle(book.getTitle());
		bk.setAuthor(author);

		when(mbookRepository.save(bk)).thenReturn(bk);

		Integer id = service.SaveMbook(book);

		assertEquals(1, id);

	}

}
