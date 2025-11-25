package com.company.InMemory.repository;

import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepository <Event>{
    private final Map<Long, Event> storage = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Event> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Event> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Event save(Long id, Event entity) {
        if (id == null) {
            id = idCounter.getAndIncrement();
        }
        storage.put(id, entity);
        return entity;
    }

    public void delete(Long id) {
        storage.remove(id);
    }

    public boolean existsById(Long id) {
        return storage.containsKey(id);
    }
}
