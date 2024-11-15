package com.probtp.projet1.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Contact implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Date dateContact;
	@Column
	@Enumerated(EnumType.STRING)
	private TypeContactEnum typeContact;
	
	@ManyToOne
	@JsonIgnore
	private Adherent adherent;
	
	@OneToMany
	//Obligatoire de l'initialiser
	private List<Document> documents = new ArrayList<>();
}
