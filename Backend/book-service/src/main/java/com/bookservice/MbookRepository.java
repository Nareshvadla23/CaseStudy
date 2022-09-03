package com.bookservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookservice.entity.Mbook;

public interface MbookRepository extends JpaRepository<Mbook, Integer> {
	
	
	//public List<Mbook> findByName(String name);
	
	public List<Mbook> findByCategory(String name);
	
	public List<Mbook> findByPrice(Double price);
	

}
