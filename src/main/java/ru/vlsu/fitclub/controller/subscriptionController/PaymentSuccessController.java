package ru.vlsu.fitclub.controller.subscriptionController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentSuccessController {

    @GetMapping("new_sub/success")
    public String getSuccess(){
        return "subscription/success";
    }
}
