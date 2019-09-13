package com.movie_phoenix.MoviePhoenix.entity.movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FavsMovie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
}
