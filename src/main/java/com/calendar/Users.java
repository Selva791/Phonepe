package com.calendar;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Users {
    String userId;
    String name;
    String position;
    Calendar calendar;

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Calendar getCalendar() {
        return calendar;
    }
}
