package com.bookservice.dto;

import java.util.Date;

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
	private Date publishedDate;
	private String publisher;
	private String title;
	private Double price;
	private String category;
	private Boolean status = true;

}
