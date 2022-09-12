package com.bookservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.BookRepository;
import com.bookservice.dto.Category;
import com.bookservice.dto.ResponseDto;
import com.bookservice.dto.Status;
import com.bookservice.entity.Book;

@Service
public class ReaderService {

	@Autowired
	private BookRepository bookRepository;

	public static List<ResponseDto> ResponseBooks(List<Book> books) {
		List<ResponseDto> responseBooks = new ArrayList<>();
		for (Book book : books) {

			ResponseDto responseBook = new ResponseDto();
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

	public List<ResponseDto> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		System.out.println(books.size());
		List<ResponseDto> responseBooks = ResponseBooks(books);
		System.out.println(responseBooks.size());
		return responseBooks;
	}

	public List<ResponseDto> getBookByPrice(Double price) {
		List<Book> books = bookRepository.findByPrice(price);

		List<ResponseDto> responseBooks = ResponseBooks(books);

		return responseBooks;

	}

	public List<ResponseDto> getBookByAuthor(String name) {
		List<Book> books = bookRepository.findByAuthor(name);
		List<ResponseDto> responseBooks = ResponseBooks(books);
		return responseBooks;
	}

	public List<ResponseDto> getBookByCategory(Category category) {
		List<Book> books = bookRepository.findByCategory(category);
		List<ResponseDto> responseBooks = ResponseBooks(books);
		return responseBooks;
	}

}
