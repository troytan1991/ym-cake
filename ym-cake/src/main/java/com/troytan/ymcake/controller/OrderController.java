package com.troytan.ymcake.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Controller;

import com.sgm.ymcake.domain.ProductOrder;

@Controller
@Path("/order")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
public class OrderController {

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
    public boolean createOrder(List<ProductOrder> productOrders) {

        return true;
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
    public boolean payOrder(@PathParam("orderId") Long orderId) {
        return true;
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
    public boolean deliverOrder(@PathParam("orderId") Long orderId) {
        return true;
    }

    /**
     * 评价订单
     *
     * @author troytan
     * @date 2018年5月4日
     * @param orderId
     * @return
     */
    @PUT
    @Path("/comment/{orderId}")
    public boolean commentOrder(@PathParam("orderId") Long orderId) {

        return true;
    }
}
