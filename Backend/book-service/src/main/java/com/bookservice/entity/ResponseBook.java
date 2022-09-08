package com.bookservice.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseBook {

	private String author;
	private String title;
	private String category;
	private Double price;
	private String publisher;
	private Date publisherDate;
	private String image;

}
