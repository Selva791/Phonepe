package com.calenderApp.model;

import java.time.LocalDateTime;

public class Shift extends AbstractDetails {
    User user;

    public Shift(String id, String name, TimeSlot timeSlot, boolean isRecurring, User user,RecurringSLot recurringSLot) {
        super(id, name, timeSlot, isRecurring, recurringSLot);
        this.user=user;
    }


    public User getUser() {
        return user;
    }
}
