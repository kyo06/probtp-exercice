package com.probtp.projet1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.probtp.projet1.dao.AdherentDao;
import com.probtp.projet1.dao.ContactDao;
import com.probtp.projet1.model.Adherent;
import com.probtp.projet1.model.Contact;

@Service
public class ContactService {
	
	@Autowired
	private ContactDao contactDao;
	
	@Autowired
	private AdherentDao adherentDao;
	
	public List<Contact> getAllContacts() {
		return (List<Contact>) contactDao.findAll();
	}
	
	public Optional<Contact> getContact(int id) {
		return contactDao.findById(id);
	}
	
	public void addContact(Contact c, int idAdherent) throws Exception {
		c.setId(null);
		c.setDocuments(List.of()); //mettre une liste vide
		Optional<Adherent> ad = adherentDao.findById(idAdherent);
		if(ad.isEmpty()) {
			throw new Exception("Adherent id = " + idAdherent + " non existant");
		} else {
			c.setAdherent(ad.get());
			contactDao.save(c);			
		}
	}
}
