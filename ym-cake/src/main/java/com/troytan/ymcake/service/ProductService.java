package com.troytan.ymcake.service;

import java.util.List;

import com.troytan.ymcake.domain.Product;
import com.troytan.ymcake.vo.ProductVo;

public interface ProductService {

    List<Product> listProduct();

    ProductVo getProduct(Long productId);
}
