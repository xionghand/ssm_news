package com.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Scope("prototype")
public class Query {
    private String qTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date qStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date qEndNewsDate;

    public String getqTitle() {
        return qTitle;
    }

    public void setqTitle(String qTitle) {
        this.qTitle = qTitle;
    }

    public Date getqStartDate() {
        return qStartDate;
    }

    public void setqStartDate(Date qStartDate) {
        this.qStartDate = qStartDate;
    }

    public Date getqEndNewsDate() {
        return qEndNewsDate;
    }

    public void setqEndNewsDate(Date qEndNewsDate) {
        this.qEndNewsDate = qEndNewsDate;
    }
}
