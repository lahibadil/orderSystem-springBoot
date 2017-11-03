package com.lahib.bootstrap;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    @Scheduled(fixedRate = 60000)
    public void printTime(){
        System.out.println(SimpleDateFormat.getInstance().format(new Date()));
    }
}
