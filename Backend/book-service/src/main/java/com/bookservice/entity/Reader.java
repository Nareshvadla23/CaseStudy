package com.bookservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Reader {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String mail;

	
	
}
