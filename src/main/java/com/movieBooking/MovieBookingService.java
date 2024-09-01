package com.movieBooking;

import java.util.ArrayList;
import java.util.List;

public class MovieBookingService {
        private DataStore dataStore;

        public MovieBookingService(DataStore dataStore) {
            this.dataStore = dataStore;
        }

        public void addMovie(Movie movie) {
            dataStore.movies.put(movie.getMovieId(), movie);
        }

        public void addMovieShow(MovieShow show) {
            dataStore.movieShows.put(show.getId(), show);
        }

        public String bookShow(String userId, String showId, int numberOfSeats) {
            MovieShow show = dataStore.movieShows.get(showId);
            if (show == null || show.availableSeats < numberOfSeats) {
                return null; // Show not available or seats not available
            }

            String bookingId = generateBookingId();
            BookShow booking = BookShow.builder().id(bookingId)
                    .userId(userId).showId(showId)
                    .numberOfSeats(30)
                    .isPaid(false).build();


            show.availableSeats -= numberOfSeats;
            dataStore.bookings.put(bookingId, booking);

            return bookingId;
        }

        public boolean cancelBooking(String bookingId) {
            BookShow booking = dataStore.bookings.get(bookingId);
            if (booking != null && !booking.isPaid) {
                MovieShow show = dataStore.movieShows.get(booking.showId);
                show.availableSeats += booking.numberOfSeats;
                dataStore.bookings.remove(bookingId);
                return true;
            }
            return false; // Unable to cancel
        }

        public List<MovieShow> getAvailableMovieShows() {
            List<MovieShow> availableShows = new ArrayList<>();
            for (MovieShow show : dataStore.movieShows.values()) {
                if (show.availableSeats > 0) {
                    availableShows.add(show);
                }
            }
            return availableShows;
        }

        private String generateBookingId() {
            // Logic to generate a unique booking ID
            return "BOOKING-" + System.currentTimeMillis();
        }

    }
