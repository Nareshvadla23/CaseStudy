package com.bookservice.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bookservice.dto.PaymentMode;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Payment {

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id", referencedColumnName = "id")
	private Book book;
	private String userMail;
	private String userName;
	private LocalDate paymentDate;
	private PaymentMode paymentMode;
}
