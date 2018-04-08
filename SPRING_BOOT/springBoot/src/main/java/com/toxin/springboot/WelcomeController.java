package com.toxin.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @Value("${welcome.message:test}")
    private String message;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String welcome(Model model) {
        model.addAttribute("message", this.message);
        System.out.println(this.message);
        return "welcome";
    }

}
