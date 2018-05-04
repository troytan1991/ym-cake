package com.troytan.ymcake.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Controller;

@Controller
@Path("/shopcart")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
public class ShopcartController {

    /**
     * 添加到购物车
     *
     * @author troytan
     * @date 2018年5月4日
     * @param productId
     * @param count
     * @return
     */
    @PUT
    @Path("/{productId}/{count}")
    public boolean addToShopcart(@PathParam("productId") Long productId, @PathParam("count") Short count) {

        return true;
    }

    /**
     * 增加商品数量
     *
     * @author troytan
     * @date 2018年5月4日
     * @param productId
     * @return
     */
    @POST
    @Path("/increase/{productId}")
    public boolean increaseShopcart(@PathParam("productId") Long productId) {

        return true;
    }

    /**
     * 减少商品数量
     *
     * @author troytan
     * @date 2018年5月4日
     * @param productId
     * @return
     */
    @POST
    @Path("/decrease/{productId}")
    public boolean decreaseShopcart(@PathParam("productId") Long productId) {

        return true;
    }

    /**
     * 删除商品
     *
     * @author troytan
     * @date 2018年5月4日
     * @param productId
     * @return
     */
    @DELETE
    @Path("/{productId}")
    public boolean deleteShopcart(@PathParam("productId") Long productId) {

        return true;
    }
    
}
