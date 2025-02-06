package com.example.springdatajpa_jdbctemplate.dao;

import org.springframework.jdbc.core.RowMapper;
import com.example.springdatajpa_jdbctemplate.model.Author;
import java.sql.*;

public class AuthorMapper implements RowMapper<Author> {

	@Override
	public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
		Author author = new Author();
		author.setId(rs.getLong("id"));
		author.setFirstName(rs.getString("first_name"));
		author.setLastName(rs.getString("last_name"));
		return author;
	}
}
