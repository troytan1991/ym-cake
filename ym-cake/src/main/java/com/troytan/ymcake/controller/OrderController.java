package com.troytan.ymcake.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.troytan.ymcake.domain.Comment;
import com.troytan.ymcake.domain.Order;
import com.troytan.ymcake.domain.ProductOrder;
import com.troytan.ymcake.dto.CommentDto;
import com.troytan.ymcake.dto.DeliveryDto;
import com.troytan.ymcake.service.OrderService;

@Controller
@Path("/order")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 新增订单
     *
     * @author troytan
     * @date 2018年5月4日
     * @param productOrders
     * @return
     */
    @PUT
    @Path("/create")
    public Order createOrder(List<ProductOrder> productOrders) {

        return orderService.createOrder(productOrders);
    }

    /**
     * 支付订单
     *
     * @author troytan
     * @date 2018年5月4日
     * @param orderId
     * @return
     */
    @POST
    @Path("/pay/{orderId}")
    public void payOrder(@PathParam("orderId") Long orderId) {
        orderService.payOrder(orderId);
    }

    /**
     * 发货订单
     *
     * @author troytan
     * @date 2018年5月4日
     * @param orderId
     * @return
     */
    @POST
    @Path("/deliver/{orderId}")
    public void deliverOrder(@PathParam("orderId") Long orderId, DeliveryDto deliveryDto) {
        orderService.deliverOrder(orderId, deliveryDto);
    }

}
