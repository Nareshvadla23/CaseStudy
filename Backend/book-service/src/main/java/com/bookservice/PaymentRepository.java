package com.bookservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
