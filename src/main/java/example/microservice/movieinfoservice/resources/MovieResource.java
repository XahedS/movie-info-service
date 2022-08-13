package example.microservice.movieinfoservice.resources;
import example.microservice.movieinfoservice.models.Movie;
import example.microservice.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable String movieId) {

        String url = "https://api.themoviedb.org/3/movie/" + movieId +
                "?api_key=" + apiKey;
        System.out.println("Movie ID : " + movieId + " URL: "+ url);
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId +
                "?api_key=" + apiKey, MovieSummary.class);
//        System.out.println(movieSummary.toString());
//        return new Movie(movieId, "Test name");
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }
}
