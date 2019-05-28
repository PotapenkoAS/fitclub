package ru.vlsu.fitclub.controller.trainingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.fitclub.model.entity.GroupTraining;
import ru.vlsu.fitclub.model.entity.Subscription;
import ru.vlsu.fitclub.model.restObject.CalendarSchedule;
import ru.vlsu.fitclub.service.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TrainingRestController {

    private UserService userService;
    private GroupTrainingService groupTrainingService;
    private ClientService clientService;
    private SubscriptionService subscriptionService;
    private CalendarScheduleService calendarScheduleService;

    @Autowired
    public TrainingRestController(UserService userService, GroupTrainingService groupTrainingService, ClientService clientService, SubscriptionService subscriptionService, CalendarScheduleService calendarScheduleService) {
        this.userService = userService;
        this.groupTrainingService = groupTrainingService;
        this.clientService = clientService;
        this.subscriptionService = subscriptionService;
        this.calendarScheduleService = calendarScheduleService;
    }

    @PostMapping("/training/new")
    public String createNewTraining(int groupId) {
        int userId = userService.getCurrentUserId();
        GroupTraining groupTraining = groupTrainingService.getById(groupId);
        List<Subscription> subList = subscriptionService.getAllByUserIdAndActivityId(userId, groupTraining.getActivityId());
        if (subList.isEmpty()) {
            return "No sub," + groupTraining.getActivityId();
        }
        int clientId = clientService.getClientByUserId(userId).getClientId();
        clientService.addClientToGroupTraining(clientId, groupId);
        return "Success";
    }

    @GetMapping("/trainer_schedule/refresh")
    public ArrayList<CalendarSchedule> refreshTrainerSchedule(@RequestParam(name = "month_offset") int monthOffset
            , @RequestParam(name = "trainer_id") int trainerId) {
        return calendarScheduleService.getListCalendarScheduleByTrainerIdForMonth(trainerId,monthOffset);
    }
}
