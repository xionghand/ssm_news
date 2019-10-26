package com.controller;

import com.pojo.News;
import com.pojo.PageShow;
import com.service.NewsService;
import com.service.UpLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private UpLoadService upLoadService;

    @RequestMapping("/newsMain")
    public ModelAndView newsMain(PageShow pageShow){
        ModelAndView mv = new ModelAndView();

        List<News> list =  newsService.queryNewsByPage(pageShow);
        mv.addObject("list", list);

        mv.setViewName("main");
        return mv;
    }

    @RequestMapping("/addNews")
    public ModelAndView addNews(News news,@RequestParam("imgPic")MultipartFile imgPic){
        ModelAndView mv = new ModelAndView();
        news = upLoadService.newsUpload(news,imgPic);
        newsService.addNews(news);
        List list = newsService.queryTypeId();
        mv.addObject("list",list);
        mv.setViewName("redirect:newsMain");
        return mv;
    }


    @RequestMapping("toUpdate")
    public ModelAndView toUpdate(int id){
        ModelAndView mv = new ModelAndView();
        News news = newsService.queryById(id);
        List list = newsService.queryTypeId();
        mv.addObject("news",news);
        mv.addObject("list",list);
        mv.setViewName("update");
        return mv;
    }

    @RequestMapping("update")
    public ModelAndView updateNews(News news,@RequestParam("imgPic")MultipartFile imgPic){
        ModelAndView mv = new ModelAndView();
        news = upLoadService.newsUpload(news,imgPic);
        newsService.updateNews(news);
        mv.setViewName("redirect:newsMain");
        return mv;
    }

    @RequestMapping("delNews")
    public ModelAndView delNews(@RequestParam("ids")int[] ids){
         ModelAndView mv = new ModelAndView();
         newsService.delNewsById(ids);
         mv.setViewName("redirect:newsMain");
         return mv;
    }


    @RequestMapping("/newsMainJson")
    @ResponseBody
    public List<News> newsMainJson(PageShow pageShow){
        List<News> list = newsService.queryNewsByPage(pageShow);
        return list;
    }


}
