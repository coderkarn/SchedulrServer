package com.example.schedulr.request.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class UserEventRequest {
    private Long userId;
    private String title;
    private String description;
    private String recipientEmail;
    private LocalDateTime eventDateTime;
    private boolean personalEvent;
    private boolean active;

}