package com.greenfoxacademy.foxclub.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Fox {
    private String name;
    List<String> tricks;
    String food;
    String drink;

    public Fox(String name) {
        this.tricks = new ArrayList<>();
        this.food = "";
        this.drink = "";
        this.name = name;
    }

}
