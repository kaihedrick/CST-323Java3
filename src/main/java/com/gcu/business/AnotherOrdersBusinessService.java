package com.gcu.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcu.model.OrderModel;

public class AnotherOrdersBusinessService implements OrdersBusinessServiceInterface {
    // Create a static logger instance using LoggerFactory
    private static final Logger logger = LoggerFactory.getLogger(AnotherOrdersBusinessService.class);

    @Override
    public void test() {
        // Log method entry
        logger.info("Entering test() method");
        
        // Replace System.out with logger
        logger.info("Hello from the AnotherOrdersBusinessService");
        
        // Log method exit
        logger.info("Exiting test() method");
    }

    @Override
    public List<OrderModel> getOrders() {
        // Log method entry
        logger.info("Entering getOrders() method");
        
        // Log error for unimplemented method
        logger.error("Method getOrders() is not implemented");
        
        // Log method exit with exception
        logger.info("Exiting getOrders() method with exception");
        
        throw new UnsupportedOperationException("Unimplemented method 'getOrders'");
    }

    @Override
    public void init() {
        // Log method entry
        logger.info("Entering init() method");
        
        // Replace System.out with logger
        logger.info("This is the init method");
        
        // Log method exit
        logger.info("Exiting init() method");
    }

    @Override
    public void destroy() {
        // Log method entry
        logger.info("Entering destroy() method");
        
        // Replace System.out with logger
        logger.info("This is the destroy method");
        
        // Log method exit
        logger.info("Exiting destroy() method");
    }
}
