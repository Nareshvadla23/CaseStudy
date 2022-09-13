package com.bookservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookservice.dto.BookDto;
import com.bookservice.dto.Category;
import com.bookservice.dto.PaymentDto;
import com.bookservice.dto.RequestDto;
import com.bookservice.dto.ResponseDto;
import com.bookservice.dto.Status;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;
import com.bookservice.entity.Payment;
import com.bookservice.service.BookService;
import com.bookservice.service.PaymentService;
import com.bookservice.service.ReaderService;

@ExtendWith(MockitoExtension.class)
class ReaderControllerTest {

	@Mock
	BookService service;

	@Mock
	ReaderService Rservice;

	@Mock
	PaymentService paymentService;

	@InjectMocks
	BookController control;

	@InjectMocks
	ReaderController readerController;

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
		Author auth = author();
		book.setAuthor(auth);
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

	public static RequestDto requestBook() {
		RequestDto book = new RequestDto();
		book.setAuthor("Naresh");
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

	public static List<ResponseDto> responsebooks() {
		List<ResponseDto> responseBooks = new ArrayList<>();
		Author author = author();
		for (Book book : books()) {
			ResponseDto responseBook = new ResponseDto();
			responseBook.setCategory(book.getCategory());
			responseBook.setPrice(book.getPrice());
			responseBook.setPublisherDate(book.getPublishedDate());
			responseBook.setPublisher(book.getPublisher());
			responseBook.setTitle(book.getTitle());
			responseBook.setImage(book.getImage());
			responseBook.setAuthor(author.getName());
			responseBooks.add(responseBook);
		}
		return responseBooks;
	}

	public static PaymentDto paymentDto() {
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setName("naresh");
		paymentDto.setMailId("naresh@gmail.com");
		LocalDate date = LocalDate.now();
		paymentDto.setPaymentDate(date);
		paymentDto.setPaymentMode("Internet Banking");
		return paymentDto;
	}

	public static Payment payment() {
		Payment payment = new Payment();
		payment.setBook(book());
		payment.setId(1);
		LocalDate date = LocalDate.now();
		payment.setPaymentDate(date);
		payment.setPaymentMode("net banking");
		payment.setUserMail("mail1");
		payment.setUserName("naresh");
		return payment;
	}

	@Test
	void testBuyBook() {

		Payment payment = payment();
		
		PaymentDto paymentDto = paymentDto();

		when(paymentService.buyBook(paymentDto)).thenReturn(payment);
		Payment payment1 = readerController.buyBook(paymentDto);
		assertEquals(1, payment1.getId()); 

	}

	@Test
	void testGetBooksByMailId() { 

		BookDto book = new BookDto();
		book.setAuthor("naresh");
		book.setCategory(Category.COMIC);
		book.setContent("content");
		book.setImage("//image1");
		book.setPrice(200d);
		book.setPublisher("public");
		book.setPublisherDate(LocalDate.now());

		List<BookDto> books = new ArrayList<>();
		books.add(book);
		when(paymentService.getBooksByMail("naresh@gmail.com")).thenReturn(books);
		List<BookDto> books1 = readerController.getBooksByMailId("naresh@gmail.com");
		assertEquals(books.size(), books1.size());

	}

	@Test
	void testGetBooks() throws Exception {
		List<ResponseDto> books = responsebooks();
		when(Rservice.getAllBooks()).thenReturn(books);
		List<ResponseDto> responsebooks = readerController.getBooks();
		assertEquals(books, responsebooks);
	}

	@Test
	void testGetBooksByPrice() throws Exception {
		List<ResponseDto> books = responsebooks();
		when(Rservice.getBookByPrice(2000d)).thenReturn(books);
		List<ResponseDto> list1 = readerController.getBooksByPrice(2000d);
		assertEquals(books, list1);
	}

	@Test
	void testGetBooksByAuthor() throws Exception {
		List<ResponseDto> books = responsebooks();
		when(Rservice.getBookByAuthor("naresh")).thenReturn(books);
		List<ResponseDto> responsebook = readerController.getBooksByAuthor("naresh");
		assertEquals(books, responsebook);
	}

	@Test
	void testGetBooksByCategory() throws Exception {
		List<ResponseDto> books = responsebooks();
		when(Rservice.getBookByCategory(Category.COMIC)).thenReturn(books);
		List<ResponseDto> list1 = readerController.getBooksByCategory(Category.COMIC);
		assertEquals(books, list1);
	}

}
