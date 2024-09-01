package com.movieBooking;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@ToString
@Builder
public class MovieShow {
        String id;
        String movieId;
        LocalDateTime startTime;
        int availableSeats;

        public String getId() {
                return id;
        }

        public String getMovieId() {
                return movieId;
        }

        public LocalDateTime getStartTime() {
                return startTime;
        }

        public int getAvailableSeats() {
                return availableSeats;
        }

        public String getLocation() {
                return location;
        }

        String location;
}
