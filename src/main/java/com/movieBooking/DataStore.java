package com.movieBooking;

import java.util.HashMap;
import java.util.Map;

public class DataStore {
    static Map<String, Movie> movies = new HashMap<>();
    static Map<String, MovieShow> movieShows = new HashMap<>();
    static Map<String, BookShow> bookings = new HashMap<>();
}
