package com.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("prototype")
public class News {
    private  Integer id;
    private  Integer newsId ;
    private  String title;
    private  String context;
    private String  newsMan;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date newsDate ;
    private String pic;
    private Integer typeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getNewsMan() {
        return newsMan;
    }

    public void setNewsMan(String newsMan) {
        this.newsMan = newsMan;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public News() {
    }

    public News(Integer id, Integer newsId, String title, String context, String newsMan, Date newsDate, String pic, Integer typeId) {
        this.id = id;
        this.newsId = newsId;
        this.title = title;
        this.context = context;
        this.newsMan = newsMan;
        this.newsDate = newsDate;
        this.pic = pic;
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", newsId=" + newsId +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", newsMan='" + newsMan + '\'' +
                ", newsDate=" + newsDate +
                ", pic='" + pic + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}
