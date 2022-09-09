package com.bookservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.AuthorRepository;
import com.bookservice.BookRepository;
import com.bookservice.dto.LoginDto;
import com.bookservice.dto.RequestDto;
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

	public Author loginAuthor(LoginDto login) {
		Author author = authorRepository.findByMailId(login.getMailId());
		return author;
	}

	public Integer savebook(RequestDto requestDto) {
		Book book = new Book();
		book.setCategory(requestDto.getCategory());
		book.setContent(requestDto.getContent());
		book.setImage(requestDto.getImage()); 
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

}
