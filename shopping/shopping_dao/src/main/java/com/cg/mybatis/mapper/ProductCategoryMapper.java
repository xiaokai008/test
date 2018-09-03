package com.cg.mybatis.mapper;

import com.cg.mybatis.pojo.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);

    /**
     * 根据parId查询下属类别
     * @param parId
     * @return
     */
    List<ProductCategory> selectByParentId(int parId);
}