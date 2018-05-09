package com.troytan.ymcake.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.troytan.ymcake.domain.Order;
import com.troytan.ymcake.dto.DeliveryDto;
import com.troytan.ymcake.dto.OrderDto;
import com.troytan.ymcake.vo.OrderVo;

@Service
public interface OrderService {

    Order createOrder(OrderDto orderDto);

    void payOrder(Long orderId);

    void deliverOrder(Long orderId, DeliveryDto deliveryDto);

    List<OrderVo> getOrderList(Short status);
}
