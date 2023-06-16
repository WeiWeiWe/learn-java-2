package com.practice.collections;

public class Goods {
    private String sn;
    private String title;

    public Goods() {

    }

    public Goods(String sn, String title) {
        this.setSn(sn);
        this.setTitle(title);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "sn='" + sn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
