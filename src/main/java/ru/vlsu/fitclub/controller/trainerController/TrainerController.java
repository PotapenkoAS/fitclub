package ru.vlsu.fitclub.controller.trainerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.vlsu.fitclub.model.CustomUserDetails;
import ru.vlsu.fitclub.model.entity.Client;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.service.TrainerService;

import java.util.Base64;

@Controller
public class TrainerController {


    private TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }


    @GetMapping("/trainer")
    public String getTrainerHomePage() {
        //int id = ((CustomUserDetails) (SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getUserId();
        // return "redirect:/trainer/" + id;

        return "trainer/trainer_site";
    }

    @GetMapping("/trainer/{userId}")
    public String GetTrainerId(@PathVariable int userId, Model model) {
        //Client client = clientService.getClientByUserId(userId);
        Trainer trainer = trainerService.getTrainerByUserId(userId);
        String avatar = Base64.getEncoder().encodeToString(trainer.getAvatar());
        model.addAttribute("avatar", avatar);
        model.addAttribute("trainer", trainer);
        model.addAttribute("specializations", trainerService.getTrainerSpecializations(trainer));

        return "trainer/trainer_site";
    }

}
