package com.troytan.ymcake.service;

import java.util.List;

import com.troytan.ymcake.domain.Shopcart;

public interface ShopcartService {

    int createShopcart(Long productId, Long sizeId, Short count);

    void increaseShopcart(Long productId, Long sizeId);

    void decreaseShopcart(Long productId, Long sizeId);

    void deleteShopcart(Long productId, Long sizeId);

    List<Shopcart> getShopcartList();

    int getShopcartCount();

}
