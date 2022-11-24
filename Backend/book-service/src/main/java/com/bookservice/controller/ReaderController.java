package com.bookservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.PaymentRepository;
import com.bookservice.dto.BookDto;
import com.bookservice.dto.Category;
import com.bookservice.dto.PaymentDto;
import com.bookservice.dto.ResponseDto;
import com.bookservice.dto.refundDto;
import com.bookservice.entity.Payment;
import com.bookservice.service.PaymentService;
import com.bookservice.service.ReaderService;

@CrossOrigin
@RestController
@RequestMapping("/digitalbooks")
public class ReaderController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private ReaderService readerService;

	@Autowired
	private PaymentRepository paymentRepository;

	@PostMapping("/buy")
	public Payment buyBook(@Valid @RequestBody PaymentDto paymentDto) {
		return paymentService.buyBook(paymentDto);
	}

	@GetMapping("/books/byMailId/{mailId}/paymentId/{paymentId}")
	public BookDto getBooksByMailId(@PathVariable String mailId, @PathVariable Integer paymentId) throws Exception {
		return paymentService.getBooksByMail(mailId, paymentId);
	}

	@GetMapping("/books/all")
	public List<ResponseDto> getBooks() {
		return readerService.getAllBooks();
	}

	@GetMapping("/books/byPrice/{price}")
	public List<ResponseDto> getBooksByPrice(@PathVariable Double price) {
		return readerService.getBookByPrice(price);
	}

	@GetMapping("/books/byAuthor/{author}")
	public List<ResponseDto> getBooksByAuthor(@PathVariable String author) {
		return readerService.getBookByAuthor(author);
	}

	@GetMapping("/books/byCategory/{category}")
	public List<ResponseDto> getBooksByCategory(@PathVariable Category category) {
		return readerService.getBookByCategory(category);
	}

	@GetMapping("/refund/{PaymentId}/mail/{mailId}")
	public refundDto paymentRefund(@PathVariable Integer paymentId, @PathVariable String mailId) throws Exception {
		Payment payment = paymentRepository.findByUserMail(mailId);
		if (payment.getId().equals(paymentId)) {
			return paymentService.refundPayment(mailId);
		}
		throw new Exception("Payment Id Not matching with mailId");

	}

}
