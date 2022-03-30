package com.gg.Contoller;


import com.gg.Model.User;
import com.gg.Pojo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deputyDirector")
public class DeputyDirectoController {

    @RequestMapping("/menu-view")
    public String showMenu(@ModelAttribute("director") User user){
        return "menu-view";
    }

    @RequestMapping("/task-generate-view")
    public String taskGenerate(Model model){
        model.addAttribute("tasks",new TourTasks());
        return "deputyDirector/task-generate-view";
    }

    @RequestMapping("/show-ticket-sales-view")
    public String showTicketSales(Model model){
        model.addAttribute("permit",new Permit());
        return "deputyDirector/show-ticket-sales-view";
    }

    @RequestMapping("/establish-position-view")
    public String establishPosition(Model model){
        model.addAttribute("staff",new Staff());
        return "deputyDirector/establish-position-view";
    }

    @RequestMapping("/hire-employee-view")
    public String hireEmployee(Model model){
        model.addAttribute("staff",new Staff());
        return "deputyDirector/hire-employee-view";
    }

    @RequestMapping("/assign-task-view")
    public String assignTask(Model model){
        model.addAttribute("tasks",new TourTasks());
        return "deputyDirector/assign-task-view";
    }

    @RequestMapping("/appoint-tour-manager-view")
    public String appointTourManager(Model model){
        model.addAttribute("order",new OrderTable());
        return "deputyDirector/appoint-tour-manager-view";
    }

    @RequestMapping("/supervise-preparation-view")
    public String supervisePreparation(){
        return "deputyDirector/supervise-preparation-view";
    }

    @RequestMapping("/show-reviews-view")
    public String showReviews(){
        return "show-reviews-view";
    }

    @RequestMapping("/translate-tour-view")
    public String translateTour(Model model){
        model.addAttribute("tour",new Tour());
        return "deputyDirector/translate-tour-view";
    }

    @RequestMapping("/delete-tour-view")
    public String deleteTour(Model model){
        model.addAttribute("tour",new Tour());
        return "deputyDirector/delete-tour-view";
    }

    @RequestMapping("/show-tour-sales")
    public String showTourSales(Model model){
        model.addAttribute("tour",new Tour());
        return "deputyDirector/show-tour-sales";
    }

}
