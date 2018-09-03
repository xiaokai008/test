package com.cg.mybatis.mapper;

import com.cg.mybatis.pojo.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    /**
     * 查询id和title
     * @return
     */
    List<News> getAllNews();

    List<News> getAllNewsList();
}