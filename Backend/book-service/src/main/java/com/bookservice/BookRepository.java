package com.bookservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookservice.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
