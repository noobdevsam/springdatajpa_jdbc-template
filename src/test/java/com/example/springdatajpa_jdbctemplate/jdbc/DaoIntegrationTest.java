package com.example.springdatajpa_jdbctemplate.jdbc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springdatajpa_jdbctemplate.model.Author;
import com.example.springdatajpa_jdbctemplate.dao.AuthorDaoImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ComponentScan(basePackages = {"com.example.springdatajpa_jdbctemplate"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoIntegrationTest {

	@Autowired
	AuthorDaoImpl authorDaoImpl;

	@Test
	void testGetAuthorById() {
		Author athr = authorDaoImpl.getById(1L);
		assertThat(athr.getId()).isNotNull();
	}
}
