/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class VenueRepository <Venue> {
    private final Map<Long, Venue> storage = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Venue> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Venue> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Venue save(Long id, Venue entity) {
        if (id == null) {
            id = idCounter.getAndIncrement();
        }
        entity.setId(id);
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
