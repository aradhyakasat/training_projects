package com.visa.prj.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Movie {
	@Id                         //for marking as primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //applicable only for integers
	private int id;
	
	private String name;
	@ManyToMany (cascade=CascadeType.PERSIST) 						//link table is required for many to many
	@JoinTable(name="MOVIE_ACTOR",inverseJoinColumns= {
			@JoinColumn(name="AID")
	},joinColumns= {
			@JoinColumn(name="MID")
	})
	private List <Actor> actors=new ArrayList<>();
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
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	

}
