
package com.company.InMemory.service;

import com.company.InMemory.domain.Event;
import com.company.InMemory.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.company.InMemory.exception.NotFoundException;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<Event> findAll() {
        return repository.findAll();
    }

    public Event findById(Long id) throws Throwable {
        return (Event) repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found"));
    }

    public Event create(Event event) {
        return (Event) repository.save(null, event);
    }

    public Event update(Long id, Event event) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Event not found");
        }
        event.setId(id);
        return (Event) repository.save(id, event);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Event not found");
        }
        repository.delete(id);
    }
}

