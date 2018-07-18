/*package com.troytan.ymcake.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.troytan.ymcake.dto.FitmentDto;
import com.troytan.ymcake.service.FitmentService;

@Controller
@Path("/fitment")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
public class FitmentController {

	@Autowired
	private FitmentService fitmentService;

	@GET
	@Path("/fitments/{type}")
	public List<FitmentDto> getFitments(@PathParam("type") Short type) {
		return fitmentService.listFitments(type);
	}
}
*/