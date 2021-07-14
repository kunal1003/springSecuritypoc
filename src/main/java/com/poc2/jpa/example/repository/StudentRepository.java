package com.poc2.jpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc2.jpa.example.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
}
