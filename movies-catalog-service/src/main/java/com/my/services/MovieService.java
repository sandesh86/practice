package com.my.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.my.model.CatalogItem;
import com.my.model.Movie;
import com.my.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);			
		return new CatalogItem(movie.getTitle(), movie.getDesc(), rating.getRatings());
	}
	
	public CatalogItem getFallbackCatalogItem(Rating rating) {
		return new CatalogItem("Movie name not found", "", 0);
	}
}
