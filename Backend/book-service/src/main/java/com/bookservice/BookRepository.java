package com.bookservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookservice.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	
	public Book findByTitle(String name);
	
	public List<Book> findByCategory(String name);
	
	public List<Book> findByPrice(Double price);
	
	public List<Book> findByAuthor(String name);
	
	

}
