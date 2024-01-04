package com.example.springdatajpa_jdbctemplate.dao;

import com.example.springdatajpa_jdbctemplate.model.Author;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

@Component
public class AuthorDaoImpl implements AuthorDao{

	@Override
	public Author getById(Long id) {
		return null;
	}

	@Override
	public Author findAuthorByName(String firstName, String lastName) {
		return null;
	}

	@Override
	public Author saveNewAuthor(Author author) {
		return null;
	}

	@Override
	public Author updateAuthor(Author author) {
		return null;
	}
	
	public void deleteAuthorById(Long id) {
		
	}

	private RowMapper<Author> getRowMapper() {
		return new AuthorMapper();
	}
}
