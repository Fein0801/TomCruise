package com.movie_phoenix.MoviePhoenix.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie_phoenix.MoviePhoenix.entity.FavsActor;
import com.movie_phoenix.MoviePhoenix.service.GoogleUser;

public interface FavActorRepo extends JpaRepository<FavsActor, Integer> {
	
	List<FavsActor> findByUser(GoogleUser user);
}
