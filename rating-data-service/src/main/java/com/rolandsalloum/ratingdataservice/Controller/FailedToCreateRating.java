package com.rolandsalloum.ratingdataservice.Controller;

public class FailedToCreateRating extends Throwable {
    public FailedToCreateRating(String s) {
        super(s);
    }
}
