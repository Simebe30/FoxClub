package com.greenfoxacademy.foxclub.repositories;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class NutritionStore {
    private List<String> foodList;
    private List<String> drinkList;

    public NutritionStore() {
        foodList = new ArrayList<>();
        drinkList = new ArrayList<>();

        foodList.add("Burger");
        foodList.add("Cookies");
        foodList.add("Fish");
        foodList.add("Tomato");
        foodList.add("Lettuce");
        foodList.add("Pizza");

        drinkList.add("Water");
        drinkList.add("Coke");
        drinkList.add("Prime");
        drinkList.add("Juice");
        drinkList.add("Blood");
    }
}
