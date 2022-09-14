package com.bookservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.AuthorRepository;
import com.bookservice.BookRepository;
import com.bookservice.dto.Category;
import com.bookservice.dto.ResponseDto;
import com.bookservice.dto.Status;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;

@Service
public class ReaderService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;

	public static List<ResponseDto> ResponseBooks(List<Book> books) {
		List<ResponseDto> responseBooks = new ArrayList<>();
		for (Book book : books) {

			ResponseDto responseBook = new ResponseDto();
			responseBook.setAuthor(book.getAuthor().getName());
			responseBook.setCategory(book.getCategory());
			responseBook.setImage(book.getImage());
			responseBook.setPrice(book.getPrice());
			responseBook.setPublishedDate(book.getPublishedDate());
			responseBook.setPublisher(book.getPublisher());
			responseBook.setTitle(book.getTitle());
			responseBooks.add(responseBook);
		}

		return responseBooks;
	}

	public List<ResponseDto> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		List<ResponseDto> responseBooks = ResponseBooks(books);
		return responseBooks;
	}

	public List<ResponseDto> getBookByPrice(Double price) {
		List<Book> books = bookRepository.findByPrice(price);
		List<ResponseDto> responseBooks = ResponseBooks(books);
		return responseBooks;

	}

	public List<ResponseDto> getBookByAuthor(String name) {
		
		Author author = authorRepository.findByName(name);
		
		List<Book> books = bookRepository.findByAuthor(author);
		List<ResponseDto> responseBooks = ResponseBooks(books);
		return responseBooks;
	}

	public List<ResponseDto> getBookByCategory(Category category) {
		List<Book> books = bookRepository.findByCategory(category);
		List<ResponseDto> responseBooks = ResponseBooks(books);
		return responseBooks;
	}

}
