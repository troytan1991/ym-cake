package com.troytan.ymcake.service;

import java.util.List;

import com.troytan.ymcake.domain.Order;
import com.troytan.ymcake.domain.ProductOrder;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrder(List<ProductOrder> productOrders) {
        
        Order order = new Order();
        order.setPrice(countPrice(productOrders));
        
        return null;
    }

    private Float countPrice(List<ProductOrder> productOrders) {
        // TODO Auto-generated method stub
        return null;
    }

}
