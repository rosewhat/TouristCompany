package com.soul.touristcompany.domain;

import android.media.Image;
import android.widget.ImageView;

public class Tourist {
    private int images;
    private String title;
    private String description;

    public Tourist(int images, String title, String description) {
        this.images = images;
        this.title = title;
        this.description = description;
    }

    public int getImages() {
        return images;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
