/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.InMemory.web;

import com.company.InMemory.domain.Venue;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.company.InMemory.service.VenueService;


@RestController
@RequestMapping("/venues")
public class VenueController {

    private final VenueService service;

    public VenueController(VenueService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Venue>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venue> getById(@PathVariable Long id) throws Throwable {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Venue> create(@RequestBody Venue venue) {
        return ResponseEntity.ok(service.create(venue));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venue> update(@PathVariable Long id, @RequestBody Venue venue) {
        return ResponseEntity.ok(service.update(id, venue));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }  
}
