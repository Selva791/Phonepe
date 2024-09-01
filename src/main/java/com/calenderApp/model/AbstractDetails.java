package com.calenderApp.model;

import lombok.ToString;

@ToString
public abstract class AbstractDetails {
    String id;
    String name;
    TimeSlot timeSlot;
    boolean isRecurring;
    RecurringSLot recurringSLot;

    public AbstractDetails(String id, String name, TimeSlot timeSlot, boolean isRecurring, RecurringSLot recurringSLot) {
        this.id = id;
        this.name = name;
        this.timeSlot = timeSlot;
        this.isRecurring = isRecurring;
        this.recurringSLot = recurringSLot;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public boolean isRecurring() {
        return isRecurring;
    }
    public RecurringSLot getRecurringSLot(){
        return recurringSLot;
    }
}
