package com.example.springdatajpa_jdbctemplate.jdbc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import com.example.springdatajpa_jdbctemplate.model.Author;
import com.example.springdatajpa_jdbctemplate.dao.AuthorDaoImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

	@Test
	void testGetAuthorByName() {
		Author author = authorDaoImpl.findAuthorByName("Craig", "Walls");
		assertThat(author).isNotNull();
	}

	@Test
	void testInsertAuthor() {
		Author author = new Author();
		author.setFirstName("sam");
		author.setLastName("kn");

		Author saved = authorDaoImpl.saveNewAuthor(author);
		System.out.println("New id: " + saved.getId());

		assertThat(saved).isNotNull();
	}

	@Test
	void testUpdateAuthor() {
		Author author = new Author();
		author.setFirstName("sam");
		author.setLastName("kni");

		Author saved = authorDaoImpl.saveNewAuthor(author);
		saved.setLastName("knight");
		Author updated = authorDaoImpl.updateAuthor(saved);

		assertThat(updated.getLastName()).isEqualTo("knight");
	}

	@Test
	void testDeleteAuthor() {
		Author author = new Author();
		author.setFirstName("sam");
		author.setLastName("kni");

		Author saved = authorDaoImpl.saveNewAuthor(author);
		authorDaoImpl.deleteAuthorById(saved.getId());

		assertThrows(EmptyResultDataAccessException.class, () -> {
			authorDaoImpl.getById(saved.getId());
		});
	}
}
