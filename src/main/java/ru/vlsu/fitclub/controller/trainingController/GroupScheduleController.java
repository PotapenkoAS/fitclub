package ru.vlsu.fitclub.controller.trainingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.GroupTraining;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.service.ActivityService;
import ru.vlsu.fitclub.service.GroupScheduleService;
import ru.vlsu.fitclub.service.TrainerService;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
public class GroupScheduleController {

    private GroupScheduleService scheduleService;
    private ActivityService activityService;
    private TrainerService trainerService;

    @Autowired
    public GroupScheduleController(GroupScheduleService scheduleService, ActivityService activityService, TrainerService trainerService) {
        this.scheduleService = scheduleService;
        this.activityService = activityService;
        this.trainerService = trainerService;
    }

    @GetMapping("/group_training")
    public String postGroupSchedule(Model model, String dateBegin, String dateEnd, String timeBegin, String timeEnd, Integer trainerId, Integer activityId) {
        GregorianCalendar cal = new GregorianCalendar();
        if (dateBegin == null || dateBegin.equals("")) {
            dateBegin = validateDate(cal);
        }
        if (dateEnd == null || dateEnd.equals("")) {
            cal.add(Calendar.DAY_OF_MONTH, 14);
            dateEnd = validateDate(cal);
            cal.add(Calendar.DAY_OF_MONTH, -14);
        }
        if (timeBegin == null || timeBegin.equals("")) {
            timeBegin = "00:00:00";
        } else if (timeBegin.length() < 6) {
            timeBegin += ":00";
        }
        if (timeEnd == null || timeEnd.equals("")) {
            timeEnd = "23:59:00";
        } else if (timeEnd.length() < 6) {
            timeEnd += ":00";
        }
        if (trainerId == null) {
            trainerId = 0;
        }
        if (activityId == null) {
            activityId = 0;
        }
        List<GroupTraining> list = scheduleService.getGroupSchedule(Date.valueOf(dateBegin)
                , Date.valueOf(dateEnd)
                , Time.valueOf(timeBegin)
                , Time.valueOf(timeEnd)
                , trainerId
                , activityId);
        scheduleService.setIsRecordedForAll(list);
        ArrayList<Trainer> trainerList = trainerService.getTrainerList();
        ArrayList<Activity> activityList = activityService.getActivityList();
        model.addAttribute("list", list);
        model.addAttribute("trainerList", trainerList);
        model.addAttribute("activityList", activityList);
        model.addAttribute("dateBegin", dateBegin);
        model.addAttribute("dateEnd", dateEnd);
        model.addAttribute("timeBegin", timeBegin);
        model.addAttribute("timeEnd", timeEnd);
        model.addAttribute("trainerId", trainerId);
        model.addAttribute("activityId", activityId);
        return "training/training_group_schedule";
    }


    private String validateDate(Calendar cal) {

        String date = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
        if (cal.get(Calendar.MONTH) + 1 < 10) {
            date = date.substring(0, 5) + "0" + date.substring(5);
        }
        if (cal.get(Calendar.DAY_OF_MONTH) < 10) {
            date = date.substring(0, 8) + "0" + date.substring(8);
        }
        return date;
    }
}
