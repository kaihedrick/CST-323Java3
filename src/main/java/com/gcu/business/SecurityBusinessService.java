package com.gcu.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService
{
    // Create a static logger instance using LoggerFactory
    private static final Logger logger = LoggerFactory.getLogger(SecurityBusinessService.class);

    public static boolean authenticate(String username, String password)
    {
        // Log method entry with username parameter (avoid logging sensitive data like passwords)
        logger.info("Entering authenticate() method for username: {}", username);
        
        try {
            // Replace System.out with logger
            logger.info("Hello from the SecurityBusinessService");
            
            // Add some example authentication logic logging
            logger.debug("Performing authentication check for user: {}", username);
            
            // In a real application, you would have actual authentication logic here
            // For this example, we're just returning true
            boolean result = true;
            
            // Log method exit with authentication result
            logger.info("Exiting authenticate() method with result: {}", result);
            
            return result;
        } catch (Exception e) {
            // Log any unexpected errors
            logger.error("Error during authentication for user {}: {}", username, e.getMessage(), e);
            
            // Log method exit with error
            logger.info("Exiting authenticate() method with exception");
            
            throw e; // Re-throw the exception after logging
        }
    }
}
