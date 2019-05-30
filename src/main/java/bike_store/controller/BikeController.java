package bike_store.controller;

import bike_store.domain.Bike;
import bike_store.domain.Customer;
import bike_store.exception.BikeNotFoundException;
import bike_store.exception.NoBikesFoundUnderCategoryException;
import bike_store.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
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
    public String getBikesByCategory(Model model, @PathVariable("category") String category) {
        List<Bike> bikes = bikeService.getBikesByCategory(category);
        if (bikes == null || bikes.isEmpty()) {
            throw new NoBikesFoundUnderCategoryException();
        }
        model.addAttribute("bikes", bikes);
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

    @RequestMapping("/bikes/invalidPromoCode")
    public String invalidPromoCode() {
        return "invalidPromoCode";
    }

    @RequestMapping(value = "/bikes/add", method = RequestMethod.GET)
    public String getAddNewBikeForm(Model model) {
        Bike newBike = new Bike();
        model.addAttribute("newBike", newBike);
        return "addBike";
    }

    @RequestMapping(value = "/bikes/add", method = RequestMethod.POST)
    public String processAddNewBikeForm(@ModelAttribute("newBike") @Valid Bike newBike, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addBike";
        }

        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: "
                    + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        MultipartFile bikeImage = newBike.getBikeImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (bikeImage != null && !bikeImage.isEmpty()) {
            try {
                bikeImage.transferTo(new File(rootDirectory + "resources\\images" + newBike.getBikeId() + ".jpg"));
            } catch (Exception e) {
                throw new RuntimeException("Bike Image Saving Failed", e);
            }
        }
        bikeService.addBike(newBike);
        return "redirect:/market/bikes";
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.GET)
    public String getAddNewCustomerForm(Model model) {
        Customer newCustomer = new Customer();
        model.addAttribute("newCustomer", newCustomer);
        return "addCustomer";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setAllowedFields(
                "bikeId",
                "name",
                "unitPrice",
                "description",
                "manufacturer",
                "category",
                "unitsInStock",
                "condition",
                "bikeImage",
                "language");
    }

    @ExceptionHandler(BikeNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest request, BikeNotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("invalidBikeId", exception.getBikeId());
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("url", request.getRequestURL() + "?" + request.getQueryString());
        modelAndView.setViewName("bikeNotFound");
        return modelAndView;
    }


}
