package com.poc2.jpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc2.jpa.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	User findByUsername(String username);

}
