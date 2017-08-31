package com.arya.belajar.reactive;

import com.arya.belajar.reactive.handler.MovieHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@SpringBootApplication
public class BelajarSpringReactiveApplication {

	@Bean
	RouterFunction<?> route(MovieHandler movieHandler){
		return RouterFunctions.route(RequestPredicates.GET("/movies"), serverRequest -> movieHandler.findAllMovie(serverRequest))
				.andRoute(RequestPredicates.GET("/movies/{movieId}"), serverRequest -> movieHandler.findMovieById(serverRequest))
				.andRoute(RequestPredicates.GET("/movies/{movieId}/events"), serverRequest -> movieHandler.events(serverRequest));
	}

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringReactiveApplication.class, args);
	}
}
