package com.question.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "User")
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;

}
