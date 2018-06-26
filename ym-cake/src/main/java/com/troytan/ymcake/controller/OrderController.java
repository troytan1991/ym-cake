package com.troytan.ymcake.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.Page;
import com.troytan.ymcake.domain.Order;
import com.troytan.ymcake.dto.DeliveryDto;
import com.troytan.ymcake.dto.OrderDto;
import com.troytan.ymcake.service.OrderService;
import com.troytan.ymcake.vo.DeliveryVo;
import com.troytan.ymcake.vo.OrderCountVo;
import com.troytan.ymcake.vo.OrderVo;

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
    public Order createOrder(OrderDto orderDto) {

        return orderService.createOrder(orderDto);
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

    /**
     * 根据状体获取订单,-1表示全部
     *
     * @author troytan
     * @date 2018年5月8日
     * @param status
     * @return
     */
    @GET
    @Path("/{status}")
    public List<OrderVo> getOrders(@PathParam("status") Short status,
                                   @DefaultValue("1") @QueryParam("pageNum") Integer pageNum,
                                   @DefaultValue("10") @QueryParam("pageSize") Integer pageSize) {
        return orderService.getOrderList(status, new Page<>(pageNum, pageSize));
    }

    @GET
    @Path("/admin/{status}")
    public List<OrderVo> getAdminOrders(@PathParam("status") Short status,
                                        @DefaultValue("1") @QueryParam("pageNum") Integer pageNum,
                                        @DefaultValue("10") @QueryParam("pageSize") Integer pageSize) {
        return orderService.getAdminOrders(status, new Page<>(pageNum, pageSize));
    }

    /**
     * 获取订单各状态数量信息
     *
     * @author troytan
     * @date 2018年5月14日
     * @return
     */
    @GET
    @Path("/count")
    public OrderCountVo countOrder() {
        return orderService.countOrder();
    }

    /**
     * 催单
     *
     * @author troytan
     * @date 2018年5月14日
     * @param orderId
     */
    @POST
    @Path("/remind/{orderId}")
    public void remindOrder(@PathParam("orderId") Long orderId) {

    }

    /**
     * 取消订单
     *
     * @author troytan
     * @date 2018年5月14日
     * @param orderId
     */
    @POST
    @Path("/cancel/{orderId}")
    public void cancelOrder(@PathParam("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
    }

    /**
     * 获取物流信息
     *
     * @author troytan
     * @date 2018年5月14日
     * @param orderId
     */
    @GET
    @Path("/delivery/{deliveryId}")
    public List<DeliveryVo> getDeliverys(@PathParam("orderId") String deliveryId) {
        return null;
    }

    /**
     * 收货
     *
     * @author troytan
     * @date 2018年5月14日
     * @param orderId
     */
    @POST
    @Path("/receive/{orderId}")
    public void receiveOrder(@PathParam("orderId") Long orderId) {
        orderService.receiveOrder(orderId);
    }

    /**
     * 删除
     *
     * @author troytan
     * @date 2018年5月14日
     * @param orderId
     */
    @DELETE
    @Path("/{orderId}")
    public void deleteOrder(@PathParam("orderId") Long orderId) {
        orderService.deleteOrder(orderId);
    }

}
