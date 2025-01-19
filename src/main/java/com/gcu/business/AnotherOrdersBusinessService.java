package com.gcu.business;

import java.util.List;

import com.gcu.model.OrderModel;

public class AnotherOrdersBusinessService implements OrdersBusinessServiceInterface {

    @Override
    public void test() {
        System.out.println("Hello from the AnotherOrdersBusinessService");
    }
    //public List<OrderModel> getOrders();

    @Override
    public List<OrderModel> getOrders() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrders'");
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        System.out.println("this is the init method");
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("This is the destroy method");
    }
}
