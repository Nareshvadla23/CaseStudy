package com.bookservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.AuthorRepository;
import com.bookservice.BookRepository;
import com.bookservice.MbookRepository;
import com.bookservice.entity.RequestBook;
import com.bookservice.entity.ResponseBook;
import com.bookservice.entity.Author;
import com.bookservice.entity.Mbook;

@Service
public class ReaderService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private MbookRepository mbookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	public List<ResponseBook> getAllBooks() throws Exception {
		List<Mbook> books = bookRepository.findAll();

		List<ResponseBook> list = new ArrayList<>();

		for (Mbook mb : books) {
			ResponseBook b1 = new ResponseBook();
			b1.setCategory(mb.getCategory());
			b1.setPrice(mb.getPrice());
			b1.setPublisherDate(mb.getPublishedDate());
			b1.setPublisher(mb.getPublisher());
			b1.setTitle(mb.getTitle());
			Optional<Author> au = authorRepository.findById(mb.getAuthor().getId());

			if (au.isPresent()) {
				b1.setAuthor(au.get().getName());
			} else {
				throw new Exception("Author Not found");
			}
			b1.setImage(mb.getImage());
			list.add(b1);
		}
		return list;

	}

	public List<ResponseBook> getBookByPrice(Double price) throws Exception {
		List<Mbook> mb = mbookRepository.findByPrice(price);

		List<ResponseBook> list = new ArrayList<>();

		for (Mbook mbo : mb) {
			ResponseBook b1 = new ResponseBook();
			// b1.setAuthor(mb.getAuthor().getName());
			b1.setCategory(mbo.getCategory());
			b1.setPrice(mbo.getPrice());
			b1.setPublisherDate(mbo.getPublishedDate());
			b1.setPublisher(mbo.getPublisher());
			b1.setTitle(mbo.getTitle());
			Optional<Author> au = authorRepository.findById(mbo.getAuthor().getId());

			if (au.isPresent()) {
				b1.setAuthor(au.get().getName());
			} else {
				throw new Exception("Author Not found");
			}
			b1.setImage(mbo.getImage());
			list.add(b1);

		}

		return list;

	}

	public List<ResponseBook> getBookByTitle(String name) throws Exception {
		List<Mbook> mb = mbookRepository.findByTitle(name);

		List<ResponseBook> list = new ArrayList<>();

		for (Mbook mbo : mb) {
			ResponseBook b1 = new ResponseBook();
			// b1.setAuthor(mb.getAuthor().getName());
			b1.setCategory(mbo.getCategory());
			b1.setPrice(mbo.getPrice());
			b1.setPublisherDate(mbo.getPublishedDate());
			b1.setPublisher(mbo.getPublisher());
			b1.setTitle(mbo.getTitle());
			Optional<Author> au = authorRepository.findById(mbo.getAuthor().getId());

			if (au.isPresent()) {
				b1.setAuthor(au.get().getName());
			} else {
				throw new Exception("Author Not found");
			}
			b1.setImage(mbo.getImage());
			list.add(b1);

		}

		return list;

	}

	public List<ResponseBook> getBookByCategory(String name) throws Exception {
		List<Mbook> mb = mbookRepository.findByCategory(name);

		List<ResponseBook> list = new ArrayList<>();

		for (Mbook mbo : mb) {
			ResponseBook b1 = new ResponseBook();
			// b1.setAuthor(mb.getAuthor().getName());
			b1.setCategory(mbo.getCategory());
			b1.setPrice(mbo.getPrice());
			b1.setPublisherDate(mbo.getPublishedDate());
			b1.setPublisher(mbo.getPublisher());
			b1.setTitle(mbo.getTitle());
			Optional<Author> au = authorRepository.findById(mbo.getAuthor().getId());

			if (au.isPresent()) {
				b1.setAuthor(au.get().getName());
			} else {
				throw new Exception("Author Not found");
			}
			b1.setImage(mbo.getImage());
			list.add(b1);

		}

		return list;

	}

}
