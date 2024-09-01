package com.calenderApp.service;

import com.calenderApp.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalenderService implements ICalenderService {
    static Map<String, Map<LocalDate, List<AbstractDetails>>> events=new HashMap<>();

    public CalenderService(){

    }
    @Override
    public Shift addShifts(Shift shift) {
        Map<LocalDate,List<AbstractDetails>> timeMap=null;
        if(events.get(shift.getUser().getId())!=null){
             timeMap=events.get(shift.getUser().getId());
        }else{
            timeMap=new HashMap<>();
        }
        timeMap.computeIfAbsent(shift.getTimeSlot().getStart().toLocalDate(),s->new ArrayList<>()).add(shift);
        events.put(shift.getUser().getId(), timeMap);
        System.out.println("Shift added Successfully");
        return shift;
    }

    @Override
    public Event createEvents(Event event) {
        Map<LocalDate,List<AbstractDetails>> timeMap=null;
        LocalDateTime initialTime=event.getTimeSlot().getStart();
        LocalDateTime tempDate=event.getTimeSlot().getStart();
        while(check(event.getRecurringSLot(),initialTime,tempDate)){
            if(event.getParticipants()!=null){
                for(User user:event.getParticipants()){
                    if(events.get(user.getId())!=null){
                        timeMap=events.get(user.getId());
                    }else{
                        timeMap=new HashMap<>();
                    }
                    timeMap.computeIfAbsent(event.getTimeSlot().getStart().toLocalDate(),s->new ArrayList<>()).add(event);
                    events.put(user.getId(), timeMap);
                }

            }
            tempDate=tempDate.plusDays(1);
        }


        System.out.println("Event added Successfully to all participants");
        return event;
    }

    private boolean check(RecurringSLot recurringSLot, LocalDateTime initialTime, LocalDateTime tempDate) {
        if(recurringSLot==RecurringSLot.MONTH){
           if(tempDate.getMonth().compareTo(initialTime.getMonth())== -1||
                   tempDate.getMonth().compareTo(initialTime.getMonth())==0){
                return true;
           }
        }else if(recurringSLot==RecurringSLot.YEAR){
            if(tempDate.getYear()<=initialTime.getYear()){
                return true;
            }
        }else if(recurringSLot==RecurringSLot.DAY){
            if(tempDate.getDayOfMonth()<=initialTime.getDayOfMonth()){
                return true;
            }
        }
        return false;
    }


}
