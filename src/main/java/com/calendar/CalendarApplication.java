package com.calendar;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class CalendarApplication {

    public static void main(String[] args) {
        UserOnboardService userOnboardService=new UserOnboardService();
        userOnboardService.addUser("Michaels");
        userOnboardService.addUser("Dhoni");
        userOnboardService.addUser("Kohli");

       List<Users> usersList=userOnboardService.addUser("Sherlock");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate.parse("12-30-2024",dateTimeFormatter);
       Event event= Event.builder().eventId(UUID.randomUUID().toString()).startTime(LocalDateTime.of(2023,8,31,12,0))
                .endTime(LocalDateTime.of(2023,8,31,13,00)).participants(usersList).place("Chennai").build();

        CalendarService calendarService =new CalendarService();
        calendarService.addShifts(event);
        System.out.println(usersList);
        calendarService.createEvents(usersList,
                LocalDateTime.of(2023,9,20,9,0),
                LocalDateTime.of(2023,9,20,10,0));
        Event eventdup= Event.builder().eventId(UUID.randomUUID().toString()).startTime(LocalDateTime.of(2023,8,31,12,0))
                .endTime(LocalDateTime.of(2023,8,31,14,00)).participants(usersList).place("Chennai").build();

        System.out.println(calendarService.conflictEvents(usersList,eventdup));
    }

}
