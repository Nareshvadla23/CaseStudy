package com.bookservice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "book")
public class RequestBook {

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
