package com.rolandsalloum.ratingdataservice.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingdata")
public class RatingController {

  /*  private IRatingRepositoryDAO iRatingRepositoryDAO;

    @Autowired
    public RatingController(IRatingRepositoryDAO iRatingRepositoryDAO) {
        this.iRatingRepositoryDAO = iRatingRepositoryDAO;
    }
*/
 /*   @GetMapping("/{userId}")
    public ResponseEntity getAllMovieRatedByUser(@PathVariable("userId") String userId){
        List<Rating> ratingList = iRatingRepositoryDAO.findByUserId(userId);
        List<RatingApiResponse> responseList = buildApiResponseForRating(ratingList);
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }
*/

 /*   @PostMapping("")
    public ResponseEntity createRatingForMovieByUser(@RequestBody RatingApiRequest request) throws FailedToCreateRating {
        try {
            Rating rating = getRatingFromRequest(request);
            *//*iRatingRepositoryDAO.save(rating);*//*
            RatingApiResponse response = getRatingApiResponse(rating);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            throw new FailedToCreateRating("Failed To Create Rating !");
        }
    }


    private List<RatingApiResponse> buildApiResponseForRating(List<Rating> ratingList) {
        List<RatingApiResponse> responseList = new ArrayList<>();
        for(Rating rating: ratingList){
            responseList.add(getRatingApiResponse(rating));

        }
        return responseList;
    }

    private RatingApiResponse getRatingApiResponse(Rating rating) {
        return new RatingApiResponse().builder()
                .ratingId(rating.getRatingId())
                .userId(rating.getUserId())
                .movieId(rating.getMovieId())
                .rating(rating.getRating())
                .build();
    }

    private Rating getRatingFromRequest(RatingApiRequest request) {
        return new Rating().builder()
                .userId(request.getUserId())
                .movieId(request.getMovieId())
                .rating(request.getRating())
                .build();
    }*/
}
