package example.microservice.movieinfoservice.controller;
import example.microservice.movieinfoservice.model.Movie;
import example.microservice.movieinfoservice.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{movieId}")
    @ResponseStatus(HttpStatus.OK)
    public Movie getMovie(@PathVariable String movieId) {
        return movieService.getMovie(movieId);
    }
}
