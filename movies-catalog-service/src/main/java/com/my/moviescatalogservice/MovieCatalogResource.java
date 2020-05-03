package com.my.moviescatalogservice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.my.model.CatalogItem;
import com.my.model.Movie;
import com.my.model.Rating;
import com.my.model.UserRatings;
import com.my.services.MovieService;
import com.my.services.RatingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private RatingService ratingService;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
				
		UserRatings userRatings = ratingService.getUserRating(userId);
		
		return userRatings.getRatings().stream()
				.map(rating -> movieService.getCatalogItem(rating))
				.collect(Collectors.toList());		
	}
	
}


/*
	 Movie movie = webClientBuilder
		.build()
		.get()
		.uri("http://movie-info-service/movies/" + rating.getMovieId())
		.retrieve()
		.bodyToMono(Movie.class)
		.block();
*/
