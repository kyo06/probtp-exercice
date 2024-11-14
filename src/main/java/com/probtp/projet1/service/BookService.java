package com.probtp.projet1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.probtp.projet1.dao.BookDaoJPA;
import com.probtp.projet1.model.Book;

@Service
public class BookService {
	
	@Autowired
	//private BookDaoJDBC bookDao;
	private BookDaoJPA bookDao;
	
	public List<Book> getAllBooks() {
		return (List<Book>) bookDao.findAll();
	}
	
	public Book insertBook(Book b) {
		b.setId(null);
		return bookDao.save(b);
	}
	
	public Book updateBook(Book b, int id) {
		b.setId(id);
		return bookDao.save(b);
	}
	
	public void deleteBook(int id) {
		bookDao.deleteById(id);
	}
	
	public Book getBookById(int id) {
		Optional<Book> b = bookDao.findById(id);
		if(b.isPresent()) {
			return b.get();
		}
		return null;
	}
}
