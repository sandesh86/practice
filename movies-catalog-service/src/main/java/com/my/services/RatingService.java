package com.my.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.my.model.Rating;
import com.my.model.UserRatings;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RatingService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRatings getUserRating(String userId) {
		return restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRatings.class);
	}
	
	public UserRatings getFallbackUserRating(String userId) {
		UserRatings rating = new UserRatings();
		rating.setUserId(userId);
		rating.setRatings(Arrays.asList(
				new Rating("0", 0)));
		return rating;
	}
}
