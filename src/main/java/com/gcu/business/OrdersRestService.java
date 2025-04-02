package com.gcu.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrdersList;
import com.gcu.model.OrderModel;

@RestController
@RequestMapping("/service")
public class OrdersRestService {
    // Create a static logger instance using LoggerFactory
    private static final Logger logger = LoggerFactory.getLogger(OrdersRestService.class);
    
    private final OrdersBusinessServiceInterface orders;
    
    public OrdersRestService(OrdersBusinessServiceInterface orders) {
        // Log constructor call
        logger.info("Initializing OrdersRestService");
        this.orders = orders;
    }
    
    @GetMapping(path="/getjson", produces={MediaType.APPLICATION_JSON_VALUE})
    public List<OrderModel> getOrdersAsJson() {
        // Log method entry
        logger.info("Entering getOrdersAsJson() method");
        
        try {
            // Get orders from service
            List<OrderModel> ordersList = orders.getOrders();
            
            // Log method exit with return value information
            logger.info("Exiting getOrdersAsJson() method successfully with {} orders", ordersList.size());
            
            return ordersList;
        } catch (Exception e) {
            // Log error with exception details
            logger.error("Error in getOrdersAsJson() method: {}", e.getMessage(), e);
            
            // Log method exit with error
            logger.info("Exiting getOrdersAsJson() method with exception");
            
            throw e; // Re-throw the exception after logging
        }
    }
    
    @GetMapping(path="/getxml", produces={MediaType.APPLICATION_XML_VALUE})
    public OrdersList getOrdersAsXml() {
        // Log method entry
        logger.info("Entering getOrdersAsXml() method");
        
        try {
            // Create OrdersList and populate it
            OrdersList list = new OrdersList();
            List<OrderModel> ordersList = orders.getOrders();
            list.setOrders(ordersList);
            
            // Log method exit with return value information
            logger.info("Exiting getOrdersAsXml() method successfully with {} orders", ordersList.size());
            
            return list;
        } catch (Exception e) {
            // Log error with exception details
            logger.error("Error in getOrdersAsXml() method: {}", e.getMessage(), e);
            
            // Log method exit with error
            logger.info("Exiting getOrdersAsXml() method with exception");
            
            throw e; // Re-throw the exception after logging
        }
    }
}
