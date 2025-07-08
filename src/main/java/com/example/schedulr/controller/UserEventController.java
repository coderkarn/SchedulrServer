package com.example.schedulr.controller;

import com.example.schedulr.request.models.UserEventRequest;
import com.example.schedulr.response.models.UserEventResponse;
import com.example.schedulr.service.UserEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/event")
public class UserEventController {

    @Autowired
    UserEventService eventService;

    @PostMapping("/create")
    public ResponseEntity<String> createEvent(@RequestBody UserEventRequest userEventRequest) throws Exception {
        try {
            log.info("userEventRequest val : {}",userEventRequest);
            String status = eventService.createEvent(userEventRequest);
            return ResponseEntity.ok(status);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/get/{userId}")
    public ResponseEntity<List<UserEventResponse>> getUserEvents(@PathVariable Long userId) throws Exception {
        try {
            List<UserEventResponse> events = eventService.getUserEvents(userId);
            return ResponseEntity.ok(events);
        } catch (Exception e) {
            log.error("Error fetching user events for userId {}: {}", userId, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}
