package com.troytan.ymcake.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.troytan.ymcake.domain.Order;
import com.troytan.ymcake.domain.ProductOrder;

@Service
public interface OrderService {

    Order createOrder(List<ProductOrder> productOrders);
}
