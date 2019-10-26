package com.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Scope("prototype")
public class PageShow {
    private int totalCount; // 总数据
    private int curPage;    // 当前页
    private int pageSize=4;   // 页面大小
    private int pageNum;    // 总页数
    private Query query;

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public PageShow() {
    }

    public PageShow(int totalCount, int curPage, int pageSize, List<News> newsList, int pageNum) {
        this.totalCount = totalCount;
        this.curPage = curPage;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.pageNum = this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:(this.totalCount/this.pageSize)+1;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }


    @Override
    public String toString() {
        return "Page{" +
                "totalCount=" + totalCount +
                ", curPage=" + curPage +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", query=" + query +
                '}';
    }
}
