package com.cg.vo;

import com.cg.mybatis.pojo.Product;
import com.cg.mybatis.pojo.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryVo {

    ProductCategory productCategory;  //分类的内容
    List<ProductCategoryVo> productCategoryVoList = new ArrayList<>(); //分类的集合
    List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<ProductCategoryVo> getProductCategoryVoList() {
        return productCategoryVoList;
    }

    public void setProductCategoryVoList(List<ProductCategoryVo> productCategoryVoList) {
        this.productCategoryVoList = productCategoryVoList;
    }

    @Override
    public String toString() {
        return "ProductCategoryVo{" +
                "productCategory=" + productCategory +
                ", productCategoryVoList=" + productCategoryVoList +
                '}';
    }
}
