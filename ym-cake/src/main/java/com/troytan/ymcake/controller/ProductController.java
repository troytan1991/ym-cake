package com.troytan.ymcake.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.troytan.ymcake.aspect.NoAuth;
import com.troytan.ymcake.domain.Product;
import com.troytan.ymcake.service.ProductService;
import com.troytan.ymcake.vo.ProductVo;

@Controller
@Path("/product")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 获取所有产品列表
     *
     * @author troytan
     * @date 2018年5月4日
     * @return
     */
    @GET
    @Path("/products")
    @NoAuth
    public List<Product> getProducts() {
        return productService.listProduct();
    }

    /**
     * 获取单个产品详情
     * 
     * @author troytan
     * @date 2018年5月4日
     * @param productId
     * @return
     */
    @GET
    @Path("/{productId}")
    @NoAuth
    public ProductVo getProduct(@PathParam("productId") Long productId) {
        return productService.getProduct(productId);
    }

}
