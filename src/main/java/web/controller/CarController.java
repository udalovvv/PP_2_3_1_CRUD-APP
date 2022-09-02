package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @GetMapping(value = "/car")
    public String showCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        if (count == null) {count = 5;}

        model.addAttribute("car", carService.getCars(count));

        return "car";
    }
}
