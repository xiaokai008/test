package com.cg.mybatis.pojo;

public class ProductQueryVo {
    private Integer category;
    private Integer level;
    private String name;

    public ProductQueryVo(String name) {
        this.name = name;
    }

    public ProductQueryVo(Integer category, Integer level) {
        this.category = category;
        this.level = level;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
