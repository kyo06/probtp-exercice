package com.probtp.projet1.dao;

import org.springframework.data.repository.CrudRepository;

import com.probtp.projet1.model.Book;

public interface BookDaoJPA extends CrudRepository<Book, Integer> {

}
