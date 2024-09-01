package com.calenderApp.model;

import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@ToString
public class Event extends AbstractDetails{
    List<User> participants;

    public Event(String id, String name, TimeSlot timeSlot, boolean isRecurring,
                 List<User> participants, RecurringSLot recurringSLot) {
        super(id, name, timeSlot, isRecurring, recurringSLot);
        this.participants=participants;
    }


    public List<User> getParticipants() {
        return participants;
    }
}
