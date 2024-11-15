package com.probtp.projet1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.probtp.projet1.model.Adherent;

// See: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

public interface AdherentDao extends CrudRepository<Adherent, Integer> {

	// JPQL: Rechercher les adhérents par nom
	//On raisonne par Entity
    @Query("SELECT a FROM Adherent a WHERE a.nom = :nom")
    List<Adherent> findByNomWithJPQL(@Param("nom") String nom);
    
    // Native Query: Trouver les adhérents par prénom
    //TABLE adherent (SQL natif)
    @Query(value = "SELECT * FROM adherent WHERE prenom = :prenom", nativeQuery = true)
    List<Adherent> findByPrenomNative(@Param("prenom") String prenom);
    
    // Recherche par un attribut
    List<Adherent> findByNom(String nom); // Cherche tous les adhérents avec un nom donné
    
    // Recherche combinée
    List<Adherent> findByNomAndPrenom(String nom, String prenom); // Adhérents avec nom et prénom correspondants

    @Query("SELECT a FROM Adherent a WHERE a.nom = :nom AND a.prenom = :prenom")
    List<Adherent> findByNomAndPrenomWithJPQL(String nom, String prenom);
    
    long countByNom(String nom);
    
    void deleteByNom(String nom); 
    
 // Recherche par motifs (LIKE)
    List<Adherent> findByNomContaining(String substring); // Nom contenant une sous-chaîne
    List<Adherent> findByNomStartingWith(String prefix); // Nom commençant par un préfixe
    List<Adherent> findByNomEndingWith(String suffix); // Nom se terminant par un suffixe

    
    // Recherche avec tri
    List<Adherent> findByNomOrderByPrenomAsc(String nom); // Adhérents avec un nom donné, triés par prénom croissant
    List<Adherent> findByNomOrderByPrenomDesc(String nom); // Adhérents avec un nom donné, triés par prénom décroissant

}
