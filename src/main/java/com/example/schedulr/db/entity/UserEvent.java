package com.example.schedulr.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "user_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "recipient_email")
    private String recipientEmail;

    // 🟢 If true, user wants a self reminder
    @Column(name = "personal_event")
    private Boolean personalEvent;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "event_date_time", nullable = false)
    private LocalDateTime eventDateTime;

    @Column(name = "created_ts")
    private LocalDateTime createdTs;

    @Column(name = "last_updated_ts")
    private LocalDateTime lastUpdatedTs;
}