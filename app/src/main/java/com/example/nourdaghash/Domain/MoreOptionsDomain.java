package com.example.nourdaghash.Domain;

public class MoreOptionsDomain {
    private String title;
    private String pic;
private Double star;
private int time;

    public MoreOptionsDomain(String title,String pic,Double star,int time) {
        this.title = title;
        this.pic=pic;
        this.star=star;
                this.time=time;
    }

    public String title() {
        return title;
    }

    public MoreOptionsDomain setTitle(String title) {
        this.title = title;
        return this;
    }

    public String pic() {
        return pic;
    }

    public MoreOptionsDomain setPic(String pic) {
        this.pic = pic;
        return this;
    }

    public Double star() {
        return star;
    }

    public int time() {
        return time;
    }

    public MoreOptionsDomain setTime(int time) {
        this.time = time;
        return this;
    }

    public MoreOptionsDomain setStar(Double star) {
        this.star = star;
        return this;
    }
}


