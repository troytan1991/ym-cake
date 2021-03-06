package com.troytan.ymcake.service;

import java.util.List;

import com.troytan.ymcake.domain.Addr;
import com.troytan.ymcake.dto.AreaDto;

public interface AddrService {

    List<Addr> deleteAddr(Long addrId);

    List<Addr> getAddrList();

    Addr createAddr(Addr addr);

    Addr updateAddr(Addr addr);

    Addr getDefaultAddr();

    List<AreaDto> getAreaList();

}
