package com.bookservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.BookRepository;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;
import com.bookservice.requestentity.Cbook;
import com.bookservice.responseentity.Sbook;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public Integer saveBook(Cbook book) {

		Book book1 = new Book();

		book1.setImage(book.getImage());
		book1.setCategory(book.getCategory());
		book1.setContent(book.getContent());
		book1.setPublishedDate(book.getPublishedDate());
		book1.setPublisher(book.getPublisher());
		book1.setPrice(book.getPrice());
		book1.setStatus(book.getStatus());

		Author author = new Author();

		// author.setId(book.getAuthorId());
		author.setName(book.getAuthorName());

		book1.setAuthor(author);

		bookRepository.save(book1);

		return book1.getId();
	}

	public List<Sbook> getBooks(String category, Double price, String publisher) {

		List<Sbook> books = bookRepository.getBooks(category, price, publisher);

		return books;

	}

}
