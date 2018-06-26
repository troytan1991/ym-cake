package com.troytan.ymcake.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.troytan.ymcake.domain.News;

public interface CmzyService {

    List<News> searchNews(String searchStr, Page<?> page);
}
