package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/getProductCategoryList")
    public String getProductCategoryList(Integer userId){
        return "/jsp/backend/product/productList.jsp";
    }
}
