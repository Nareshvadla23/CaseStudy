package com.bookservice.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity(name = "mbook")
public class Book {

	@Id
	@GeneratedValue
	private Integer id;

	private String image;
	@NotBlank(message = "title should not be blank")
	private String title;
	@NotBlank(message = "Category should not be blank")
	private String category;
	@Min(message = "Price should be greaterthan or equal to 1", value = 1)
	private Double price;
	@NotBlank(message = "Publisher should not be blank")
	private String publisher;
	private Date publishedDate;
	@NotBlank(message = "Content should not be blank")
	private String content;
	private Boolean status;
	@ManyToOne(targetEntity = Author.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private Author author;

}
