package com.calenderApp.service;

import com.calenderApp.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CalenderSearchService implements ICalenderSearchService {
    CalenderService calenderService;
    public CalenderSearchService(CalenderService calenderService) {
        this.calenderService=calenderService;
    }

    @Override
    public Map<String,List<TimeSlot>> findSuitableSlot(TimeSlot preferred, LocalDate day, RecurringSLot recurringSLot, List<User> users) {

         Map<String, Map<LocalDate, List<AbstractDetails>>> events=calenderService.events;
         Map<String,List<TimeSlot>> result=new HashMap<>();
         LocalDateTime startTime=LocalDateTime.of(day.getYear(), day.getMonth(),day.getDayOfMonth(),9,00);
         for(User user: users){

             List<TimeSlot> timeSlots=new ArrayList<>();
             Map<LocalDate, List<AbstractDetails>> temp= events.get(user.getId());
             List<AbstractDetails> abstractDetails=
                     temp.get(day).stream().sorted(Comparator.comparing(a->a.getTimeSlot().getStart()))
                             .collect(Collectors.toList());

            for(AbstractDetails sch:abstractDetails){
                    TimeSlot timeSlot =sch.getTimeSlot();
                    if(timeSlot.getStart().isAfter(startTime)){
                        timeSlots.add(new TimeSlot(startTime,timeSlot.getStart()));
                    }
                    startTime=timeSlot.getEnd();
            }

             result.put(user.getId(),timeSlots);
         }
        return result;
    }


    @Override
    public Map<String,List<AbstractDetails>> findConflictingEvents(List<String> userList, LocalDate localDate, TimeSlot timeSlot) {
        Map<String,List<AbstractDetails>> conflicts=new HashMap<>();
        Map<String, Map<LocalDate, List<AbstractDetails>>> events=CalenderService.events;
        for(String id:userList){
            Map<LocalDate,List<AbstractDetails>> collect=events.get(id);
            if(collect.get(localDate)!=null){

                List<AbstractDetails> eventsOfDay= collect.get(localDate).stream()
                        .sorted(Comparator.comparing(s->s.getTimeSlot().getStart()))
                        .collect(Collectors.toList());
                for (AbstractDetails sch:eventsOfDay){
                    boolean case1=timeSlot.getStart().isBefore(sch.getTimeSlot().getStart())&&
                            timeSlot.getEnd().isAfter(sch.getTimeSlot().getStart());

                    boolean case2 = timeSlot.getStart().isBefore(sch.getTimeSlot().getEnd()) &&
                            timeSlot.getEnd().isAfter(sch.getTimeSlot().getEnd());

                    boolean case3 = timeSlot.getStart().isEqual(sch.getTimeSlot().getStart())&&
                            timeSlot.getEnd().isAfter(sch.getTimeSlot().getStart());

                    boolean case4 = timeSlot.getStart().isBefore(sch.getTimeSlot().getEnd()) &&
                            timeSlot.getEnd().equals(sch.getTimeSlot().getEnd());

                    if(case1||case2 || case3||case4){
                        conflicts.computeIfAbsent(id,s->new ArrayList<>()).add(sch);
                    }
                }
            }
        }
        return conflicts;
    }
}
