package com.movie_phoenix.MoviePhoenix.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie_phoenix.MoviePhoenix.service.GoogleUser;

public interface UserRepo extends JpaRepository<GoogleUser, Integer> {
	boolean existsByEmail(String email);
	boolean existsByName(String name);
	GoogleUser findByEmail(String email);
	GoogleUser findByName(String name);
}
