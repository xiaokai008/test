package com.cg.controller;

import com.cg.mybatis.pojo.News;
import com.cg.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class NewsController {

    @Resource(name = "newsService")
    private NewsService newsService;

    @RequestMapping("sys/queryNewsList")
    public String queryNewsList(Model model){
        List<News> newsList = newsService.getAllNews();
        model.addAttribute("newsList",newsList);
        return "/jsp/backend/news/newsList.jsp";
    }
    @RequestMapping("sys/queryNewsDeatil")
    public String queryNewsDeatil(Integer id,Model model){
         News news = newsService.getNewsById(id);
        model.addAttribute("news",news);
        return "/jsp/backend/news/newsList.jsp";
    }

}
