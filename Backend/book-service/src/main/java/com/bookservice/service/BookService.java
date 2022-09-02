package com.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.AuthorRepository;
import com.bookservice.BookRepository;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;

@Service
public class BookService { 

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	public Integer saveBooks(Author author) {

		Author auth = authorRepository.save(author);

		return auth.getId();
	}

	public List<Author> getAllBooks() {
		return authorRepository.findAll();
	}

}
