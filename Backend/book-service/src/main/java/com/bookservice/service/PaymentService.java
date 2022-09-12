package com.bookservice.service;

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
		   BookDto bookDto = new BookDto();
		   bookDto.setAuthor(book.getAuthor().getName());
		   bookDto.setCategory(book.getCategory());
		   bookDto.setContent(book.getContent());
		   bookDto.setImage(book.getImage());
		   bookDto.setTitle(book.getTitle());
		   bookDto.setPrice(book.getPrice());
		   bookDto.setPublisher(book.getPublisher());
		   bookDto.setPublisherDate(book.getPublishedDate());	
		}
		return books;
	}

}
