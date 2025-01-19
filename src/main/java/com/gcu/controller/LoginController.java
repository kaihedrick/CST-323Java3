package com.gcu.controller;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    private OrdersBusinessServiceInterface ordersService;
    public LoginController(OrdersBusinessServiceInterface ordersService, SecurityBusinessService securityService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Form");
            return "login";
        }

        // Call authentication service
        boolean isAuthenticated = SecurityBusinessService.authenticate(loginModel.getUsername(), loginModel.getPassword());

        if (isAuthenticated) {
            // Get orders from the service
            List<OrderModel> orders = ordersService.getOrders();

            model.addAttribute("orders", orders);
            model.addAttribute("title", "Order List");

            return "orders";
        } else {
            // Authentication failed, return to login form with error message
            model.addAttribute("title", "Login Form");
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
