package ru.vlsu.fitclub.controller.trainingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.fitclub.model.entity.GroupTraining;
import ru.vlsu.fitclub.model.entity.Subscription;
import ru.vlsu.fitclub.service.ClientService;
import ru.vlsu.fitclub.service.GroupTrainingService;
import ru.vlsu.fitclub.service.SubscriptionService;
import ru.vlsu.fitclub.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class TrainingRestController {

    private UserService userService;
    private GroupTrainingService groupTrainingService;
    private ClientService clientService;
    private SubscriptionService subscriptionService;

    @Autowired
    public TrainingRestController(UserService userService, GroupTrainingService groupTrainingService, ClientService clientService, SubscriptionService subscriptionService) {
        this.userService = userService;
        this.groupTrainingService = groupTrainingService;
        this.clientService = clientService;
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/training/new")
    public String createNewTraining(int groupId) {
        int userId = userService.getCurrentUserId();
        GroupTraining groupTraining = groupTrainingService.getById(groupId);
        List<Subscription> subList = subscriptionService.getAllByUserIdAndActivityId(userId, groupTraining.getActivityId());
        if (subList.isEmpty()) {
           return "No sub,"+groupTraining.getActivityId();
        }
        int clientId = clientService.getClientByUserId(userId).getClientId();
        clientService.addClientToGroupTraining(clientId, groupId);
        return "Success";
    }

}