package sg.edu.nus.iss.workshop23.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.workshop23.model.OrderDetails;
import sg.edu.nus.iss.workshop23.service.OrderDetailsService;

@Controller
@RequestMapping(path = "/order")
public class OrderDetailsController {

    @Autowired
    OrderDetailsService odService;

    @GetMapping
    public String getOrderEnquiryForm(Model model, @ModelAttribute OrderDetails orderDetails) {
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("display", false);
        model.addAttribute("error", false);
        return "form";
    }

    @GetMapping(path = "/total")
    public String getOrderDetails(Model model, @RequestParam int orderId, @ModelAttribute OrderDetails orderdDetails) {

        OrderDetails od = odService.getOrderDetails(orderId);
        orderdDetails = od;
        if (orderdDetails == null) {
            model.addAttribute("display", false);
            model.addAttribute("error", true);
            return "form";
        }
        System.out.println(orderdDetails.toString());
        model.addAttribute("error", false);
        model.addAttribute("display", true);
        model.addAttribute("orderDetails", orderdDetails);

        return "form";
    }
}
