package ru.vlsu.fitclub.controller.trainerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainerController {

    @Autowired
    public TrainerController(){

    }

    @GetMapping("/trainer")
    public String getTrainerHomePage(){
        return "trainer/trainer_site";
    }
}
