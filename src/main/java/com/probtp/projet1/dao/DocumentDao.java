package com.probtp.projet1.dao;

import org.springframework.data.repository.CrudRepository;

import com.probtp.projet1.model.Document;

public interface DocumentDao extends CrudRepository<Document, Integer> {

}
