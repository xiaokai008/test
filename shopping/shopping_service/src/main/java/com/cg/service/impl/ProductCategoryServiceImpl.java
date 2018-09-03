package com.cg.service.impl;

import com.cg.mybatis.mapper.ProductCategoryMapper;
import com.cg.mybatis.pojo.ProductCategory;
import com.cg.service.ProductCategoryService;
import com.cg.vo.ProductCategoryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource(name = "productCategoryMapper")
    private ProductCategoryMapper productCategoryMapper;
    /**
     * 三级分类
     * @return
     */
    @Override
    public List<ProductCategoryVo> getAllProductCategories() {

        List<ProductCategory> productCategories1 = productCategoryMapper.selectByParentId(0);//查询一级列

        List<ProductCategoryVo> productCategoryVoList = new ArrayList<ProductCategoryVo>();//创建一个productCategoryVo集合用来存放三级分类

        for (ProductCategory p1: productCategories1) {
            ProductCategoryVo vo1 = new ProductCategoryVo(); //新建一个
            vo1.setProductCategory(p1); //一级分类名字封装

            //二级分类
            List<ProductCategory> productCategories2 =  productCategoryMapper.selectByParentId(p1.getId());//根据一级分类中属性id查询二级分类
            for (ProductCategory p2:productCategories2) {
                ProductCategoryVo vo2 = new ProductCategoryVo();
                vo2.setProductCategory(p2); //封装基本信息

                //三级分类
                List<ProductCategory> productCategories3 = productCategoryMapper.selectByParentId(p2.getId());
                for (ProductCategory p3:productCategories3) {
                    ProductCategoryVo vo3 = new ProductCategoryVo();
                    vo3.setProductCategory(p3);
                    vo2.getProductCategoryVoList().add(vo3);//将三级分类的对象封装到二级分类的集合中
                }
                 vo1.getProductCategoryVoList().add(vo2);//将二级分类的多个对象封装到一级分类的集合中
            }
            productCategoryVoList.add(vo1);//将分类对象放到集合中返回

        }

        return productCategoryVoList;
    }
}
