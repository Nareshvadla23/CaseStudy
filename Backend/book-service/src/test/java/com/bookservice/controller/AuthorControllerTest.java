package com.bookservice.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bookservice.AuthorRepository;
import com.bookservice.dto.LoginDto;
import com.bookservice.entity.Author;
import com.bookservice.service.BookService;
import com.bookservice.service.ReaderService;
@ExtendWith(MockitoExtension.class)
class AuthorControllerTest {
	@Mock
	BookService service;

	@Mock
	ReaderService Rservice;

	@Mock
	PasswordEncoder encoder;
	
	@Mock
	AuthorRepository authorRepository;

	@InjectMocks
	AuthorController control;
	@InjectMocks
	ReaderController readerController;
	
	

	public static Author author() {
		Author author = new Author();
		author.setId(1);
		author.setMailId("naresh@gmail.com");
		author.setName("naresh");
		author.setPassword("naresh@23");
		return author;
	}

	@Test
	void testLoginAuthor() {
		Author author = author();
		LoginDto login = new LoginDto();
		login.setMailId("naresh@gmail.com");
		login.setPassword("naresh@23");
		when(encoder.matches(login.getPassword(), author.getPassword())).thenReturn(true);
		when(service.loginAuthor(login)).thenReturn(author);
		ResponseEntity<?> response = control.loginAuthor(login);
		assertEquals(ResponseEntity.ok(author), response);
	}

	@Test
	void testSaveAuthor() { 
		Author author = author();
		Author auth1 = new Author();
		when(encoder.encode(author.getPassword())).thenReturn("password");
		when(service.saveAuthor(author)).thenReturn(author);
		ResponseEntity<?> response = control.saveAuthor(author);
		assertEquals(ResponseEntity.ok(author), response);
	}
}
