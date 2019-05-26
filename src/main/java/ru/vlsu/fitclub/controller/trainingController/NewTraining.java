package ru.vlsu.fitclub.controller.trainingController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewTraining {

    @GetMapping("/new_train")
    public String getNewTrain(int trainerId){
        
        return "training/new_train";
    }
}
