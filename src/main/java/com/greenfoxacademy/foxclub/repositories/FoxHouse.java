package com.greenfoxacademy.foxclub.repositories;

import com.greenfoxacademy.foxclub.models.Fox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FoxHouse {
    private List<Fox> foxes = new ArrayList<>();


    public void add(String name) {
        Optional<Fox> fox = foxes.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst();
        if (fox.isEmpty()) {
            this.foxes.add(new Fox(name));
        }
    }

    public Fox getSpecificFox(String name) {
        return this.foxes.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElse(new Fox(name));
    }

}
