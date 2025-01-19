package com.gcu.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="orders")
public class OrdersList {
    private List<OrderModel> orders;
    @XmlElement(name="order")
    public List<OrderModel> getOrders()
    {
        return this.orders;
    }
    public void setOrders(List<OrderModel> orders)
    {
        this.orders = orders;
    }
}
