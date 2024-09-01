package com.calendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface Onboard {
    List<Users> addUser(String name);
    List<Event> getEventOfUser(String name, LocalDate localDate);
    Calendar getUserCalendar(String name);

}
