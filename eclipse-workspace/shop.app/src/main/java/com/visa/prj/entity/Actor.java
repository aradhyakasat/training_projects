package com.visa.prj.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {
	@Id                         //for marking as primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //applicable only for integers
	private int id;
	
	private String name;
	
	@ManyToMany(mappedBy="actors")     //to let JPA know the link
	private List<Movie> movies=new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	

}
