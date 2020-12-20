package com.erbatyr.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title, anons, full_text;
	private int views;

	public Article() {
	}

	public Article(String title, String anons, String full_text) {
		this.title = title;
		this.anons = anons;
		this.full_text = full_text;
	}

	public Long getId() {
		return id;
	}

	public String getAnons() {
		return anons;
	}

	public int getViews() {
		return views;
	}

	public String getFull_text() {
		return full_text;
	}

	public String getTitle() {
		return title;
	}

	public void setAnons(String anons) {
		this.anons = anons;
	}

	public void setFull_text(String full_text) {
		this.full_text = full_text;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setViews(int views) {
		this.views = views;
	}
}
