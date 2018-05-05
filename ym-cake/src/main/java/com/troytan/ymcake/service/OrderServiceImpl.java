package com.troytan.ymcake.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.troytan.ymcake.domain.Order;
import com.troytan.ymcake.domain.Product;
import com.troytan.ymcake.domain.ProductOrder;
import com.troytan.ymcake.repository.OrderMapper;
import com.troytan.ymcake.repository.ProductMapper;
import com.troytan.ymcake.repository.ProductOrderMapper;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper        orderMapper;
    @Autowired
    private ProductOrderMapper ProductOrderMapper;
    @Autowired
    private ProductMapper      productMapper;

    @Override
    public Order createOrder(List<ProductOrder> productOrders) {

        Order order = new Order();
        order.setPrice(countPrice(productOrders));

        return null;
    }

    private BigDecimal countPrice(List<ProductOrder> productOrders) {
        productOrders.stream().map(item ->{
            Product product = productMapper.selectByPrimaryKey(item.getProductId());
            
        })
        
        return null;
    }

}
