package com.probtp.projet1.dao;

import org.springframework.data.repository.CrudRepository;

import com.probtp.projet1.model.Contact;

public interface ContactDao extends CrudRepository<Contact, Integer> {

}
