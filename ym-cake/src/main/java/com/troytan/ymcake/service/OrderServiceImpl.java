package com.troytan.ymcake.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.ymcake.domain.DomainConst;
import com.troytan.ymcake.domain.Order;
import com.troytan.ymcake.domain.Product;
import com.troytan.ymcake.domain.ProductOrder;
import com.troytan.ymcake.repository.OrderMapper;
import com.troytan.ymcake.repository.ProductMapper;
import com.troytan.ymcake.repository.ProductOrderMapper;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper        orderMapper;
    @Autowired
    private ProductOrderMapper productOrderMapper;
    @Autowired
    private ProductMapper      productMapper;

    @Override
    @Transactional
    public Order createOrder(List<ProductOrder> productOrders) {

        Order order = new Order();
        order.setPrice(countPrice(productOrders));
        order.setDeliveryFee(new BigDecimal(order.getPrice().intValue() > 200 ? 0 : 10));
        order.setStatus(DomainConst.STATUS_NEW);
        order.setCreatedBy("admin");

        orderMapper.insert(order);

        for (ProductOrder productOrder : productOrders) {
            productOrder.setOrderId(order.getOrderId());
        }
        productOrderMapper.insertBatch(productOrders);
        // 清除购物车
        
        return order;
    }

    @Override
    public boolean payOrder(Long orderId) {
        orderMapper.updateStatusById(orderId, DomainConst.STATUS_PAY);
        return true;
    }

    /**
     * 计算总价格
     *
     * @author troytan
     * @date 2018年5月5日
     * @param productOrders
     * @return
     */
    private BigDecimal countPrice(List<ProductOrder> productOrders) {
        double result = productOrders.parallelStream().mapToDouble(item -> {
            Product product = productMapper.selectByPrimaryKey(item.getProductId());
            return product.getPrice().doubleValue() * item.getCount();
        }).sum();

        return new BigDecimal(result);
    }

}
