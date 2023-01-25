package com.restorant.backend.PojoInput;

public class ReviewInput {

    private int rating;
    private String text;
    private Integer Uid;
    private Integer Rid;

    public ReviewInput(int rating, String text, Integer uid, Integer rid) {
        this.rating = rating;
        this.text = text;
        Uid = uid;
        Rid = rid;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }

    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer rid) {
        Rid = rid;
    }
}
