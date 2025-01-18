package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {



    @RequestMapping("/welcome")
    public ModelAndView getPage(){
        System.out.println("Hello");
        ModelAndView m = new ModelAndView();
        m.setViewName("welcome");
        return m;
    }
    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home");

        model.addAttribute("name","Vaishnvi Ravindra Patil");
        return "index";
    }
}
