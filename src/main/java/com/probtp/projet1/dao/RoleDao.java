package com.probtp.projet1.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.probtp.projet1.model.Role;

// See: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
public interface RoleDao extends CrudRepository<Role, Integer> {
	Optional<Role> findByName(String name);
}
