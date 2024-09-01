package com.movieBooking;

import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class Movie {
    String title;
    String movieId;

    public double getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    double runtime;
    String genre;
    public String getTitle() {
        return title;
    }

    public String getMovieId() {
        return movieId;
    }


}
