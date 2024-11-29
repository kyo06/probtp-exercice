package com.probtp.projet1.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.probtp.projet1.model.User;

// See: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
public interface UserDao extends CrudRepository<User, Integer> {
	Optional<User> findByUsername(String username);
	Optional<User> findByUsernameOrEmail(String username, String email);
}
