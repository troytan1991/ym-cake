package com.troytan.ymcake.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.troytan.ymcake.domain.Customer;
import com.troytan.ymcake.domain.News;
import com.troytan.ymcake.domain.Worker;
import com.troytan.ymcake.dto.CustomerDto;
import com.troytan.ymcake.dto.DesignerDto;
import com.troytan.ymcake.dto.FitmentDto;

public interface CmzyService {

    List<News> searchNews(String searchStr, Page<?> page);

	List<DesignerDto> getDesigners();

	List<Worker> getWorkers();

	List<FitmentDto> getFitments();

	Customer createCustomers(CustomerDto customerDto);

	News getNews(String mediaId);
	
}
