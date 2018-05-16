package com.troytan.ymcake.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.troytan.ymcake.service.ShopcartService;
import com.troytan.ymcake.vo.ShopcartVo;

@Controller
@Path("/shopcart")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
public class ShopcartController {

    @Autowired
    private ShopcartService shopcartService;

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
    @Path("/{productId}/{sizeId}/{count}")
    public int addToShopcart(@PathParam("productId") Long productId, @PathParam("sizeId") Long sizeId,
                             @PathParam("count") Short count) {
        return shopcartService.createShopcart(productId, sizeId, count);
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
    @Path("/increase/{productId}/{sizeId}")
    public void increaseShopcart(@PathParam("productId") Long productId, @PathParam("sizeId") Long sizeId) {

        shopcartService.increaseShopcart(productId, sizeId);
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
    @Path("/decrease/{productId}/{sizeId}")
    public void decreaseShopcart(@PathParam("productId") Long productId, @PathParam("sizeId") Long sizeId) {

        shopcartService.decreaseShopcart(productId, sizeId);
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
    @Path("/{shopcartId}")
    public List<ShopcartVo> deleteShopcart(@PathParam("shopcartId") Long shopcartId) {
        return shopcartService.deleteShopcart(shopcartId);
    }

    /**
     * 获取当前用户购车车详情
     *
     * @author troytan
     * @date 2018年5月7日
     * @return
     */
    @GET
    @Path("/shopcarts")
    public List<ShopcartVo> getShopcartList() {
        return shopcartService.getShopcartList();
    }

    /**
     * 获取购物车数量
     *
     * @author troytan
     * @date 2018年5月7日
     * @return
     */
    @GET
    @Path("/count")
    public int getShopcartCount() {
        return shopcartService.getShopcartCount();
    }

}
