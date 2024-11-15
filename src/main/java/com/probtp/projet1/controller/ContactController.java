package com.probtp.projet1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.probtp.projet1.model.Contact;
import com.probtp.projet1.model.Document;
import com.probtp.projet1.service.ContactService;
import com.probtp.projet1.service.DocumentService;


@RestController
@RequestMapping("/contacts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private DocumentService documentService;
	
	@GetMapping("")
	public List<Contact> getAllContacts() {
		return contactService.getAllContacts();
	}
	
	@GetMapping("/{id}")
	public Contact getContactById(@PathVariable int id) throws ResponseStatusException {
		Optional<Contact> c = contactService.getContact(id);
		if(c.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ressource not found");
			//throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Ressource not found");
		}
		return c.get(); //ResponseEntity.ok(b)
	}
	
	@PostMapping("/{idContact}/documents")
	public ResponseEntity<String> insertDocument(@RequestBody Document d, @PathVariable int idContact) {
		try {
			documentService.addDocument(d, idContact);
			return ResponseEntity
					.status(HttpStatus.CREATED).body("success");
		} catch(Exception ex) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT).body(ex.getMessage());			
		}
	}
}
