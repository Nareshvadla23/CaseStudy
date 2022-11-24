package com.answer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Question")
@Setter
@Getter
public class Question {

	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String description;
	@ManyToOne
	@JoinColumn(name="fkuid")
	private User user;

}
