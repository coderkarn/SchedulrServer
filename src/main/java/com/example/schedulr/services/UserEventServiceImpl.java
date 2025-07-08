package com.example.schedulr.services;

import com.example.schedulr.db.entity.UserEvent;
import com.example.schedulr.repository.UserEventRepository;
import com.example.schedulr.request.models.UserEventRequest;
import com.example.schedulr.response.models.UserEventResponse;
import com.example.schedulr.service.UserEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserEventServiceImpl implements UserEventService {

    @Autowired
    public UserEventRepository eventRepo;

    public String createEvent(UserEventRequest userEventRequest) throws Exception{
        UserEvent userEvent = new UserEvent();

        userEvent.setUserId(userEventRequest.getUserId());
        userEvent.setTitle(userEventRequest.getTitle());
        userEvent.setDescription(userEventRequest.getDescription());
        userEvent.setEventDateTime(userEventRequest.getEventDateTime());
        userEvent.setRecipientEmail(userEventRequest.getRecipientEmail());
        userEvent.setPersonalEvent(userEventRequest.isPersonalEvent());
        userEvent.setActive(userEventRequest.isActive());

        userEvent.setCreatedTs(LocalDateTime.now());
        userEvent.setLastUpdatedTs(LocalDateTime.now());

        eventRepo.save(userEvent);
        return "SUCCESS";
    }
    public List<UserEventResponse> getUserEvents(Long userId) throws Exception{
        List<UserEvent> events = eventRepo.findByUserId(userId);

        List<UserEventResponse> responseList = new ArrayList<>();
        for (UserEvent event : events) {
            UserEventResponse response = new UserEventResponse();
            response.setEventId(event.getEventId());
            response.setUserId(event.getUserId());
            response.setTitle(event.getTitle());
            response.setDescription(event.getDescription());
            response.setEventDateTime(event.getEventDateTime());
            response.setRecipientEmail(event.getRecipientEmail());
            response.setPersonalEvent(event.getPersonalEvent());
            response.setActive(event.getActive());
            response.setCreatedTs(event.getCreatedTs());
            response.setLastUpdatedTs(event.getLastUpdatedTs());

            responseList.add(response);
        }
        return responseList;
    }



}
