package com.hp.johndeere.model;

/**
 * Created by htpl22 on 15/7/16.
 */
public class GridBean {
    String title = "", image = "";

    public GridBean(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
