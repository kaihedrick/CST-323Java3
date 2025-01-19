package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;

@Configuration
public class SpringConfig {
    //bean annotation definitions
    @Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
    public OrdersBusinessServiceInterface getOrdersBusinessService()
    {
        return new OrdersBusinessService();
    }
}
