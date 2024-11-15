package com.probtp.projet1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.probtp.projet1.dao.AdherentDao;
import com.probtp.projet1.model.Adherent;

@Service
public class AdherentService {
	
	@Autowired
	private AdherentDao adherentDao;
	
	public List<Adherent> getAllAdherents() {
		return (List<Adherent>) adherentDao.findAll();
	}
	
}
