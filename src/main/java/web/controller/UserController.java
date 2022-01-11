package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value = "/")
    public String userManagement(Model model) {
        String c = "hghghghghgh";
        model.addAttribute("message", c);
        return "page";
    }
}
