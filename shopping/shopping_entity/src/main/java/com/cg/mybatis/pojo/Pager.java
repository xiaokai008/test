package com.cg.mybatis.pojo;

public class Pager {
    private Integer pageCount;
    private String url;
    private Integer currentPage;

    public Pager(Integer pageCount, String url, Integer currentPage) {
        this.pageCount = pageCount;
        this.url = url;
        this.currentPage = currentPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
