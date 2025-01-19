package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;


public class OrdersBusinessService implements OrdersBusinessServiceInterface {
    @Autowired
    private OrdersDataService service;
    @Override
    public void test() {
        // TODO Auto-generated method stub
        System.out.println("Hello from the OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders()
    {
        //get all the entity orders
        List<OrderEntity> ordersEntity = service.findAll();
        //iterate over the entity orders and create a list of domain orders
        List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
        for(OrderEntity entity : ordersEntity)
        {
            ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
        }
        //return list of domain orders
        return ordersDomain;
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
