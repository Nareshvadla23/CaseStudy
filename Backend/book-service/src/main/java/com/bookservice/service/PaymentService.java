package com.bookservice.service;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookservice.BookRepository;
import com.bookservice.PaymentRepository;
import com.bookservice.dto.BookDto;
import com.bookservice.dto.PaymentDto;
import com.bookservice.dto.refundDto;
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

	public BookDto getBooksByMail(String mail, Integer paymentId) throws Exception {
		Optional<Payment> payment = paymentRepository.findById(paymentId);

		if (payment.get().getUserMail().equals(mail)) {
			Book book = payment.get().getBook();
			BookDto bookDto = bookDto(book);
			return bookDto;
		} else {
			throw new Exception("Time limit for refund exceeded");
		}

	}
	public refundDto refundPayment(String mail)  {
		Payment payment = paymentRepository.findByUserMail(mail);
		refundDto refund = new refundDto();
		refund.setPurchaseDate(payment.getPaymentDate());

		LocalDate paymentDate = payment.getPaymentDate();
		if (paymentDate.equals(LocalDate.now())) {
			paymentRepository.delete(payment);
			refund.setRefundStatus("Refund Initiated and you get fund within 24hrs");

			return refund;
		} else {
			refund.setRefundStatus("Sorry Time limit for refund expires");
			return refund;
		}

	}

}
