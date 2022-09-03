package com.bookservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookservice.entity.Mbook;

public interface BookRepository extends JpaRepository<Mbook, Integer>{
	
	
	
}
