package com.cg.service;

import com.cg.mybatis.pojo.News;

import java.util.List;

public interface NewsService {
    List<News> getAllNews();

    News getNewsById(Integer id);
}
