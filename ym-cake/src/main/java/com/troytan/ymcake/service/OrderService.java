package com.troytan.ymcake.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.troytan.ymcake.domain.Order;
import com.troytan.ymcake.domain.ProductOrder;
import com.troytan.ymcake.dto.DeliveryDto;

@Service
public interface OrderService {

    Order createOrder(List<ProductOrder> productOrders);

    void payOrder(Long orderId);

    void deliverOrder(Long orderId, DeliveryDto deliveryDto);
}
