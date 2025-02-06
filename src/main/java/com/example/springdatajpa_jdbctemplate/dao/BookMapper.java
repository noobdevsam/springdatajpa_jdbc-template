package com.example.springdatajpa_jdbctemplate.dao;

import org.springframework.jdbc.core.RowMapper;
import com.example.springdatajpa_jdbctemplate.model.Book;
import java.sql.*;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setId(rs.getLong(1));
		book.setIsbn(rs.getString(2));
		book.setPublisher(rs.getString(3));
		book.setTitle(rs.getString(4));
		book.setAuthorId(rs.getLong(5));
		return book;
	}
}
