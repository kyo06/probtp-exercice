package com.probtp.projet1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.probtp.projet1.dao.ContactDao;
import com.probtp.projet1.dao.DocumentDao;
import com.probtp.projet1.model.Contact;
import com.probtp.projet1.model.Document;

@Service
public class DocumentService {
	
	@Autowired
	private DocumentDao documentDao;
	
	@Autowired
	private ContactDao contactDao;
	
	public Optional<Document> getDocument(int id) {
		return documentDao.findById(id);
	}
	
	//Approche OnToMany => non optimisé	
	/*
	public void addDocument(Document d, int idContact) {
		d.setId(null);
		
		Optional<Contact> oc = contactDao.findById(idContact);
		if(oc.isPresent()) {
			Contact c = oc.get();
			c.getDocuments().add(d);			
			documentDao.save(d);
		}		
	}
	*/
	
	//Approche ManyToOne => optimisé	
	public void addDocument(Document d, int idContact) {
		d.setId(null);
		
		Optional<Contact> oc = contactDao.findById(idContact);
		if(oc.isPresent()) {
			Contact c = oc.get();
			d.setContact(c);
			documentDao.save(d);
		}
	}
}
