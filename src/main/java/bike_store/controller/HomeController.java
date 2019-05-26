package bike_store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping
    public String welcome(Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("greeting", "Welcome to the Canyon Bike's Online Store!!!");
        model.addAttribute("tagline", "Best place where you buy a amazing bike:)");
        redirectAttributes.addFlashAttribute("greeting", "Welcome to the Canyon Bike's Online Store!!!");
        redirectAttributes.addFlashAttribute("tagline", "Best place where you buy a amazing bike:)");
        return "redirect:/welcome/greeting";
    }

    @RequestMapping("welcome/greeting")
    public String greeting() {
        return "welcome";
    }
}
