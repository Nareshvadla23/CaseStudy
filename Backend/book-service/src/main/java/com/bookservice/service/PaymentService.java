package com.bookservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.BookRepository;
import com.bookservice.PaymentRepository;
import com.bookservice.dto.PaymentDto;
import com.bookservice.dto.BookDto;
import com.bookservice.entity.Book;
import com.bookservice.entity.Payment;

@Service
public class PaymentService {

	@Autowired 
	private PaymentRepository paymentRepository;

	@Autowired
	private BookRepository bookRepository;

	public static BookDto bookDto(Book book) {
		BookDto bookDto = new BookDto();
		bookDto.setAuthor(book.getAuthor().getName());
		bookDto.setCategory(book.getCategory());
		bookDto.setContent(book.getContent());
		bookDto.setImage(book.getImage());
		bookDto.setTitle(book.getTitle());
		bookDto.setPrice(book.getPrice());
		bookDto.setPublisher(book.getPublisher());
		bookDto.setPublishedDate(book.getPublishedDate());
		return bookDto;

	}

	public Payment buyBook(PaymentDto paymentDto) {

		Book book = bookRepository.findByTitle(paymentDto.getTitle());
		Payment pay = new Payment();
		pay.setBook(book);
		pay.setPaymentDate(paymentDto.getPaymentDate());
		pay.setPaymentMode(paymentDto.getPaymentMode());
		pay.setUserMail(paymentDto.getMailId());
		pay.setUserName(paymentDto.getName());
		Payment payment = paymentRepository.save(pay);
		return payment;
	}

	public List<BookDto> getBooksByMail(String mail) {
		List<Payment> payment = paymentRepository.findByUserMail(mail);
		List<BookDto> books = new ArrayList<>();
		for (Payment pay : payment) {
			Book book = pay.getBook();
			BookDto bookDto = bookDto(book);
			books.add(bookDto);
		}
		return books;
	}

	public List<BookDto> getBooksByPaymentId(Integer paymentId) {
		Optional<Payment> payment = paymentRepository.findById(paymentId);
		List<BookDto> books = new ArrayList<>();
		Book book = payment.get().getBook();
		BookDto bookDto = bookDto(book);
		books.add(bookDto);
		return books;
	}

	public String refundPayment(Integer paymenId) {
		Optional<Payment> payment = paymentRepository.findById(paymenId);
		LocalDate paymentDate = payment.get().getPaymentDate();
		if (paymentDate.equals(LocalDate.now())) {
			paymentRepository.delete(payment.get());
			return "Refund has been initiated";
		} else {
			return "refund period exceeded";
		}

	}

}
