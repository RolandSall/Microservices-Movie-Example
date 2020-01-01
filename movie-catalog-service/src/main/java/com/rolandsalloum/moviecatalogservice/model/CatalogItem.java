package com.rolandsalloum.moviecatalogservice.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
@Setter
public class CatalogItem {

    private String name;
    private String description;
    private double rating;
}
