package com.cg.mybatis.mapper;

import com.cg.mybatis.pojo.Product;
import com.cg.mybatis.pojo.ProductQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> getProductByLevelCategory();

    /**
     * 查询商品列表（模糊查询和和商品分类）
     * @param vo
     * @return
     */
    List<Product> selectProductList(ProductQueryVo vo);

    /**
     * 查询商品列表
     * @return
     */
    List<Product> getProductList();
}