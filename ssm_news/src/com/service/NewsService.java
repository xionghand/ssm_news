package com.service;

import com.pojo.News;
import com.pojo.PageShow;
import com.pojo.Query;

import java.util.List;

public interface NewsService {


    /*
    *   删除单行新闻记录
    * */
    public int delNewsById(int[] id);

    /*
    *  添加单行新闻记录
    * */
    public int addNews(News news);

    /*
    *  查询修改id 的数据
    * */
    public News queryById(int id);

    /*
    *  修改
    * */
    public int updateNews(News news);
    /*
    *   统计总数
    * */
    public int totalNews(Query query);

    /*
    *   分页
    * */
    public List<News> queryNewsByPage(PageShow pageShow);


    /*
    *   查询typeId
    * */
    public List queryTypeId();

}
