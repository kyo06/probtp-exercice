package com.probtp.projet1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.probtp.projet1.model.Book;

@Repository
public class BookDaoJDBC {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Book> findAll() {
		String query = "SELECT id, title, author, contenu FROM book";
		List<Book> myList = jdbcTemplate.query(query, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setContenu(rs.getString("contenu"));
                return book;
            }
        });
		return myList;
	}
}
