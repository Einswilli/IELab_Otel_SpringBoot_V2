package com.ielab.ieotel_springboot.services;

import com.ielab.ieotel_springboot.models.Event;

import java.util.List;

public interface EventService {

    public List<Event> listEvent();

    public Event showEvent(String id);

    public Event createEvent(Event event);

    public Event updateEvent(String id, Event event) ;
}
