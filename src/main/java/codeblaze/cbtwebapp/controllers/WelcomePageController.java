package codeblaze.cbtwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomePageController {
    @GetMapping("/index")
    public String getWelcomePage(Model model){
        return "index";
    }
    @GetMapping("/studentcreateorlogin")
    public String getProfilePage(Model model){
        return "studentcreateorlogin";
    }
}
