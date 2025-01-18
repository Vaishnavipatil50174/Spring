package org.example.controller;

import org.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    // Show form for submitting data
    @GetMapping("/userForm")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";  // Returns the JSP page with a form to submit user details
    }

    // Handle form submission and redirect to a page to display the data
    @PostMapping("/submitUser")
    public String submitUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "userDetails";  // The JSP page to display user details
    }
}
