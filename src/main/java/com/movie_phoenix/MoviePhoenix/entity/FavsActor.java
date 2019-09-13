package com.movie_phoenix.MoviePhoenix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FavsActor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private Integer UserId;
	private Integer EntryId;
	private String name;
	private String birthday;
	
	public FavsActor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public FavsActor(Integer id, Integer userId, Integer entryId, String name, String birthday) {
		super();
		Id = id;
		UserId = userId;
		EntryId = entryId;
		this.name = name;
		this.birthday = birthday;
	}
	


	public FavsActor(Integer userId, Integer entryId, String name, String birthday) {
		super();
		UserId = userId;
		EntryId = entryId;
		this.name = name;
		this.birthday = birthday;
	}


	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public Integer getEntryId() {
		return EntryId;
	}

	public void setEntryId(Integer entryId) {
		EntryId = entryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "FavsActor [Id=" + Id + ", UserId=" + UserId + ", EntryId=" + EntryId + ", name=" + name + ", birthday="
				+ birthday + "]";
	}

	

	
	
	
}
