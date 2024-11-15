package com.probtp.projet1.controller;

import java.util.List;

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

import com.probtp.projet1.model.Adherent;
import com.probtp.projet1.model.Contact;
import com.probtp.projet1.service.AdherentService;
import com.probtp.projet1.service.ContactService;


@RestController
@RequestMapping("/adherents")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdherentController {
	@Autowired
	private AdherentService adherentService;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("")
	public List<Adherent> getAllAdherents() {
		return adherentService.getAllAdherents();
	}
	
	

	@PostMapping("/{idAdherent}/contacts")
	public ResponseEntity<String> insertContact(@RequestBody Contact c, @PathVariable int idAdherent) {
		try {
			contactService.addContact(c, idAdherent);
			return ResponseEntity
					.status(HttpStatus.CREATED).body("success");
		} catch(Exception ex) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT).body(ex.getMessage());			
		}
	}
}
