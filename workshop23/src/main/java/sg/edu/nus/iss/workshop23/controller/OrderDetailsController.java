package sg.edu.nus.iss.workshop23.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

        // add order id list to try path variable get method
        List<String> orderIdList = odService.getOrdersId();
        model.addAttribute("orderIdList", orderIdList);
        return "form";
    }

    // query string GET method
    @GetMapping(path = "/total")
    public String getOrderDetails(Model model, @RequestParam int orderId,
            @ModelAttribute OrderDetails orderdDetails) {
        List<String> orderIdList = odService.getOrdersId();
        // OrderDetails od = odService.getOrderDetails(orderId);
        // orderdDetails = od;
        // if (orderdDetails == null) {
        // model.addAttribute("display", false);
        // model.addAttribute("error", true);
        // model.addAttribute("orderIdList", orderIdList);
        // return "form";
        // }
        // System.out.println(orderdDetails.toString());
        model.addAttribute("error", false);
        model.addAttribute("display", true);
        model.addAttribute("orderDetails", orderdDetails);
        model.addAttribute("orderIdList", orderIdList);
        // if return "form" then the URL will be in query string:
        // http://localhost:8080/order/total?orderId=1
        // return "form";

        // return as path variable
        return "redirect:/order/total/" + orderId;
    }

    // path variable GET method
    @GetMapping(path = "/total/{id}")
    public String getOrderDetailsPathVariable(Model model, @PathVariable String id,
            @ModelAttribute OrderDetails orderdDetails) {
        List<String> orderIdList = odService.getOrdersId();

        System.out.println("Path variable >>>>>>>>>>>>>>>" + id);
        OrderDetails od = odService.getOrderDetails(Integer.parseInt(id));
        orderdDetails = od;
        if (orderdDetails == null) {
            model.addAttribute("display", false);
            model.addAttribute("error", true);
            model.addAttribute("orderIdList", orderIdList);
            return "form";
        }
        System.out.println(orderdDetails.toString());
        model.addAttribute("error", false);
        model.addAttribute("display", true);
        model.addAttribute("orderDetails", orderdDetails);
        model.addAttribute("orderIdList", orderIdList);
        return "form";
    }

    // path variable POST method
    @PostMapping(path = "/total/{id}")
    public String postOrderDetailsPathVariable(Model model, @PathVariable String id,
            @ModelAttribute OrderDetails orderDetails) {
        List<String> orderIdList = odService.getOrdersId();
        System.out.println("Path variable >>>>>>>>>>>>>>>" + id);
        System.out.println("Object ID >>>>>>>>>>>>>>>" + orderDetails.getId());
        OrderDetails od = odService.getOrderDetails(orderDetails.getId());
        orderDetails = od;
        if (orderDetails == null) {
            model.addAttribute("display", false);
            model.addAttribute("error", true);
            model.addAttribute("orderIdList", orderIdList);
            return "form";
        }
        System.out.println(orderDetails.toString());
        model.addAttribute("error", false);
        model.addAttribute("display", true);
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("orderIdList", orderIdList);
        return "form";
    }
}
