package com.lahib.db.controllers;

import com.lahib.db.security.AccountUserDetailsService;
import com.lahib.db.services.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/")
@Slf4j
public class NotificationController {

    private NotificationService notificationService;
    private AccountUserDetailsService userDetailsService;

    @Autowired
    public NotificationController(NotificationService notificationService,AccountUserDetailsService userDetailsService) {
        this.notificationService = notificationService;
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping("/sendMail")
    public void sendMail(){

        try {
            notificationService.sendEmail(userDetailsService.getAccount(), "Welcome to our orders system");
            log.info("mail sent successfully");
        }catch (Exception e){
            log.error("Sendin email ERROR : " + e.getMessage());
        }
    }
}
