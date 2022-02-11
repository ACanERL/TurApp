package com.example.tourapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TurModel implements Serializable {
    @SerializedName("name")
    String name;
    @SerializedName("info")
    String info;
    @SerializedName("image")
    String image;
    @SerializedName("price")
    String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
