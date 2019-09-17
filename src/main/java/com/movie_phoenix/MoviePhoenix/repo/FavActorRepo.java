package com.movie_phoenix.MoviePhoenix.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movie_phoenix.MoviePhoenix.entity.FavsActor;
import com.movie_phoenix.MoviePhoenix.service.GoogleUser;

public interface FavActorRepo extends JpaRepository<FavsActor, Integer> {
	List<FavsActor> findByUser(GoogleUser user);
	
	@Query(value = "select * from fav_actor where actor_id=? and user_id_fk=?", nativeQuery = true)
	List<FavsActor> findByUserAndActor(Integer actorId, Integer userId);
}
