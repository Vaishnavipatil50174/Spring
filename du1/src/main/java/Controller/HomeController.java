package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        System.out.println("Home");
        return "index";
    }

    @RequestMapping("/about")
    public String about(){
        System.out.println("About");
        return "about";
    }
    @RequestMapping("/some")
    public ModelAndView some(){
        ModelAndView modelAndView=new ModelAndView("some");
        System.out.println("About");
        return modelAndView;
    }
}
//index view ka nam