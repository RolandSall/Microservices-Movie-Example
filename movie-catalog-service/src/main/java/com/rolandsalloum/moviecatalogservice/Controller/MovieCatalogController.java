package com.rolandsalloum.moviecatalogservice.Controller;


import com.rolandsalloum.moviecatalogservice.model.CatalogItem;
import com.rolandsalloum.moviecatalogservice.model.Movie;
import com.rolandsalloum.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;


    @GetMapping("/{userId}")
    public ResponseEntity getCatalogByUserId(@PathVariable("userId") String userId) {
        /*** Using RestTemplate hard coding without service discovery ***/

        List<CatalogItem> catalogList = new ArrayList();
    /*    ResponseEntity<Rating[]> ratingResponse = restTemplate.getForEntity("http://localhost:8081/ratingdata/users/" + userId, Rating[].class);
        List<Rating> ratingForUser = Arrays.asList(ratingResponse.getBody());


        for (Rating rating : ratingForUser) {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            catalogList.add(new CatalogItem(movie.getName(), "Desc", rating.getRating()));
        }
*/

        /*** Using WebClient: Asynchronous-Reactive programming   ***/

    /*    List<Rating> ratingForUser = Arrays.asList(Objects.requireNonNull(webClientBuilder.build()
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

        ResponseEntity<Rating[]> ratingResponse = restTemplate.getForEntity("http://rating-data-service/ratingdata/users/" + userId, Rating[].class);
        List<Rating> ratingForUser = Arrays.asList(ratingResponse.getBody());


        for (Rating rating : ratingForUser) {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            catalogList.add(new CatalogItem(movie.getName(), "Desc", rating.getRating()));
        }

        return ResponseEntity.status(HttpStatus.OK).body(catalogList);

    }


}
