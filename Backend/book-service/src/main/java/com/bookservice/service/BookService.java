package com.bookservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.AuthorRepository;
import com.bookservice.BookRepository;
import com.bookservice.dto.LoginDto;
import com.bookservice.dto.RequestDto;
import com.bookservice.dto.ResponseDto;
import com.bookservice.dto.Status;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;

@Service
public class BookService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	public Integer saveAuthor(Author auth) {
		Author author = authorRepository.save(auth);
		return author.getId();
	}

	public Book updateBook(RequestDto requestDto, Integer bookId) {

		Optional<Book> optionalBook = bookRepository.findById(bookId);
		Book book = optionalBook.get();
		if (optionalBook.isPresent()) {
			book.setCategory(requestDto.getCategory());
			book.setContent(requestDto.getContent());
			book.setImage(requestDto.getImage());
			book.setPrice(requestDto.getPrice());
			book.setPublishedDate(requestDto.getPublishedDate());
			book.setPublisher(requestDto.getPublisher());
			book.setTitle(requestDto.getTitle());
			book.setStatus(requestDto.getStatus());
		} else {
			throw new NullPointerException("No Book Found with BookID:" + bookId);
		}
		Book savedBook = bookRepository.save(book);
		return savedBook;
	}

	public Author loginAuthor(LoginDto login) {
		Author author = authorRepository.findByMailId(login.getMailId());
		return author;
	}

	public Integer savebook(RequestDto requestDto) {
		Book book = new Book();

		String image = requestDto.getImage();

		book.setCategory(requestDto.getCategory());
		book.setContent(requestDto.getContent());
		book.setImage(image);
		book.setPrice(requestDto.getPrice());
		book.setPublishedDate(requestDto.getPublishedDate());
		book.setPublisher(requestDto.getPublisher());
		book.setStatus(requestDto.getStatus());
		book.setTitle(requestDto.getTitle());
		Author author = authorRepository.findByName(requestDto.getAuthor());
		book.setAuthor(author);
		Book book1 = bookRepository.save(book);
		return book1.getId();
	}

	public List<ResponseDto> BooksbyAuthorId(Integer authorId) {
		Optional<Author> author = authorRepository.findById(authorId);
		List<Book> books = bookRepository.findByAuthor(author.get()); 
		List<ResponseDto> responseBooks = new ArrayList<>(); 
		for (Book book : books) {
			if (book.getStatus().equals(Status.ACTIVE)) {
				ResponseDto responseBook = new ResponseDto(); 
				responseBook.setCategory(book.getCategory());
				responseBook.setPrice(book.getPrice());
				responseBook.setPublishedDate(book.getPublishedDate());
				responseBook.setPublisher(book.getPublisher());
				responseBook.setTitle(book.getTitle());
				responseBook.setAuthor(book.getAuthor().getName());
				responseBook.setImage(book.getImage());
				responseBooks.add(responseBook);
			}
		}
		return responseBooks;
	}

}
