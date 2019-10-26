package com.service.impl;

import com.dao.NewsDao;
import com.pojo.News;
import com.pojo.PageShow;
import com.pojo.Query;
import com.service.NewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao ;


    @Override
    public int delNewsById(int[] id) {

        int index = 0;
        if(id.length>0) {
            for (int ids : id) {
                newsDao.delNewsById(ids);
                index++;
            }
        }
        return index;
    }

    @Override
    public int addNews(News news) {

        int index = 0;
        if (news!=null){
            index = newsDao.addNews(news);
        }

        return index;
    }

    @Override
    public News queryById(int id) {
        News news = new News();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(id>0){
             news = newsDao.queryById(new Integer(id));
        }

        return news;
    }

    @Override
    public int updateNews(News news) {

        int index = 0;
        if(news!=null){
          index = newsDao.updateNews(news);
        }

        return index;
    }

    @Override
    public List queryTypeId() {

        List<News> newsList = newsDao.queryTypeId();
        return newsList;
    }

    @Override
    public int totalNews(Query query) {

        int total =newsDao.totalNews(query);

        return total;
    }

    @Override
    public List<News> queryNewsByPage(PageShow pageShow) {
        pageShow.setTotalCount(totalNews(pageShow.getQuery()));
        List<News> newsList = new ArrayList<>();
        if(pageShow.getCurPage()==0){
            pageShow.setCurPage(1);
        }else{

            pageShow.setCurPage(pageShow.getCurPage());
            System.out.println(pageShow.getCurPage());
        }
        pageShow.setQuery(pageShow.getQuery());
        System.out.println(pageShow.getCurPage());
        newsList =newsDao.queryNewsByPage(pageShow);
        for (News news : newsList){
            System.out.println(news);
        }
        return newsList;
    }
}
