package com.gg.Contoller;

import com.gg.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorizationController {

    @RequestMapping("/login")
    public String login(@ModelAttribute("user") User user){

        if(user.getUserType().equals("Deputy Director"))
        {
            return "/deputyDirector/menu-view";
        }
        else if(user.getUserType().equals("Tour Composer"))
        {
            return "/tourComposer/menu-view";
        }
        else if(user.getUserType().equals("Tour Manager"))
        {
            return "/tourManager/menu-view";
        }
        else if(user.getUserType().equals("Sales Manager"))
        {
            return "/salesManager/menu-view";
        }
        return "";
    }

    @RequestMapping("/")
    public String authorView(Model model){
        model.addAttribute("user",new User());
        return "index";
    }

}
