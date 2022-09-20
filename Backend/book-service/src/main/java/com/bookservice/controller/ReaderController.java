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
	private PaymentService PaymentService;

	@Autowired
	private ReaderService ReaderService;

	@Autowired
	private PaymentRepository paymentRepository;

	@PostMapping("/buy")
	public Payment buyBook(@Valid @RequestBody PaymentDto paymentDto) {
		Payment payment = PaymentService.buyBook(paymentDto);
		return payment;
	}

	@GetMapping("/books/byMailId/{mailId}/paymentId/{paymentId}")
	public BookDto getBooksByMailId(@PathVariable String mailId, @PathVariable Integer paymentId) throws Exception {
		return PaymentService.getBooksByMail(mailId, paymentId);
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

	@GetMapping("/refund/{PaymentId}/mail/{mailId}")
	public refundDto paymentRefund(@PathVariable Integer PaymentId, @PathVariable String mailId) throws Exception {
		Payment payment = paymentRepository.findByUserMail(mailId);
		if (payment.getId().equals(PaymentId)) {
			return PaymentService.refundPayment(mailId);
		}
		throw new Exception("Payment Id Not matching with mailId");

	}

}
