package com.rolandsalloum.ratingdataservice.Controller;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatingApiRequest {
    private String userId;
    private String movieId;
    private double rating;

}
