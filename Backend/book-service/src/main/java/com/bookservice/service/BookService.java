package com.bookservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.AuthorRepository;
import com.bookservice.BookRepository;
import com.bookservice.MbookRepository;
import com.bookservice.entity.Author;
import com.bookservice.entity.RequestBook;
import com.bookservice.entity.Mbook;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private MbookRepository mbookRepository;

	

	public Integer saveAuthor(Author auth) {
		Author author = authorRepository.save(auth);
		return author.getId();

	}

	public Integer SaveMbook(RequestBook book) {
		Mbook bk = new Mbook();
		bk.setCategory(book.getCategory());
		bk.setContent(book.getContent());
		bk.setImage(book.getImage());
		bk.setPrice(book.getPrice());
		bk.setPublishedDate(book.getPublishedDate());
		bk.setPublisher(book.getPublisher());
		bk.setStatus(book.getStatus());
		bk.setTitle(book.getTitle());

		Author auth = authorRepository.findByName(book.getAuthor());
		bk.setAuthor(auth);

		Mbook mbook = mbookRepository.save(bk);

		return mbook.getId();

	}

}
