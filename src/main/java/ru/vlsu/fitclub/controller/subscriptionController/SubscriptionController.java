package ru.vlsu.fitclub.controller.subscriptionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlsu.fitclub.model.CustomUserDetails;
import ru.vlsu.fitclub.model.entity.Subscription;
import ru.vlsu.fitclub.service.ClientService;

import java.util.Collection;

@Controller
public class SubscriptionController {

    private ClientService clientService;

    @Autowired
    public SubscriptionController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("new_sub")
    public String getNewSubWithActivity(@RequestParam(name = "activityId", defaultValue = "0") int activityId, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = ((CustomUserDetails)principal).getUserId();
        Collection<Subscription> list = clientService.getClientSubs(userId);
        return "subscription/new_sub";
    }

}
