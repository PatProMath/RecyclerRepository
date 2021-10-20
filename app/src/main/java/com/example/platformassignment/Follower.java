package com.example.platformassignment;

public class Follower {
    int image;
    String name;
    String location;
    String status;

    public Follower(int image, String name, String location, String status) {
        this.image = image;
        this.name = name;
        this.location = location;
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
