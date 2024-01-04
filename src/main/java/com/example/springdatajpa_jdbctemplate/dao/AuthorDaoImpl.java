package com.example.springdatajpa_jdbctemplate.dao;

import com.example.springdatajpa_jdbctemplate.model.Author;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.*;

@Component
public class AuthorDaoImpl implements AuthorDao{

	private final JdbcTemplate jdbcTemplate;

	public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Author getById(Long id) {
		return jdbcTemplate.queryForObject("select * from author where id = ?", getRowMapper(), id);
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
