package com.probtp.projet1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.probtp.projet1.dao.BookDaoJDBC;
import com.probtp.projet1.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDaoJDBC bookDao;
	
	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}
}
