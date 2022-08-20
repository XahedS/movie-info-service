package example.microservice.movieinfoservice.service;

import example.microservice.movieinfoservice.model.Movie;
import org.springframework.stereotype.Service;


public interface MovieService {

    Movie getMovie(String movieId);
}
