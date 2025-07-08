package com.example.schedulr.response.models;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class UserEventResponse {

    private Long eventId;
    private Long userId;
    private String title;
    private String description;
    private String recipientEmail;
    private LocalDateTime eventDateTime;
    private boolean personalEvent;
    private boolean active;
    private LocalDateTime createdTs;
    private LocalDateTime lastUpdatedTs;
}
