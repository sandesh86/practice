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

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
				
		UserRatings userRatings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRatings.class);
		List<Rating> ratings = userRatings.getRatings();
//		List<Rating> ratings = Arrays.asList(
//				new Rating("1234", 4),
//				new Rating("5678", 6)
//		);
		
		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
			
			return new CatalogItem(movie.getMovieName(), "Best movie of Batman", rating.getRatings());			
		}).collect(Collectors.toList());
		
		//return Collections.singletonList(new CatalogItem("Dark Knight", "Best movie of Batman", 9));
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
