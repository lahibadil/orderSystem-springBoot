package com.lahib.db.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class WelcomeController {

    @RequestMapping({"/","","/index"})
    public String welcome(){
        return "index";
    }
}
