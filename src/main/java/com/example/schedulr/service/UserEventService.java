package com.example.schedulr.service;

import com.example.schedulr.db.entity.UserEvent;
import com.example.schedulr.request.models.UserEventRequest;
import com.example.schedulr.response.models.UserEventResponse;

import java.util.List;

public interface UserEventService {

    public String createEvent(UserEventRequest userEventRequest) throws Exception;

    public List<UserEventResponse> getUserEvents(Long UserId) throws Exception;
}
