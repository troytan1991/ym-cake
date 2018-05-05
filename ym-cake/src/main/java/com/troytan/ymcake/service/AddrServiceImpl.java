package com.troytan.ymcake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.troytan.ymcake.domain.Addr;
import com.troytan.ymcake.repository.AddrMapper;

public class AddrServiceImpl implements AddrService {

    @Autowired
    private AddrMapper  addrMapper;
    @Autowired
    private UserService userService;

    @Override
    public List<Addr> deleteAddr(Long addrId) {
        addrMapper.deleteByPrimaryKey(addrId);
        return addrMapper.selectByUserId(userService.getCurrentUser());
    }

    @Override
    public List<Addr> getAddrList() {

        return addrMapper.selectByUserId(userService.getCurrentUser());
    }

    @Override
    public Addr createAddr(Addr addr) {
        addr.setUserId(userService.getCurrentUser());
        addrMapper.insert(addr);
        return addr;
    }

    @Override
    public Addr updateAddr(Addr addr) {
        addr.setUserId(userService.getCurrentUser());
        addrMapper.updateByPrimaryKey(addr);
        return addr;
    }

}
