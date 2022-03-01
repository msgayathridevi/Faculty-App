package com.example.faculty;

public class UserHelperClass2 {

    String portion, interactive, rg_str, feed_text;
    int digital_prog;
    float star_value;

    public UserHelperClass2() {
    }

    public UserHelperClass2(String portion, String interactive, int digital_prog, float star_value, String rg_str, String feed_text) {
        this.portion = portion;
        this.interactive = interactive;
        this.rg_str = rg_str;
        this.feed_text = feed_text;
        this.digital_prog = digital_prog;
        this.star_value = star_value;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    public String getInteractive() {
        return interactive;
    }

    public void setInteractive(String interactive) {
        this.interactive = interactive;
    }

    public String getRg() {
        return rg_str;
    }

    public void setRg(String rg_str) {
        this.rg_str = rg_str;
    }

    public String getFeed_text() {
        return feed_text;
    }

    public void setFeed_text(String feed_text) {
        this.feed_text = feed_text;
    }

    public int getDigital_prog() {
        return digital_prog;
    }

    public void setDigital_prog(int digital_prog) {
        this.digital_prog = digital_prog;
    }

    public float getStar_value() {
        return star_value;
    }

    public void setStar_value(float star_value) {
        this.star_value = star_value;
    }
}
