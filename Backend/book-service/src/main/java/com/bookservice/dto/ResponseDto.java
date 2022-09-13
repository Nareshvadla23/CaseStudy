package com.bookservice.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDto {

	private String author;
	private String title;
	@Enumerated
	private Category category;
	private Double price;
	private String publisher;
	private LocalDate publisherDate;
	private String image;

}
