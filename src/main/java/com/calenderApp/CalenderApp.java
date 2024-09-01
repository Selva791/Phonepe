package com.calenderApp;

import com.calenderApp.model.*;
import com.calenderApp.service.CalenderSearchService;
import com.calenderApp.service.CalenderService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CalenderApp {
    public static void main(String[] args) {
        CalenderService calenderService=new CalenderService();
        CalenderSearchService calenderSearchService=new CalenderSearchService(calenderService);

        List<User> participants=new ArrayList<>();

        User user=new User("1","Dhoni","ABC","abs@gmail.com");
        participants.add(user);
        participants.add(new User("2","Paul","ABS","ybc@gmail.com"));

        TimeSlot timeSlot=new TimeSlot(LocalDateTime.of(2024,10,12,11,00),
                LocalDateTime.of(2024,10,12,12,00));


        Event event=new Event("2","Play",timeSlot,false,participants,RecurringSLot.DAY);

        TimeSlot timeSlot1=new TimeSlot(LocalDateTime.of(2024,10,13,11,00),
                LocalDateTime.of(2024,10,13,12,00));

        Event event1=new Event("3","Study",timeSlot,true,participants, RecurringSLot.MONTH);
        Shift shift=new Shift("4","Work",timeSlot1,false,user,null);

        calenderService.createEvents(event);
        calenderService.createEvents(event1);
        calenderService.addShifts(shift);


        Map<String,List<TimeSlot>> res= calenderSearchService.findSuitableSlot(timeSlot1,
                LocalDate.of(2024,10,12),null,participants);
        System.out.println("SLots Available: "+res);
        Map<String,List<AbstractDetails>> res1= calenderSearchService.findConflictingEvents(
                List.of("1","2"),LocalDate.of(2024,10,12),timeSlot);
        System.out.println("Conflicts "+ res1);
    }
}
