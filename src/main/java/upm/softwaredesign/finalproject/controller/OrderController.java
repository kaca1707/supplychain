package upm.softwaredesign.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import upm.softwaredesign.finalproject.viewmodel.OrderViewModel;

@Controller
public class OrderController {

    @GetMapping("/order")
    public ModelAndView index(ModelAndView mav) {


        mav.setViewName("order/index");
        return mav;
    }

    @PostMapping("/order")
    public ModelAndView createNewOrder(ModelAndView modelAndView, OrderViewModel model) {

        modelAndView.setViewName("redirect:/");

        System.out.println("Received new order...." + model.getActor());
        return modelAndView;
    }

}
