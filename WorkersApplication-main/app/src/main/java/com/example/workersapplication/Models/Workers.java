package com.example.workersapplication.Models;

import android.graphics.Bitmap;

public class Workers {

    String worker_name,location,salary,rating;
    int worker_image;

    public Workers() {
    }

    public Workers(String worker_name, String location, String salary, String rating, int worker_image) {
        this.worker_name = worker_name;
        this.location = location;
        this.salary = salary;
        this.rating = rating;
        this.worker_image = worker_image;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getWorker_image() {
        return worker_image;
    }

    public void setWorker_image(int worker_image) {
        this.worker_image = worker_image;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
