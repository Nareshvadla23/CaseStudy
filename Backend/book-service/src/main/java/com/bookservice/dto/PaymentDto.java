package com.bookservice.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentDto {
	
	private String title;
	private String name;
	private String mailId;
	private String paymentMode;
	private LocalDate paymentDate;
}
