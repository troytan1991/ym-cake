package com.troytan.ymcake.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.Page;
import com.troytan.ymcake.aspect.NoAuth;
import com.troytan.ymcake.domain.News;
import com.troytan.ymcake.service.CmzyService;

@Controller
@Path("/cmzy")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
@NoAuth
public class CmzyController {

    @Autowired
    private CmzyService cmzyService;

    @GET
    @Path("/news")
    public List<News> SearchNews(@QueryParam("searchStr") String searchStr,
                                 @DefaultValue("1") @QueryParam("pageNum") Integer pageNum,
                                 @DefaultValue("10") @QueryParam("pageSize") Integer pageSize) {
        Page<?> page = new Page<>(pageNum, pageSize);
        return cmzyService.searchNews(searchStr, page);
    }
}
