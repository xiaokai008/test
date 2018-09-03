package com.cg.service;

import com.cg.vo.ProductCategoryVo;

import java.util.List;

public interface ProductCategoryService {

    /**
     * 三级分列
     * @return
     */
    List<ProductCategoryVo> getAllProductCategories();
}
