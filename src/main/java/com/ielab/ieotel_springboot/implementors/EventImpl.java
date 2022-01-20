package com.ielab.ieotel_springboot.implementors;

import com.ielab.ieotel_springboot.exceptions.NotFoundException;
import com.ielab.ieotel_springboot.models.Event;
import com.ielab.ieotel_springboot.repositories.EventRepository;
import com.ielab.ieotel_springboot.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> listEvent() {
        //logger.ListReadLogging("Event","");
        return eventRepository.findAll();
    }

    @Override
    public Event showEvent(String id) {
        // logger.DeatailLogging("Event","");
        return eventRepository.findById(id).orElseThrow(()-> new NotFoundException("Event Not found By id::"+id));
    }

    @Override
    public Event createEvent(Event event) {
        //logger.CreationLogging("Event","",event.toString());
        event.setCreateAt(new Date());
       return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(String id, Event event) {
        Event event1= eventRepository.findById(id).orElseThrow(()-> new NotFoundException("Event Not found By id::"+id));
       // event1.setCommands(event.getCommands());
        event1.setConsoRoom(event.getConsoRoom());
        event1.setUpdateAt(new Date());
        // logger.UpdateLogging("Event","",event.toString(),event1.toString());
        return eventRepository.save(event1);
    }
}
