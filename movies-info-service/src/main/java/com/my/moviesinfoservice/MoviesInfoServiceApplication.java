package com.my.moviesinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MoviesInfoServiceApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate(httpRequestFactory);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MoviesInfoServiceApplication.class, args);
	}

}
