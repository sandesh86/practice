package com.my.model;

public class Movie {

	private String movieId;
	private String title;
	private String desc;
	
	public Movie() {
	}

	public Movie(String movieId, String title, String desc) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.desc = desc;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
