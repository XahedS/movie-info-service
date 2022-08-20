package example.microservice.movieinfoservice.service.impl;

import example.microservice.movieinfoservice.config.MovieDBProperties;
import example.microservice.movieinfoservice.model.Movie;
import example.microservice.movieinfoservice.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieServiceImpl implements MovieService {

    private final RestTemplate restTemplate;
    private final MovieDBProperties movieDBProperties;

    public MovieServiceImpl(RestTemplate restTemplate, MovieDBProperties movieDBProperties) {
        this.restTemplate = restTemplate;
        this.movieDBProperties = movieDBProperties;
    }

    @Override
    public Movie getMovie(String movieId) throws RestClientException{
        String url = movieDBProperties.getUrl()+"/"+movieDBProperties.getVersion()+"/movie/"+movieId+"?api_key="+movieDBProperties.getKey();

        Movie movie = restTemplate.getForObject(url, Movie.class);
        return movie;
    }
}
