package com.rolandsalloum.movieinfoservice.Controller;

public class FailedToCreateMovie extends Throwable {
    public FailedToCreateMovie(String s) {
        super(s);
    }
}
