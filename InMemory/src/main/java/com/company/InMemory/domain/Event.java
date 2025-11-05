package com.company.InMemory.domain;

public class Event {
    private Long id;
    private String name;
    private String description;
    private Long venueId;

    public Event() {
    }

    public Event(Long id, String name, String description, Long venueId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.venueId = venueId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }
}
