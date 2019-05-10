package bike_store.controller;

import bike_store.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("market")
public class BikeController {


    @Autowired
    private BikeService bikeService;

    @RequestMapping("/bikes")
    public String list(Model model) {
        model.addAttribute("bikes", bikeService.getAllBikes());
        return "bikes";
    }

    @RequestMapping("/update/stock")
    public String updateStock(Model model) {
        bikeService.updateAllStock();
        return "redirect:/bikes";
    }

    @RequestMapping("/bikes/{category}")
    public String getBikesByCategory(Model model, @PathVariable("category") String bikeCategory) {
        model.addAttribute("bikes", bikeService.getBikesByCategory(bikeCategory));
        return "bikes";
    }
}
