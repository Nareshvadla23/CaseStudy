package com.bookservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Author {
	
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message = "Name should not be blank")
	private String name;
	private String mail;
	private String password;
	

	//@OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
	//@JoinColumn(name ="author_fk",referencedColumnName = "id")
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
