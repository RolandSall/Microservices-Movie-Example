package com.rolandsalloum.moviecatalogservice.Controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rolandsalloum.moviecatalogservice.Service.Movie.MovieService;
import com.rolandsalloum.moviecatalogservice.Service.Rating.RatingService;
import com.rolandsalloum.moviecatalogservice.model.CatalogItem;
import com.rolandsalloum.moviecatalogservice.model.Rating;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/catalog")
@NoArgsConstructor

public class MovieCatalogController {

    private RestTemplate restTemplate;
    private WebClient.Builder webClientBuilder;
    private MovieService movieService;
    private RatingService ratingService;

    @Autowired
    public MovieCatalogController(RestTemplate restTemplate, WebClient.Builder webClientBuilder
            , MovieService movieService, RatingService ratingService) {
        this.restTemplate = restTemplate;
        this.webClientBuilder = webClientBuilder;
        this.movieService = movieService;
        this.ratingService = ratingService;
    }

    @GetMapping("/{userId}")
     public ResponseEntity getCatalogByUserId(@PathVariable("userId") String userId) {
        /*** Using RestTemplate hard coding without service discovery ***/

    /*    ResponseEntity<Rating[]> ratingResponse = restTemplate.getForEntity("http://localhost:8081/ratingdata/users/" + userId, Rating[].class);
        List<Rating> ratingForUser = Arrays.asList(ratingResponse.getBody());


        for (Rating rating : ratingForUser) {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            catalogList.add(new CatalogItem(movie.getName(), "Desc", rating.getRating()));
        }
*/

        /*** Using WebClient: Asynchronous-Reactive programming   ***/

    /*
            List<CatalogItem> catalogList = new ArrayList();
            List<Rating> ratingForUser = Arrays.asList(Objects.requireNonNull(webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/ratingdata/" + userId)
                .retrieve()
                .bodyToMono(Rating[].class)
                .block()));

        for(Rating rating: ratingForUser){
            Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
            catalogList.add(new CatalogItem(movie.getName(),"Desc",rating.getRating()));
        }
*/

        /*** Using RestTemplate using service discovery ***/
        ResponseEntity<Rating[]> ratingResponse = ratingService.getUserRating(userId);
        List<Rating> ratingForUser = Arrays.asList(ratingResponse.getBody());
        ResponseEntity catalogListResponse = movieService.getCatalogItemForUser(ratingForUser);
        return catalogListResponse;

    }

}
