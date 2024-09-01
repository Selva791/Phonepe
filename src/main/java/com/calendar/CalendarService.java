package com.calendar;

import java.time.LocalDateTime;
import java.util.*;

public class CalendarService implements CalendarOperations{


    @Override
    public String addShifts(Event event) {
        List<Users> usersList = event.getParticipants();
        for(Users users:usersList){
            users.getCalendar().getSlots()
                    .computeIfAbsent(event.getStartTime().toLocalDate(),e-> new ArrayList<Event>()).add(event);
        }
        return "Event Updated Successfully";
    }

    @Override
    public Event createEvents(List<Users> usersList,LocalDateTime start,LocalDateTime end) {
        Event event=Event.builder().eventId(UUID.randomUUID().toString()).
                participants(usersList).startTime(start).endTime(end).build();
        addShifts(event);
        return event;
    }

    @Override
    public Map<String,List<Event>> conflictEvents(List<Users> usersList, Event event) {
        Map<String,List<Event>> conflicts=new HashMap<>();
        for(Users users:usersList){

            List<Event> eventList=users.getCalendar().getSlots().get(event.startTime.toLocalDate());
            for(Event event1:eventList){
                if(event.getStartTime().isAfter(event.getEndTime())){
                    continue;
                }else if(event.getEndTime().isBefore(event1.getStartTime())){
                    continue;
                }else{
                    conflicts.computeIfAbsent(users.getName(),e->new ArrayList<Event>()).add(event1);
                }
            }
        }
        return conflicts;
    }

    @Override
    public String addRecurringEvents(Event event, LocalDateTime localDateTime, TimeOfEvent time) {
        return null;
    }
}
