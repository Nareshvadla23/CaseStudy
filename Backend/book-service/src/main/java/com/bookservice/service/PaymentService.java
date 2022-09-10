package com.bookservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.BookRepository;
import com.bookservice.PaymentRepository;
import com.bookservice.dto.PaymentDto;
import com.bookservice.entity.Book;
import com.bookservice.entity.Payment;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public Payment buyBook(PaymentDto paymentDto) {
		
		Book book =bookRepository.findByTitle(paymentDto.getTitle());
		Payment pay = new Payment();
		pay.setBook(book);
		pay.setPaymentDate(paymentDto.getPaymentDate());
		pay.setPaymentMode(paymentDto.getPaymentMode());
		pay.setUserMail(paymentDto.getMailId());
		pay.setUserName(paymentDto.getName());
		
		Payment payment =paymentRepository.save(pay);
		return payment;

	}

}
