package com.cg.controller;

import com.cg.mybatis.pojo.*;
import com.cg.service.NewsService;
import com.cg.service.ProductCategoryService;
import com.cg.service.ProductService;
import com.cg.vo.ProductCategoryVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {

    @Resource(name = "productCategoryService")
    private ProductCategoryService productCategoryService ;

    @Resource(name = "productService")
    private ProductService productService;

    @Resource(name = "newsService")
    private NewsService newsService;
//    主界面显示
    @RequestMapping("index")
    public String index(Model model){
        List<ProductCategoryVo> productCategoryVoList = productCategoryService.getAllProductCategories();
        List<Product> productList = productService.getProductList();
        productCategoryVoList.get(0).getProductList().addAll(productList);
        System.out.println(productCategoryVoList);

        model.addAttribute("productCategoryVoList",productCategoryVoList);

       List<News> news = newsService.getAllNews();
       model.addAttribute("news",news);
        return "/jsp/pre/index.jsp";
    }
//    商品列表 模糊查询
    @RequestMapping(value = "queryProductList" ,method = RequestMethod.GET)
    public String queryProductList(Integer category,Integer level,Integer currentPage,String name,Model model){
        if (currentPage == null){
            currentPage =1 ;
        }
       List<Product> productList = productService.getProductList(currentPage, StaticVar.PRODUCT_PAGE_SIZE,category, level, name);
       System.out.println(productList);
       PageInfo<Product>pageInfo = new PageInfo<>(productList);
       model.addAttribute("total",pageInfo.getTotal());
       String url = "/queryProductList.action?1=1";
       Pager pager = new Pager(pageInfo.getPages(),url,currentPage);
       model.addAttribute("pager",pager);
       model.addAttribute("productList",productList);
      return "/jsp/pre/product/queryProductList.jsp";
    }

//    商品详情
    @RequestMapping(value = "queryProductDeatil",method = RequestMethod.GET)
    public String queryProductDeatil(Integer id ,Model model){
       Product product = productService.queryProductDeatil(id);
        model.addAttribute("product",product);
        return "/jsp/pre/product/productDeatil.jsp";

    }

}