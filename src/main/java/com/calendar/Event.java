package com.calendar;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@ToString
public class Event {
    String eventId;
    LocalDateTime startTime;

    public String getEventId() {
        return eventId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getPlace() {
        return place;
    }

    public List<Users> getParticipants() {
        return participants;
    }

    LocalDateTime endTime;
    String place;
    List<Users> participants;
}
