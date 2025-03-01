package pororoAndFriends.ToyProject01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String HomeController() {
        return "home";
    }

    @GetMapping("/articleCreate")
    public String articleCreateController() {
        return "articleCreateForm";
    }

    @GetMapping("/articleUpdate")
    public String articleUpdateController() {
        return "articleUpdateForm";
    }
}
