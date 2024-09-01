package com.movieBooking;

import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class BookShow {
        String id;
        String userId;
        String showId;
        int numberOfSeats;
        boolean isPaid;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getShowId() {
        return showId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isPaid() {
        return isPaid;
    }
}
