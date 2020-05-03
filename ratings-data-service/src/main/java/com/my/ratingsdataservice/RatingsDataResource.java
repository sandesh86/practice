package com.my.ratingsdataservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.model.Rating;
import com.my.model.UserRatings;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

	@RequestMapping("/{movieId}")
	public Rating getRatingsData(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRatings getRatings(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("100", 4),
				new Rating("200", 3)
		);
		UserRatings userRatings = new UserRatings();
		userRatings.setRatings(ratings);
		return userRatings;
	}
}
