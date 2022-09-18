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

import com.bookservice.BookRepository;
import com.bookservice.PaymentRepository;
import com.bookservice.dto.BookDto;
import com.bookservice.dto.Category;
import com.bookservice.dto.PaymentDto;
import com.bookservice.dto.PaymentMode;
import com.bookservice.dto.ResponseDto;
import com.bookservice.dto.Status;
import com.bookservice.dto.refundDto;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;
import com.bookservice.entity.Payment;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

	@Mock
	PaymentRepository paymentRepository;

	@Mock
	BookRepository BookRepository;

	@InjectMocks
	PaymentService paymentService;

	public static Author author() {
		Author author = new Author();
		author.setId(1);
		author.setMailId("naresh@gmail.com");
		author.setName("naresh");
		author.setPassword("naresh@23");
		return author;
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

	public static PaymentDto PaymentDto() {
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setMailId("naresh@gmail.com");
		paymentDto.setName("naresh");
		paymentDto.setPaymentDate(LocalDate.now());
		paymentDto.setPaymentMode(PaymentMode.NETBANKING);
		paymentDto.setTitle("cricket");
		return paymentDto;
	}

	public static Payment payment() {
		PaymentDto paymentDto = PaymentDto();
		Book book = book();
		Payment pay = new Payment();
		pay.setBook(book);
		pay.setId(1);
		pay.setPaymentDate(paymentDto.getPaymentDate());
		pay.setPaymentMode(paymentDto.getPaymentMode());
		pay.setUserMail(paymentDto.getMailId());
		pay.setUserName(paymentDto.getName());
		return pay;

	}

	public static List<Payment> payments() {
		Payment pay = payment();
		List<Payment> payments = new ArrayList<>();
		payments.add(pay);
		return payments;
	}

	@Test
	void testBookDto() {
		Book book = book();
		BookDto bookDto = paymentService.bookDto(book);
		assertEquals(book.getAuthor().getName(), bookDto.getAuthor());
	}
 
	@Test
	void testBuyBook() {
		Book book = book();
		when(BookRepository.findByTitle("cricket")).thenReturn(book);
		Payment pay = payment();
		when(paymentRepository.save(pay)).thenReturn(pay);
		PaymentDto paymentDto = PaymentDto();
		Payment payment = paymentService.buyBook(paymentDto);
		assertEquals("net banking", payment.getPaymentMode());
	}

	@Test
	void testGetBooksByMail() throws Exception {
		List<Payment> payments = payments();
		Optional<Payment> payment = Optional.of(payment());
		when(paymentRepository.findById(1)).thenReturn(payment);
		BookDto books = paymentService.getBooksByMail("naresh@gmail.com",1);
		assertEquals("naresh", books.getAuthor());
	}
	@Test
	void testRefundPayment()  {
	Payment payment = payment();
	when(paymentRepository.findByUserMail("naresh@gmail.com")).thenReturn(payment);
	refundDto refund = new refundDto();
	refund.setPurchaseDate(payment.getPaymentDate());
	refund.setRefundStatus("refunded");
    refundDto refunds = paymentService.refundPayment("naresh@gmail.com");
    assertEquals(payment.getPaymentDate(), refunds.getPurchaseDate());
	}

}
