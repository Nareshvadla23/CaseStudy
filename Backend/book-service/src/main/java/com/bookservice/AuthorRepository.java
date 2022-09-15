package com.bookservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookservice.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	public Author findByName(String name);

	public Author findByMailId(String mailId);

}
