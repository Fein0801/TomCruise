package com.movie_phoenix.MoviePhoenix.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie_phoenix.MoviePhoenix.entity.FavsActor;

public interface FavActorRepo extends JpaRepository<FavsActor, Integer> {
}
