package bike_store.controller;

import bike_store.domain.Bike;
import bike_store.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @RequestMapping("/bikes/filter/{params}")
    public String getBikesByFilter(@MatrixVariable(pathVar = "params")
                                           Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("bikes", bikeService.getBikesByFilter(filterParams));
        return "bikes";
    }

    @RequestMapping("/bike")
    public String getBikeById(@RequestParam("id") String bikeId, Model model) {
        model.addAttribute("bike", bikeService.getBikeById(bikeId));
        return "bike";
    }

    @RequestMapping(value = "/bikes/add", method = RequestMethod.GET)
    public String getAddNewBikeForm(Model model) {
        Bike newBike = new Bike();
        model.addAttribute("newBike", newBike);
        return "addBike";
    }

    @RequestMapping(value = "/bikes/add", method = RequestMethod.POST)
    public String processAddNewBikeForm(@ModelAttribute("newBike") Bike newBike) {
        bikeService.addBike(newBike);
        return "redirect:/market/bikes";

    }
}
