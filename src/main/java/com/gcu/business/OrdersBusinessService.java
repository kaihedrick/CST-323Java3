package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

//@Service
public class OrdersBusinessService implements OrdersBusinessServiceInterface {
    // Logger already declared
    private static final Logger logger = LoggerFactory.getLogger(OrdersBusinessService.class);
    
    @Autowired
    private OrdersDataService service;
    
    @Override
    public void test() {
        // Log method entry
        logger.info("Entering test() method");
        
        // Existing log
        logger.info("Hello from the OrdersBusinessService");
        
        // Log method exit
        logger.info("Exiting test() method");
    }

    @Override
    public List<OrderModel> getOrders() {
        // Log method entry
        logger.info("Entering getOrders() method");
        
        try {
            // Existing debug log
            logger.debug("Retrieving all orders");
            
            // Get all the entity orders
            List<OrderEntity> ordersEntity = service.findAll();
            
            // Log successful data retrieval
            logger.debug("Successfully fetched {} order entities from database", ordersEntity.size());
            
            // Iterate over the entity orders and create a list of domain orders
            List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
            for(OrderEntity entity : ordersEntity) {
                ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
                logger.trace("Mapped entity ID {} to domain model", entity.getId());
            }
            
            // Existing info log
            logger.info("Retrieved {} orders", ordersDomain.size());
            
            // Log method exit with result information
            logger.info("Exiting getOrders() method successfully with {} orders", ordersDomain.size());
            
            // Return list of domain orders
            return ordersDomain;
        } catch (Exception e) {
            // Log error with exception details
            logger.error("Error in getOrders() method: {}", e.getMessage(), e);
            
            // Log method exit with error
            logger.info("Exiting getOrders() method with exception");
            
            throw e; // Re-throw the exception after logging
        }
    }

    @Override
    public void init() {
        // Log method entry
        logger.info("Entering init() method");
        
        // Existing log
        logger.info("This is the init method");
        
        // Log method exit
        logger.info("Exiting init() method");
    }

    @Override
    public void destroy() {
        // Log method entry
        logger.info("Entering destroy() method");
        
        // Existing log
        logger.info("This is the destroy method");
        
        // Log method exit
        logger.info("Exiting destroy() method");
    }
}