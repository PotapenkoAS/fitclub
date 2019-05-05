package ru.vlsu.fitclub.controller.trainingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vlsu.fitclub.model.GroupSchedule;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.service.GroupScheduleService;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
public class GroupScheduleController {

    private GroupScheduleService scheduleService;

    @Autowired
    public GroupScheduleController(GroupScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/group_training")
    public String postGroupSchedule(Model model, String dateBegin, String dateEnd, String timeBegin, String timeEnd, Integer trainerId, Integer activityId) {
        GregorianCalendar cal = new GregorianCalendar();
        if (dateBegin == null || dateBegin.equals("")) {
            dateBegin = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
        }
        if (dateEnd == null || dateEnd.equals("")) {
            cal.add(Calendar.DAY_OF_MONTH, 14);
            dateEnd = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
            cal.add(Calendar.DAY_OF_MONTH, -14);

        }
        if (timeBegin == null || timeBegin.equals("")) {
            timeBegin = "00:00:00";
        } else {
            timeBegin += ":00";
        }
        if (timeEnd == null || timeEnd.equals("")) {
            timeEnd = "23:59:59";
        } else {
            timeEnd += ":00";
        }
        if (trainerId == null) {
            trainerId = 0;
        }
        if (activityId == null) {
            activityId = 0;
        }
        ArrayList<GroupSchedule> list = scheduleService.getGroupSchedule(Date.valueOf(dateBegin)
                , Date.valueOf(dateEnd)
                , Time.valueOf(timeBegin)
                , Time.valueOf(timeEnd)
                , trainerId
                , activityId);
        model.addAttribute("list", list);
        ArrayList<Trainer> trainerList = scheduleService.getTrainerList();
        ArrayList<Activity> activityList = scheduleService.getActivityList();
        model.addAttribute("trainerList", trainerList);
        model.addAttribute("activityList", activityList);
        model.addAttribute("dateBegin",dateBegin);
        model.addAttribute("dateEnd",dateEnd);
        model.addAttribute("timeBegin",timeBegin);
        model.addAttribute("timeEnd",timeEnd);
        model.addAttribute("trainerId",trainerId);
        model.addAttribute("activityId",activityId);
        return "training/training_group_schedule";
    }
}
