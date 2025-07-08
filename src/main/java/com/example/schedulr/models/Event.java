package com.example.schedulr.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime eventDateTime;
    private String sendToEmail;     // whom to send reminder
    private boolean selfReminder;   // if true, reminder to self
    private boolean isActive;       // Event active or canceled

    private String createdTs;
    private String lastUpdatedTs;

//
//    @ManyToOne
//    private UserDetail createdBy;
}
