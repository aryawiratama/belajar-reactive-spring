 package com.arya.belajar.reactive.Util;

import com.arya.belajar.reactive.entity.Movie;
import com.arya.belajar.reactive.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class MovieCLR implements CommandLineRunner{

    private final MovieRepository movieRepository;

    @Autowired
    public MovieCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        movieRepository.deleteAll().thenMany(
            Flux.just("Silence of Lambda", "AEON Flux", "Back to Future", "The Fluxxinator", "Pocong Beranak Tiga",
                        "Setan Kredit", "Maju Kena Mundur Kena")
                    .map(title -> new Movie(UUID.randomUUID().toString(), title))
                    .flatMap(movieRepository::save))
            .subscribe(null, null, () ->{
            movieRepository.findAll().subscribe(System.out::println);
            });
    }
}
