package bike_store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to the Canyon Bike's Online Store!!!");
        model.addAttribute("tagline", "Best place where you buy a amaizing bike:)");
        return "welcome";
    }

    @RequestMapping("welcome/greeting")
    public String greeting() {
        return "welcome";
    }
}
