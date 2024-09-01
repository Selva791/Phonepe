package com.movieBooking;

import java.time.LocalDateTime;
import java.util.List;

public class MovieBookingController {
    public static void main(String[] args) {
        DataStore dataStore = new DataStore();
        MovieBookingService bookingService = new MovieBookingService(dataStore);

        // Adding movies and shows
        Movie movie = Movie.builder().movieId("M1").genre("SCIFI").runtime(2.5).title("Avengers: Endgame").build();
        bookingService.addMovie(movie);

        MovieShow show = MovieShow.builder().movieId("M1").id("S1").location("Adayar").availableSeats(30).startTime(LocalDateTime.now()).build();
        bookingService.addMovieShow(show);

        // Booking a show
        String bookingId = bookingService.bookShow("user123", "S1", 2);
        if (bookingId != null) {
            System.out.println("Booking successful. Booking ID: " + bookingId);
        } else {
            System.out.println("Booking failed.");
        }

        // Getting available shows
        List<MovieShow> availableShows = bookingService.getAvailableMovieShows();
        System.out.println("Available Shows:");
        for (MovieShow availableShow : availableShows) {
            System.out.println(availableShow.id+" "+DataStore.movies.get(availableShow.getMovieId())+ " - " + availableShow.startTime);
        }

        // Canceling a booking
        boolean canceled = bookingService.cancelBooking(bookingId);
        if (canceled) {
            System.out.println("Booking canceled.");
        } else {
            System.out.println("Booking cannot be canceled.");
        }
    }
}
