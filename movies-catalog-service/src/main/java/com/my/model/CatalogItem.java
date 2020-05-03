package com.my.model;

public class CatalogItem {

	String name;
	String desc;
	int rating;
	
	public CatalogItem(String name, String desc, int age) {
		super();
		this.name = name;
		this.desc = desc;
		this.rating = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
