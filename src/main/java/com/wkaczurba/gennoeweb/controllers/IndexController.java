package com.wkaczurba.gennoeweb.controllers;

import com.wkaczurba.text.RandomText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    RandomText randomText;

    @RequestMapping("/")
    public String requestMapping(Model model) {
        model.addAttribute("welcome", "Hello...");
        model.addAttribute("result", new String(randomText.getRandomChars()));
        return "index";
    }
}

