package com.cg.service.impl;

import com.cg.mybatis.mapper.ProductMapper;
import com.cg.mybatis.pojo.Product;
import com.cg.mybatis.pojo.ProductCategory;
import com.cg.mybatis.pojo.ProductQueryVo;
import com.cg.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource(name = "productMapper")
    private ProductMapper productMapper;
    @Override
    public List<Product> getProductByLevelCategory(Integer level,Integer category,  Integer currentPage, String name) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(category);
        productCategory.setType(level);
          List<Product> products = productMapper.getProductByLevelCategory();
        return products;

    }

    @Override
    public Product queryProductDeatil(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> getProductList(Integer currentPage, Integer pageSize, Integer category, Integer level, String name) {
        ProductQueryVo vo ;
        if (name !=null && name != ""){
            vo = new ProductQueryVo(name);
        }else {
            vo = new ProductQueryVo(category,level);
        }
        PageHelper.startPage(currentPage,pageSize);
        List<Product> productList = productMapper.selectProductList(vo);
        return productList;
    }

    @Override
    public List<Product> getProductList() {
        List<Product> productList = productMapper.getProductList();
        return productList;
    }

}
