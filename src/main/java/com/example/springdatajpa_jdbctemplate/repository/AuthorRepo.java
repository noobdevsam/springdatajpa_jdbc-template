package com.example.springdatajpa_jdbctemplate.repository;

import com.example.springdatajpa_jdbctemplate.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long>{
	
}
