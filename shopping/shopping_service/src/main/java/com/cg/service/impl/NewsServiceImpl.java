package com.cg.service.impl;

import com.cg.mybatis.mapper.NewsMapper;
import com.cg.mybatis.pojo.News;
import com.cg.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Resource(name = "newsMapper")
    private NewsMapper newsMapper;
    @Override
    public List<News> getAllNews() {
       List<News> news = newsMapper.getAllNewsList();
        return news;
    }

    @Override
    public News getNewsById(Integer id) {
        News news = newsMapper.selectByPrimaryKey(id);
        return news;
    }
}
