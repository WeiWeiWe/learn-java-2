package com.practice.collections;

public class Goods {
    private String sn;
    private String title;

    public Goods() {

    }

    public Goods(String sn, String title) {
        this.setTitle(title);
        this.setSn(sn);
    }

    @Override
    public int hashCode() {
        return this.sn.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Goods) {
            Goods goods = (Goods) obj;
            if (this.sn.equals(((Goods) obj).getSn())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.hashCode() + "=Goods{" +
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
