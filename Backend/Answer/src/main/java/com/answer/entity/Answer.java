package com.answer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Answer {

	@Id
	@GeneratedValue
	private Integer id;
	private String answerz;
	@ManyToOne
	@JoinColumn(name="fkuid")
	private User user;
	@ManyToOne
	@JoinColumn(name="fkqid")
	private Question question;

}
