package com.bookservice.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class refundDto {

	private String refundStatus;
	private LocalDate purchaseDate;

}
