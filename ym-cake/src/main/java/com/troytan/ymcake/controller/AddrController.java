package com.troytan.ymcake.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Controller;

import com.sgm.ymcake.domain.Addr;

@Controller
@Path("/addr")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
public class AddrController {
    


    /**
     * 查询当前用户收货地址
     *
     * @author troytan
     * @date 2018年5月4日
     * @return
     */
    @GET
    @Path("/addrs")
    public List<Addr> getAddrs() {

        return null;
    }

    /**
     * 创建地址
     *
     * @author troytan
     * @date 2018年5月4日
     * @param addr
     * @return
     */
    @PUT
    public Addr createAddr(Addr addr) {

        return null;
    }

    /**
     * 更新地址
     *
     * @author troytan
     * @date 2018年5月4日
     * @param addr
     * @return
     */
    @POST
    public Addr updateAddr(Addr addr) {

        return null;
    }

    /**
     * 删除地址
     *
     * @author troytan
     * @date 2018年5月4日
     * @param addrId
     * @return
     */
    @DELETE
    @Path("/{addrId}")
    public List<Addr> deleteAddr(@PathParam("addrId") Long addrId) {

        return null;
    }
}
