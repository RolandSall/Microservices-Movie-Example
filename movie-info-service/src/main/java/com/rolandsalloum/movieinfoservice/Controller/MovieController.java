package com.rolandsalloum.movieinfoservice.Controller;

import com.rolandsalloum.movieinfoservice.Repository.IMovieRepository;
import com.rolandsalloum.movieinfoservice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private IMovieRepository iMovieRepository;

    @Autowired
    public MovieController(IMovieRepository iMovieRepository) {
        this.iMovieRepository = iMovieRepository;
    }

    @GetMapping("")
    public ResponseEntity getAllMovieInfo(){
        List<Movie> movieList = iMovieRepository.findAll();
        List<MovieApiResponse> responseList = BuildApiResponseForMovie(movieList);
        return ResponseEntity.status(HttpStatus.OK).body(responseList);

    }



    @GetMapping("/{movieId}")
    public ResponseEntity getMovieInfoById(@PathVariable("movieId") String movieId){
        Movie movie = iMovieRepository.getOne(movieId);
        MovieApiResponse response = getMovieApiResponse(movie);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PostMapping("")
    public ResponseEntity createMovie(@RequestBody MovieApiRequest request) throws FailedToCreateMovie {
        try {
            Movie movie = iMovieRepository.save(getMovieFromRequest(request));
            MovieApiResponse response = getMovieApiResponse(movie);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            throw  new FailedToCreateMovie("Failed To Create Movie !");
        }

    }

    private List<MovieApiResponse> BuildApiResponseForMovie(List<Movie> movieList) {
        List<MovieApiResponse> responseList = new ArrayList<>();
        for(Movie movie: movieList){
            responseList.add(getMovieApiResponse(movie));
        }

        return responseList;
    }

    private MovieApiResponse getMovieApiResponse(Movie movie) {
        return  new MovieApiResponse().builder()
                .movieId(movie.getMovieId())
                .name(movie.getName())
                .build();
    }

    private Movie getMovieFromRequest(MovieApiRequest request) {
        return  new Movie().builder()
                .name(request.getName())
                .build();
    }


}
