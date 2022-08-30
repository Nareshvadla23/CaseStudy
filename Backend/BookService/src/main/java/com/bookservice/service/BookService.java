package com.bookservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.BookRepository;
import com.bookservice.entity.Book;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public Integer saveBook(Book book) {

		bookRepository.save(book);

		return book.getId();
	}

}
