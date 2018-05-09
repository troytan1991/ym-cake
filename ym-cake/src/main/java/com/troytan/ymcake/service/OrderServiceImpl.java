package com.troytan.ymcake.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.ymcake.domain.Delivery;
import com.troytan.ymcake.domain.DomainConst;
import com.troytan.ymcake.domain.Order;
import com.troytan.ymcake.domain.Product;
import com.troytan.ymcake.domain.ProductOrder;
import com.troytan.ymcake.dto.DeliveryDto;
import com.troytan.ymcake.dto.OrderDto;
import com.troytan.ymcake.repository.DeliveryMapper;
import com.troytan.ymcake.repository.OrderMapper;
import com.troytan.ymcake.repository.ProductMapper;
import com.troytan.ymcake.repository.ProductOrderMapper;
import com.troytan.ymcake.repository.ShopcartMapper;
import com.troytan.ymcake.vo.OrderVo;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper        orderMapper;
    @Autowired
    private ProductOrderMapper productOrderMapper;
    @Autowired
    private ProductMapper      productMapper;
    @Autowired
    private UserService        userService;
    @Autowired
    private ShopcartMapper     shopcartMapper;
    @Autowired
    private DeliveryMapper     deliveryMapper;

    /**
     * 创建订单
     *
     * @author troytan
     * @date 2018年5月5日
     * @param productOrders
     * @return (non-Javadoc)
     * @see com.troytan.ymcake.service.OrderService#createOrder(java.util.List)
     */
    @Override
    public Order createOrder(OrderDto orderDto) {
        // 新增tt_delivery记录
        Delivery delivery = new Delivery();
        delivery.setAddrId(orderDto.getAddrId());
        delivery.setReceiveTime(orderDto.getReceiveTime());
        delivery.setType(orderDto.getType());
        deliveryMapper.insert(delivery);

        // 新增tt_order记录
        List<ProductOrder> productOrders = orderDto.getProductList();
        Order order = new Order();
        order.setDeliveryId(delivery.getDeliveryId());
        order.setPrice(countPrice(productOrders));
        order.setDeliveryFee(new BigDecimal(order.getPrice().intValue() > 200 ? 0 : 10));
        order.setStatus(DomainConst.STATUS_NEW);
        order.setCreatedBy("admin");
        order.setUserId(userService.getCurrentUser());

        orderMapper.insert(order);

        for (ProductOrder productOrder : productOrders) {
            productOrder.setOrderId(order.getOrderId());
            // 扣减购物车
            shopcartMapper.updateCountByOrder(productOrder, userService.getCurrentUser());
        }
        // 新增tr_product_order关联记录
        productOrderMapper.insertBatch(productOrders);

        return order;
    }

    /**
     * 支付订单
     *
     * @author troytan
     * @date 2018年5月5日
     * @param orderId (non-Javadoc)
     * @see com.troytan.ymcake.service.OrderService#payOrder(java.lang.Long)
     */
    @Override
    public void payOrder(Long orderId) {
        orderMapper.updateStatusById(orderId, DomainConst.STATUS_PAY);
    }

    /**
     * 发货订单
     *
     * @author troytan
     * @date 2018年5月5日
     * @param orderId
     * @param deliveryDto (non-Javadoc)
     * @see com.troytan.ymcake.service.OrderService#deliverOrder(java.lang.Long, com.troytan.ymcake.dto.DeliveryDto)
     */
    @Override
    public void deliverOrder(Long orderId, DeliveryDto deliveryDto) {

        deliveryMapper.updateByOrderId(orderId, deliveryDto);
        orderMapper.updateStatusById(orderId, DomainConst.STATUS_DELIVER);
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

    @Override
    public List<OrderVo> getOrderList(Short status) {
        return orderMapper.selectByStatus(status,userService.getCurrentUser());
    }

}
