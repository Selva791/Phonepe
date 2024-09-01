package com.calendar;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;


@Builder
public class Calendar {
    Map<LocalDate, List<Event>> slots;

    public Map<LocalDate, List<Event>> getSlots() {
        return slots;
    }
}
