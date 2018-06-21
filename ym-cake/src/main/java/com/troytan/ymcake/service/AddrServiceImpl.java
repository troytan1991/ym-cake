package com.troytan.ymcake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.ymcake.domain.Addr;
import com.troytan.ymcake.dto.AreaDto;
import com.troytan.ymcake.repository.AddrMapper;
import com.troytan.ymcake.repository.AreaMapper;
import com.troytan.ymcake.util.MosaicUtils;

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
        List<Addr> addrs = addrMapper.selectByUserId(userService.getCurrentUser());
        // 模糊处理
        for (Addr addr : addrs) {
            addr.setPhone(MosaicUtils.phoneMosaic(addr.getPhone()));
        }
        return addrs;
    }

    @Override
    public Addr createAddr(Addr addr) {
        addr.setUserId(userService.getCurrentUser());
        addrMapper.insert(addr);
        if (addr.getIsDefault()) {
            addrMapper.updateDefaultById(addr.getAddrId());
        }
        return addr;
    }

    @Override
    public Addr updateAddr(Addr addr) {
        addr.setUserId(userService.getCurrentUser());
        addrMapper.updateByPrimaryKey(addr);
        if (addr.getIsDefault()) {
            addrMapper.updateDefaultById(addr.getAddrId());
        }
        return addr;
    }

    @Override
    public Addr getDefaultAddr() {
        Addr addr = addrMapper.selectDefaultByUserId(userService.getCurrentUser());
        // 脱敏处理
        addr.setPhone(MosaicUtils.phoneMosaic(addr.getPhone()));
        return addr;
    }

    @Override
    public List<AreaDto> getAreaList() {
        return areaMapper.listAreaDto();
    }

}
