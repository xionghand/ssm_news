package com.dao;

import com.pojo.News;
import com.pojo.PageShow;
import com.pojo.Query;

import java.util.List;

public interface NewsDao {
    /*
    *   查询所有
    * */
    public List<News> queryAll();

    /*
    *   删除单行记录：删除单行新闻
    * */
    public int delNewsById(Integer id);

    /*
    *   添加单行新闻记录
    * */
    public int addNews(News news);

    /*
    *   查询要修改的新闻的id 信息
    * */
    public News queryById(Integer id);

    public int updateNews(News news);

    /*
    *   统计新闻记录
    * */
    public int totalNews(Query query);
    /*
    * 分页
    * */
    public List<News> queryNewsByPage(PageShow pageShow);

    /*
    *   通过新闻标题、新闻日期 进行 模糊查询
    *  * */
    public List<News> queryByLike(Query query);

    /*
     *   查询TypeId的类别
     * */
    public List queryTypeId();

}
