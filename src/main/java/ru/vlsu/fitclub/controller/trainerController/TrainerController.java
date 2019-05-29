package ru.vlsu.fitclub.controller.trainerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.vlsu.fitclub.model.entity.Subscription;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.service.SubscriptionService;
import ru.vlsu.fitclub.service.TrainerService;
import ru.vlsu.fitclub.service.UserService;

import java.util.Base64;
import java.util.List;

@Controller
public class TrainerController {


    private TrainerService trainerService;
    private UserService userService;
    private SubscriptionService subscriptionService;

    @Autowired
    public TrainerController(TrainerService trainerService, UserService userService, SubscriptionService subscriptionService) {
        this.trainerService = trainerService;
        this.userService = userService;
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/trainer")
    public String getTrainerHomePage() {
        int id = userService.getCurrentUserId();
        return "redirect:/trainer/" + id;
    }

    @GetMapping("/trainer/{userId}")
    public String GetTrainerId(@PathVariable int userId, Model model) {
        Trainer trainer = trainerService.getTrainerByUserId(userId);
        String avatar = Base64.getEncoder().encodeToString(trainer.getAvatar());
        model.addAttribute("avatar", avatar);
        model.addAttribute("trainer", trainer);
        model.addAttribute("specializations", trainerService.getTrainerSpecializations(trainer));
        return "trainer/trainer_site";
    }

    @PostMapping("/trainer/sub_check")
    public String postSubCheck(int trainerId, RedirectAttributes redirectAttributes) {
        List<Subscription> subList = subscriptionService.getAllByTrainerId(trainerId);
        if (subList.isEmpty()) {
            return "redirect:/new_sub?trainer_id=" + trainerId;
        } else {
            redirectAttributes.addAttribute("trainerId", trainerId);
            return "redirect:/new_train?trainer_id=" + trainerId;
        }
    }
}
