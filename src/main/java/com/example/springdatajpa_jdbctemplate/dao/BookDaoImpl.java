package com.example.springdatajpa_jdbctemplate.dao;

import com.example.springdatajpa_jdbctemplate.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.*;

@Component
public class BookDaoImpl implements BookDao {

	@Override
	public Book getById(Long id) {
		return null;
	}

	@Override
	public Book findBookByTitle(String title) {
		return null;
	}

	@Override
	public Book saveNewBook(Book book) {
		return null;
	}

	@Override
	public Book updateBook(Book book) {
		return null;
	}

	@Override
	public void deleteBookById(Long id) {
		
	}
}
