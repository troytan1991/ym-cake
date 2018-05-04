package com.troytan.ymcake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgm.ymcake.domain.Product;
import com.sgm.ymcake.repository.ProductMapper;
import com.troytan.ymcake.vo.ProductVo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> listProduct() {
        return productMapper.selectAll();
    }

    @Override
    public ProductVo getProduct(Long productId) {
        return productMapper.selectVoByPrimaryKey(productId);
    }
}
