package ru.vlsu.fitclub.controller.trainingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.fitclub.model.entity.GroupTraining;
import ru.vlsu.fitclub.model.entity.Subscription;
import ru.vlsu.fitclub.model.restObject.CalendarSchedule;
import ru.vlsu.fitclub.service.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
public class TrainingRestController {

    private UserService userService;
    private GroupTrainingService groupTrainingService;
    private ClientService clientService;
    private SubscriptionService subscriptionService;
    private CalendarScheduleService calendarScheduleService;
    private TrainingService trainingService;

    @Autowired
    public TrainingRestController(UserService userService, GroupTrainingService groupTrainingService, ClientService clientService, SubscriptionService subscriptionService, CalendarScheduleService calendarScheduleService, TrainingService trainingService) {
        this.userService = userService;
        this.groupTrainingService = groupTrainingService;
        this.clientService = clientService;
        this.subscriptionService = subscriptionService;
        this.calendarScheduleService = calendarScheduleService;
        this.trainingService = trainingService;
    }

    @PostMapping("/group_training/new")
    public String createNewGroupTraining(int groupId) {
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
    public ArrayList<CalendarSchedule> refreshTrainerSchedule(@RequestParam(name = "month_offset") int monthOffset, @RequestParam(name = "trainer_id") int trainerId) {
        return calendarScheduleService.getListCalendarScheduleByTrainerIdForMonth(trainerId, monthOffset);
    }

    @PostMapping("/training/new")
    public void createNewTraining(int week, int day, int offset, Time timeBegin, Time timeEnd, int activityId, int trainerId) {
        int clientId = clientService.getClientByUserId(userService.getCurrentUserId()).getClientId();
        GregorianCalendar date = new GregorianCalendar();
        date.add(Calendar.MONTH, offset);
        date.set(Calendar.WEEK_OF_MONTH, week + 1);
        date.set(Calendar.DAY_OF_WEEK, dayOfWeekConvert(day));
        trainingService.save(clientId, trainerId,activityId,date.getTime(),timeBegin,timeEnd);
    }

    @DeleteMapping("/training/delete")
    public void deleteTraining(int week, int day, int offset, Time timeBegin, Time timeEnd, int activityId, int trainerId){
        int clientId = clientService.getClientByUserId(userService.getCurrentUserId()).getClientId();
        GregorianCalendar date = new GregorianCalendar();
        date.add(Calendar.MONTH, offset);
        date.set(Calendar.WEEK_OF_MONTH, week + 1);
        date.set(Calendar.DAY_OF_WEEK, dayOfWeekConvert(day));
        trainingService.delete(clientId, trainerId,activityId,date.getTime(),timeBegin,timeEnd);
    }

    private int dayOfWeekConvert(int day) {
        switch (day) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 5;
            case 4:
                return 6;
            case 5:
                return 7;
            case 6:
                return 1;
            default:
                return -1;
        }
    }
}
