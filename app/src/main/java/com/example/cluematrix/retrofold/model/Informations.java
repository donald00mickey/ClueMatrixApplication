package com.example.cluematrix.retrofold.model;

public class Informations {
    int image, image2;
    String name;

    public Informations(int image, int image2, String name) {
        this.image = image;
        this.image2 = image2;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
