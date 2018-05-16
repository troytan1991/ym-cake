package com.troytan.ymcake.service;

import java.util.List;

import com.troytan.ymcake.vo.ShopcartVo;

public interface ShopcartService {

    int createShopcart(Long productId, Long sizeId, Short count);

    void increaseShopcart(Long productId, Long sizeId);

    void decreaseShopcart(Long productId, Long sizeId);

    List<ShopcartVo> deleteShopcart(Long shopcartId);

    List<ShopcartVo> getShopcartList();

    int getShopcartCount();

}
