package com.bookservice.entity;

import java.time.LocalDate;

public class ResponseBook {
	
	private String author;
	private String title;
	private String category;
	private Double price;
	private String publisher;
	private LocalDate publisherDate;
	private String image;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public LocalDate getPublisherDate() {
		return publisherDate;
	}
	public void setPublisherDate(LocalDate publisherDate) {
		this.publisherDate = publisherDate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	

}
