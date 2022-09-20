package com.bookservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Author {

	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message = "Name should not be blank")
	private String name;
	@NotBlank(message = "Mail should not be blank")
	private String mailId;
	@NotBlank(message = "Password should not be blank")
	private String password;
}
