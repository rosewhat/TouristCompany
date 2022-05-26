package com.soul.touristcompany.domain;

public class Info {
    private String title;
    private String description;
    private String street;
    private int image;

    public Info(String title, String description, String street, int image) {
        this.title = title;
        this.description = description;
        this.street = street;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public String getStreet() {
        return street;
    }
}
