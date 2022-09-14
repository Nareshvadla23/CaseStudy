package com.bookservice.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.bookservice.dto.Category;
import com.bookservice.dto.Status;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "mbook")
public class Book {

	@Id
	@GeneratedValue
	private Integer id;

	private String image;
	@NotBlank(message = "title should not be blank")
	private String title;
	@Enumerated(EnumType.STRING)
	private Category category;
	@Min(message = "Price should be greaterthan or equal to 1", value = 1)
	private Double price;
	@NotBlank(message = "Publisher should not be blank") 
	private String publisher;
	private LocalDate publishedDate;
	@NotBlank(message = "Content should not be blank")
	private String content;
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToOne(targetEntity = Author.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private Author author;

}
