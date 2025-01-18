package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/some")
    public ModelAndView print(){
        ModelAndView modelAndView=new ModelAndView("some");
        return modelAndView;
    }
}
