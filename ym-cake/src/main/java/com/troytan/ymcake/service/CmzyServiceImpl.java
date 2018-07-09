package com.troytan.ymcake.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.troytan.ymcake.domain.Customer;
import com.troytan.ymcake.domain.Delivery;
import com.troytan.ymcake.domain.News;
import com.troytan.ymcake.domain.Worker;
import com.troytan.ymcake.dto.CustomerDto;
import com.troytan.ymcake.dto.DesignerDto;
import com.troytan.ymcake.dto.FitmentDto;
import com.troytan.ymcake.repository.CustomerMapper;
import com.troytan.ymcake.repository.DesignerMapper;
import com.troytan.ymcake.repository.FitmentMapper;
import com.troytan.ymcake.repository.NewsMapper;
import com.troytan.ymcake.repository.WorkerMapper;
import com.troytan.ymcake.vo.OrderVo;

@Service
public class CmzyServiceImpl implements CmzyService {

	@Autowired
	private NewsMapper newsMapper;
	
	@Autowired
	private DesignerMapper designerMapper;
	
	@Autowired
	private WorkerMapper workerMapper;
	
	@Autowired
	private FitmentMapper fitmentMapper;
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<News> searchNews(String searchStr, Page<?> page) {
		return newsMapper.listByTitle(searchStr, page);
	}

	@Override
	public List<DesignerDto> getDesigners() {
		List<DesignerDto> list = designerMapper.listByWork();
		return list;
	}
	
	@Override
	public List<Worker> getWorkers() {
		return workerMapper.selectAll();
	}
	
	@Override
	public List<FitmentDto> getFitments() {
		List<FitmentDto> list = fitmentMapper.listByDetail();
		return list;
	}
	
	@Override
	public Customer createCustomers(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDto.getCustomerId());
		customer.setName(customerDto.getName());
        customer.setPhone(customerDto.getPhone());
		customer.setArea(customerDto.getArea());
		customer.setLevel(customerDto.getLevel());
		customerMapper.insert(customer);
		return customer;		
	}

}
