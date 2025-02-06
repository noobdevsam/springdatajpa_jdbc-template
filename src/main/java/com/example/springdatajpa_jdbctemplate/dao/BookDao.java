package com.example.springdatajpa_jdbctemplate.dao;

import com.example.springdatajpa_jdbctemplate.model.Book;

public interface BookDao {
	Book getById(Long id);
	Book findBookByTitle(String title);
	Book saveNewBook(Book book);
	Book updateBook(Book book);
	void deleteBookById(Long id);
}
