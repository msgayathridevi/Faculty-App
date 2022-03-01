package com.example.faculty;

public class UserHelperClass {

    float star;
    int seek1, seek2;
    String feed_text;

    public UserHelperClass() {
    }

    public UserHelperClass(float star, int seek1, int seek2, String feed_text) {
        this.star = star;
        this.seek1 = seek1;
        this.seek2 = seek2;
        this.feed_text = feed_text;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public int getSeek1() {
        return seek1;
    }

    public void setSeek1(int seek1) {
        this.seek1 = seek1;
    }

    public int getSeek2() {
        return seek2;
    }

    public void setSeek2(int seek2) {
        this.seek2 = seek2;
    }

    public String getFeed_text() {
        return feed_text;
    }

    public void setFeed_text(String feed_text) {
        this.feed_text = feed_text;
    }
}