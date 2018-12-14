package com.example.andstudio102.myapplication.Model;

public class Category {
    public Category() {
    }

    private  String Name;
    private  String Image;

    public Category(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
