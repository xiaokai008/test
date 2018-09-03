package com.cg.service;

import com.cg.mybatis.pojo.Product;

import java.util.List;

public interface ProductService {


    List<Product> getProductByLevelCategory(Integer level, Integer category, Integer currentPage, String name);

    Product queryProductDeatil(Integer id);

    /**
     * 分页查询商品列
     * @param currentPage  第几页
     * @param productPageSize 一页显示多少条
     * @param category 分类的id
     * @param level 级别（一级标题和二级标题）
     * @param name  模糊查询
     * @return
     */
    List<Product> getProductList(Integer currentPage, Integer productPageSize, Integer category, Integer level, String name);

    List<Product> getProductList();

}
