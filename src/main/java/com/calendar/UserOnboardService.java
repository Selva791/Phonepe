package com.calendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class UserOnboardService implements Onboard{
    List<Users> usersList =new ArrayList<>();
    @Override
    public List<Users> addUser(String name) {
        Users users = Users.builder()
                .userId(UUID.randomUUID().toString()).name(name)
                .calendar(Calendar.builder().slots(new HashMap<LocalDate,List<Event>>()).build()).build();
        usersList.add(users);
        return  usersList;
    }

    @Override
    public List<Event> getEventOfUser(String name, LocalDate localDate) {
        List<Event> events=new ArrayList<>();
        for(Users users:usersList){
            if(users.name.equals(name)){
              return users.getCalendar().getSlots().get(localDate);
            }
        }
        return events;
    }

    @Override
    public Calendar getUserCalendar(String name) {
        return null;
    }

}
