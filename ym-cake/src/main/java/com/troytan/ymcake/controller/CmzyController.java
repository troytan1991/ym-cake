package com.troytan.ymcake.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.Page;
import com.troytan.ymcake.aspect.NoAuth;
import com.troytan.ymcake.domain.Customer;
import com.troytan.ymcake.domain.News;
import com.troytan.ymcake.domain.Worker;
import com.troytan.ymcake.dto.CustomerDto;
import com.troytan.ymcake.dto.DesignerDto;
import com.troytan.ymcake.dto.FitmentDto;
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
    public List<News> searchNews(@QueryParam("searchStr") String searchStr,
                                 @DefaultValue("1") @QueryParam("pageNum") Integer pageNum,
                                 @DefaultValue("10") @QueryParam("pageSize") Integer pageSize) {
        Page<?> page = new Page<>(pageNum, pageSize);
        return cmzyService.searchNews(searchStr, page);
    }
    
    @GET
    @Path("/designer")
    @NoAuth
    public List<DesignerDto> getDesigners(){
    	return cmzyService.getDesigners(); 	
    }
    
    @GET
    @Path("/worker")
    @NoAuth
    public List<Worker> getWorkers(){
    	return cmzyService.getWorkers();
    }
    
    @GET
    @Path("/fitment")
    @NoAuth
    public List<FitmentDto> getFitments(){
    	return cmzyService.getFitments();
    }
    
    
    @PUT
    @Path("/customer")
    @NoAuth
    public Customer createCustomers(CustomerDto customerDto){
    	return cmzyService.createCustomers(customerDto);
    }
    
}
