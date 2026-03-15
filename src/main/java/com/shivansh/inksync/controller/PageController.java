package com.shivansh.inksync.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/note/**")
    public String notePage() {
        return "forward:/index.html";
    }

}