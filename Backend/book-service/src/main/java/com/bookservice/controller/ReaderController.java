package com.bookservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.dto.PaymentDto;
import com.bookservice.entity.Payment;
import com.bookservice.service.PaymentService;

@CrossOrigin
@RestController
public class ReaderController {
	
	@Autowired
	private PaymentService PaymentService;
	
	@PostMapping("/buy")
	public Payment buyBook( @Valid @RequestBody PaymentDto paymentDto)
	{
		Payment payment =PaymentService.buyBook(paymentDto);
		return payment;
	}

}
