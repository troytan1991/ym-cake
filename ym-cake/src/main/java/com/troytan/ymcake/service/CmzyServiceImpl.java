package com.troytan.ymcake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.troytan.ymcake.domain.News;
import com.troytan.ymcake.repository.NewsMapper;

@Service
public class CmzyServiceImpl implements CmzyService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> searchNews(String searchStr, Page<?> page) {
        return newsMapper.listByTitle(searchStr, page);
    }

}
