package ru.vlsu.fitclub.controller.trainerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.service.TrainerService;

import java.util.List;

@Controller
public class TrainerListController {

    private TrainerService trainerService;

    @Autowired
    public TrainerListController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/trainer_list")
    public String getTrainerList(Model model) {
        List<Trainer> trainerList = trainerService.getAll();
        trainerService.encodeAllAvatars(trainerList);
        model.addAttribute("trainerList", trainerList);
        return "trainer/trainer_list";
    }
}
