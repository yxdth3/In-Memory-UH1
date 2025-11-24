/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Venue;
import java.util.List;
import org.springframework.stereotype.Service;
import repository.VenueRepository;
import web.exception.NotFoundException;


@Service
public class VenueService {
    private final VenueRepository repository;

    public VenueService(VenueRepository repository) {
        this.repository = repository;
    }

    public List<Venue> getAll() {
        return repository.findAll();
    }

    public Venue getById(Long id) throws Throwable {
        return (Venue) repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Venue not found"));
    }

    public Venue create(Venue venue) {
        return (Venue) repository.save(null, venue);
    }

    public Venue update(Long id, Venue venue) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Venue not found");
        }
        return (Venue) repository.save(id, venue);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Venue not found");
        }
        repository.delete(id);
    }
}
