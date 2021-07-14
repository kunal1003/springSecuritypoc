package com.poc2.jpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc2.jpa.example.model.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {

}
