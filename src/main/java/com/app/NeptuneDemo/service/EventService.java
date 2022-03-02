package com.app.NeptuneDemo.service;

import java.util.List;
import java.util.Optional;

import com.app.NeptuneDemo.model.Event;
import com.app.NeptuneDemo.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepo;

    public List<Event> index() {
        return (List<Event>) eventRepo.findAll();
    }

    public void save(com.app.NeptuneDemo.model.Event event) {
        eventRepo.save(event);
    }

    public com.app.NeptuneDemo.model.Event show(Long id) {
        Optional<Event> optional = eventRepo.findById(id);
        Event event = null;
        if (optional.isPresent()) {
            event = optional.get();
        } else {
            throw new RuntimeException("Event not found for id : : " + id);
        }
        return event;
    }

    public void delete(Long id) {
        eventRepo.deleteById(id);
    }
}
