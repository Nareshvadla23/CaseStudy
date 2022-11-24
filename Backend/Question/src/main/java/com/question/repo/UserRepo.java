package com.question.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.question.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
