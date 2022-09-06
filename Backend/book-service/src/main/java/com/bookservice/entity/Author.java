package com.bookservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Author {
	
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message = "Name should not be blank")
	private String name;
	@NotBlank(message = "Mail should not be blank")
	private String mail;
	@NotBlank(message = "Password should not be blank")
	private String password;	
}
