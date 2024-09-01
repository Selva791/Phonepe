package com.calenderApp.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ICalenderSearchService {
    Map<String,List<TimeSlot>> findSuitableSlot(TimeSlot preferred, LocalDate day, RecurringSLot recurringSLot, List<User> user);
    Map<String,List<AbstractDetails>> findConflictingEvents(List<String> userList, LocalDate localDate,TimeSlot timeSlot);
}
