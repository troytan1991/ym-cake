package com.troytan.ymcake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.ymcake.domain.Shopcart;
import com.troytan.ymcake.repository.ShopcartMapper;
import com.troytan.ymcake.vo.ShopcartVo;

@Service
@Transactional
public class ShopcartServiceImpl implements ShopcartService {

    @Autowired
    private ShopcartMapper shopcartMapper;
    @Autowired
    private UserService    userService;

    @Override
    public int createShopcart(Long productId, Long sizeId, Short count) {
        Long userId = userService.getCurrentUser();

        Shopcart shopcart = shopcartMapper.selectByProductAndUser(productId, sizeId, userId);
        if (shopcart != null) {
            shopcart.setCount((short) (shopcart.getCount() + count));
            shopcart.setUpdatedBy(userId + "");
            shopcartMapper.updateByPrimaryKey(shopcart);
        } else {
            shopcart = new Shopcart();
            shopcart.setCount(count);
            shopcart.setProductId(productId);
            shopcart.setSizeId(sizeId);
            shopcart.setUserId(userId);
            shopcartMapper.insert(shopcart);
        }
        return shopcartMapper.selectCountByUser(userId);
    }

    @Override
    public void increaseShopcart(Long productId, Long sizeId) {
        shopcartMapper.addCountByProduct(productId, sizeId, userService.getCurrentUser());

    }

    @Override
    public void decreaseShopcart(Long productId, Long sizeId) {
        shopcartMapper.subCountByProduct(productId, sizeId, userService.getCurrentUser());

    }

    @Override
    public List<ShopcartVo> deleteShopcart(Long shopcartId) {
        shopcartMapper.deleteByKeyAndUser(shopcartId, userService.getCurrentUser());
        return shopcartMapper.selectByUser(userService.getCurrentUser());
    }

    @Override
    public List<ShopcartVo> getShopcartList() {

        return shopcartMapper.selectByUser(userService.getCurrentUser());
    }

    @Override
    public int getShopcartCount() {
        
        return shopcartMapper.selectCountByUser(userService.getCurrentUser());
    }

}
