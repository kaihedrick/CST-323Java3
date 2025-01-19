package com.gcu.business;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrdersList;
import com.gcu.model.OrderModel;

@RestController
@RequestMapping("/service")
public class OrdersRestService {
    private final OrdersBusinessServiceInterface orders;
    public OrdersRestService(OrdersBusinessServiceInterface orders) {
        this.orders = orders;
    }
    
    @GetMapping(path="/getjson", produces={MediaType.APPLICATION_JSON_VALUE})
    public List<OrderModel> getOrdersAsJson()
    {
        return orders.getOrders();
    }
    @GetMapping(path="/getxml", produces={MediaType.APPLICATION_XML_VALUE})
    public OrdersList getOrdersAsXml()
    {
        OrdersList list = new OrdersList();
        list.setOrders(orders.getOrders());
        return list;
    }
}
