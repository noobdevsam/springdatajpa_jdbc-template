package com.example.springdatajpa_jdbctemplate.dao;

import com.example.springdatajpa_jdbctemplate.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class BookDaoImpl implements BookDao {

	private final JdbcTemplate jdbcTemplate;

	public BookDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Book getById(Long id) {
		return jdbcTemplate.queryForObject("select * from book where id = ?", getBookMapper(), id);
	}

	@Override
	public Book findBookByTitle(String title) {
		return jdbcTemplate.queryForObject("select * from book where title = ?", getBookMapper(), title);
	}

	@Override
	public Book saveNewBook(Book book) {
		jdbcTemplate.update("insert into book (isbn, publisher, title, author_id) values (?, ?, ?, ?)", book.getIsbn(), book.getPublisher(), book.getTitle(), book.getAuthorId());
		Long createdId = jdbcTemplate.queryForObject("select last_insert_id()", Long.class);
		return this.getById(createdId);
	}

	@Override
	public Book updateBook(Book book) {
		jdbcTemplate.update("update book set isbn = ?, publisher = ?, title = ?, author_id = ? where id = ?", book.getIsbn(), book.getPublisher(), book.getTitle(), book.getAuthorId(), book.getId());
		return this.getById(book.getId());
	}

	@Override
	public void deleteBookById(Long id) {
		jdbcTemplate.update("delete from book where id = ?", id);
	}

	private BookMapper getBookMapper() {
		return new BookMapper();
	}
}
