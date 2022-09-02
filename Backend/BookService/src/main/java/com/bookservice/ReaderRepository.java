package com.bookservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookservice.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {

}
