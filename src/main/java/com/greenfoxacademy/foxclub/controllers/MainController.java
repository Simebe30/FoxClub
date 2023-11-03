package com.greenfoxacademy.foxclub.controllers;


import com.greenfoxacademy.foxclub.models.Fox;
import com.greenfoxacademy.foxclub.repositories.FoxHouse;
import com.greenfoxacademy.foxclub.repositories.NutritionStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
    private FoxHouse foxHouse;
    private NutritionStore nutritionStore;

    @Autowired
    public MainController(FoxHouse foxHouse, NutritionStore nutritionStore) {
        this.foxHouse = foxHouse;
        this.nutritionStore = nutritionStore;
    }


    @GetMapping("/")
    public String indexpage() {
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginFormSubmit(@RequestParam("name") String name, RedirectAttributes attrs) {

        attrs.addAttribute("name", name);
        foxHouse.add(name);
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String mainInformation(@ModelAttribute("name") String name, Model model) {

        model.addAttribute("fox", foxHouse.getSpecificFox(name));
        return "main";
    }

    @GetMapping("/nutritionStore")
    public String nutritionStore(Model model) {
        model.addAttribute("food", nutritionStore.getFoodList());
        model.addAttribute("drinks", nutritionStore.getDrinkList());


        return "nutritionStore";
    }
    @PostMapping("/nutritionStore")
    public String nutritionSubmit(@RequestParam("food") String food,
                                  @RequestParam("drink") String drink,
                                  @RequestParam("name") String name){
        foxHouse.assignFood(name,food);
        foxHouse.assignFood(name,drink);

        return "redirect:/main";
    }


}
