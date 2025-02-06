package com.example.springdatajpa_jdbctemplate.repository;

import com.example.springdatajpa_jdbctemplate.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long>{
	
}
