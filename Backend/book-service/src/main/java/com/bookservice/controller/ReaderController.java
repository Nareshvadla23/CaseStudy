package com.bookservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.dto.BookDto;
import com.bookservice.dto.Category;
import com.bookservice.dto.PaymentDto;
import com.bookservice.dto.ResponseDto;
import com.bookservice.entity.Payment;
import com.bookservice.service.PaymentService;
import com.bookservice.service.ReaderService;

@CrossOrigin
@RestController
public class ReaderController {

	@Autowired
	private PaymentService PaymentService;

	@Autowired
	private ReaderService ReaderService;

	@PostMapping("/buy")
	public Payment buyBook(@Valid @RequestBody PaymentDto paymentDto) {
		Payment payment = PaymentService.buyBook(paymentDto);
		return payment;
	}

	@GetMapping("/books/byMailId/{mailId}")
	public List<BookDto> getBooksByMailId(@PathVariable String mailId) {
		return PaymentService.getBooksByMail(mailId);
	}

	@GetMapping("/books/all")
	public List<ResponseDto> getBooks() throws Exception {
		return ReaderService.getAllBooks();
	}

	@GetMapping("/books/byPrice/{price}")
	public List<ResponseDto> getBooksByPrice(@PathVariable Double price) throws Exception {
		return ReaderService.getBookByPrice(price);
	}

	@GetMapping("/books/byAuthor/{author}")
	public List<ResponseDto> getBooksByAuthor(@PathVariable String author) throws Exception {
		return ReaderService.getBookByAuthor(author);
	}

	@GetMapping("/books/byCategory/{category}")
	public List<ResponseDto> getBooksByCategory(@PathVariable Category category) throws Exception {
		return ReaderService.getBookByCategory(category);
	}

	@GetMapping("/books/byPaymentId/{paymentId}")
	public BookDto getbookByPaymentId(@PathVariable Integer paymentId) {
		return PaymentService.getBooksByPaymentId(paymentId);
	}

	@PostMapping("/refund/{paymentId}")
	public String paymentRefund(@PathVariable Integer paymentId) {
		return PaymentService.refundPayment(paymentId);
	}

}
