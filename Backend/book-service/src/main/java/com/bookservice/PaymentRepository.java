package com.bookservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	public List<Payment> findByUserMail(String userMail);
	

}
