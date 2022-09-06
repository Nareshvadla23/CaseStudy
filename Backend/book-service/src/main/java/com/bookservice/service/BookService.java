package com.bookservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.AuthorRepository;
import com.bookservice.MbookRepository;
import com.bookservice.entity.Author;
import com.bookservice.entity.Book;
import com.bookservice.entity.RequestBook;

@Service
public class BookService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private MbookRepository mbookRepository;

	public Integer saveAuthor(Author auth) {
		Author author = authorRepository.save(auth);
		return author.getId();

	}

	public Integer loginAuthor(String mail, String password) {

		Author author = authorRepository.findByMail(mail);
		if (author.getPassword().equals(password)) {
			return author.getId();
		} else {
			return 0;
		}
	}

	public Integer SaveMbook(RequestBook book) {
		Book bk = new Book();
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
		Book mbook = mbookRepository.save(bk);
		return mbook.getId();
	}

}
