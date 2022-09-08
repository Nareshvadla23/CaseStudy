package com.bookservice.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookservice.MbookRepository;
import com.bookservice.entity.Book;
import com.bookservice.entity.ResponseBook;

@Service
public class ReaderService {

	@Autowired
	private MbookRepository bookRepository;

	public static List<ResponseBook> ResponseBooks(List<Book> books) {
		List<ResponseBook> responseBooks = new ArrayList<>();
		for (Book book : books) {
			ResponseBook responseBook = new ResponseBook();
			responseBook.setCategory(book.getCategory());
			responseBook.setPrice(book.getPrice());
			responseBook.setPublisherDate(book.getPublishedDate());
			responseBook.setPublisher(book.getPublisher());
			responseBook.setTitle(book.getTitle());
			responseBook.setAuthor(book.getAuthor().getName());
			responseBook.setImage(book.getImage());
			responseBooks.add(responseBook);
		}
		return responseBooks;
	}

	public List<ResponseBook> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		List<ResponseBook> responseBooks = ResponseBooks(books);
		return responseBooks;
	}

	public List<ResponseBook> getBookByPrice(Double price) {
		List<Book> books = bookRepository.findByPrice(price);
		List<ResponseBook> responseBooks = ResponseBooks(books);
		return responseBooks;
	}

	public List<ResponseBook> getBookByTitle(String name) {
		List<Book> books = bookRepository.findByTitle(name);
		List<ResponseBook> responseBooks = ResponseBooks(books);
		return responseBooks;
	}

	public List<ResponseBook> getBookByCategory(String name) {
		List<Book> books = bookRepository.findByCategory(name);
		List<ResponseBook> responseBooks = ResponseBooks(books);
		return responseBooks;
	}

}
