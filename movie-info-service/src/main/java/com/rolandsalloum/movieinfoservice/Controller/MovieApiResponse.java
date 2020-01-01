package com.rolandsalloum.movieinfoservice.Controller;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieApiResponse {
    private String movieId;
    private String name;
}
