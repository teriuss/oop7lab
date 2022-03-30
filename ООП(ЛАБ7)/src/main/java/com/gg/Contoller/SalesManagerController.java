package com.gg.Contoller;


import com.gg.Pojo.Client;
import com.gg.Pojo.Contract;
import com.gg.Pojo.Permit;
import com.gg.Pojo.Tour;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/salesManager")
public class SalesManagerController {

    @RequestMapping("/menu-view")
    public String showMenu(){
        return "menu-view";
    }

    @RequestMapping("show-dates-and-program-view")
    public String showDatesAndProgram(Model model){
        model.addAttribute("tour",new Tour());
        return "salesManager/show-dates-and-program-view";
    }

    @RequestMapping("issue-contract-view")
    public String issueContract(Model model){
        model.addAttribute("contract",new Contract());
        return "salesManager/issue-contract-view";
    }

    @RequestMapping("create-tour-permit-view")
    public String createPermit(Model model){
        model.addAttribute("permit",new Permit());
        return "salesManager/create-tour-permit-view";
    }

    @RequestMapping("get-client-information-view")
    public String getClientInformation(Model model){
        model.addAttribute("client",new Client());
        return "salesManager/get-client-information-view";
    }

    @RequestMapping("get-tour-information-view")
    public String getTourInformation(Model model){
        model.addAttribute("tour",new Tour());
        return "salesManager/get-tour-information-view";
    }
}
