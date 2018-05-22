package com.troytan.ymcake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.ymcake.domain.Addr;
import com.troytan.ymcake.dto.AreaDto;
import com.troytan.ymcake.repository.AddrMapper;
import com.troytan.ymcake.repository.AreaMapper;

@Service
@Transactional
public class AddrServiceImpl implements AddrService {

    @Autowired
    private AddrMapper  addrMapper;
    @Autowired
    private AreaMapper  areaMapper;
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

    @Override
    public void setDefault(Long addrId) {
        // 清除默认
        addrMapper.updateUndefault();
        // 重新添加默认
        addrMapper.updateDefaultById(addrId);
    }

    @Override
    public Addr getDefaultAddr() {

        return addrMapper.selectDefaultByUserId(userService.getCurrentUser());
    }

    @Override
    public List<AreaDto> getAreaList() {
        return areaMapper.listAreaDto();
    }

}
