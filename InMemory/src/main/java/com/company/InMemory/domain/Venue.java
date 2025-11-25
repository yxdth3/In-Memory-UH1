package com.company.InMemory.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venue {
    private Long id;
    private String name;
    private String location;
}
