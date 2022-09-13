package com.bookservice.dto;

import java.time.LocalDate;

import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestDto {

	@Id
	@GeneratedValue
	private Integer id;
	private String author;
	private String content;
	private String image;
	private LocalDate publishedDate;
	private String publisher;
	private String title; 
	private Double price;
	@Enumerated
	private Category category;
	@Enumerated
	private Status status ;

}
