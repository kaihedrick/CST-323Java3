package com.gcu.controller;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    // Create a static logger instance using LoggerFactory
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final OrdersBusinessServiceInterface ordersService;

    public LoginController(OrdersBusinessServiceInterface ordersService) {
        // Log constructor call
        logger.info("Initializing LoginController");
        this.ordersService = ordersService;
    }

    @GetMapping("/")
    public String display(Model model) {
        // Log method entry
        logger.info("Entering display() method");
        
        try {
            model.addAttribute("title", "Login Form");
            model.addAttribute("loginModel", new LoginModel());
            
            // Log method exit with view name
            logger.info("Exiting display() method, returning view: 'login'");
            
            return "login";
        } catch (Exception e) {
            // Log error with exception details
            logger.error("Error in display() method: {}", e.getMessage(), e);
            
            // Log method exit with error
            logger.info("Exiting display() method with exception");
            
            throw e; // Re-throw the exception after logging
        }
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        // Log method entry with username (avoid logging password)
        logger.info("Entering doLogin() method for username: {}", loginModel.getUsername());
        
        try {
            // Check for validation errors
            if (bindingResult.hasErrors()) {
                logger.warn("Validation errors found in login form: {}", bindingResult.getAllErrors());
                model.addAttribute("title", "Login Form");
                
                // Log method exit with view name
                logger.info("Exiting doLogin() method due to validation errors, returning view: 'login'");
                
                return "login";
            }

            // Log authentication attempt
            logger.debug("Attempting to authenticate user: {}", loginModel.getUsername());
            
            // Perform authentication
            boolean isAuthenticated = SecurityBusinessService.authenticate(loginModel.getUsername(), loginModel.getPassword());

            if (isAuthenticated) {
                // Log successful authentication
                logger.info("User '{}' authenticated successfully", loginModel.getUsername());
                
                // Get orders and add to model
                logger.debug("Retrieving orders for authenticated user");
                List<OrderModel> orders = ordersService.getOrders();
                model.addAttribute("orders", orders);
                model.addAttribute("title", "Order List");
                
                // Log method exit with view name
                logger.info("Exiting doLogin() method after successful authentication, returning view: 'orders'");
                
                return "orders";
            } else {
                // Log failed authentication
                logger.warn("Authentication failed for user: {}", loginModel.getUsername());
                
                // Add error message to model
                model.addAttribute("title", "Login Form");
                model.addAttribute("error", "Invalid username or password");
                
                // Log method exit with view name
                logger.info("Exiting doLogin() method after failed authentication, returning view: 'login'");
                
                return "login";
            }
        } catch (Exception e) {
            // Log error with exception details
            logger.error("Error in doLogin() method for user {}: {}", loginModel.getUsername(), e.getMessage(), e);
            
            // Log method exit with error
            logger.info("Exiting doLogin() method with exception");
            
            throw e; // Re-throw the exception after logging
        }
    }
}
