package com.calendar;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface CalendarOperations {
    String addShifts(Event event);
    Event createEvents(List<Users> usersList,LocalDateTime start,LocalDateTime end);
    Map<String,List<Event>> conflictEvents(List<Users> usersList, Event event);

    String addRecurringEvents(Event event, LocalDateTime localDateTime,TimeOfEvent time);

}
