package com.sharukhhasan.studycrutch.models;

import java.util.ArrayList;

/**
 * Created by sharukhhasan on 5/25/16.
 */
public class Course {
    private String professor;
    private ArrayList<User> classmates;
    private ArrayList<WallPost> courseWall;

    public Course() {}

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public ArrayList<User> getClassmates() {
        return classmates;
    }

    public void setClassmates(ArrayList<User> classmates) {
        this.classmates = classmates;
    }

    public ArrayList<WallPost> getCourseWall() {
        return courseWall;
    }

    public void setCourseWall(ArrayList<WallPost> courseWall) {
        this.courseWall = courseWall;
    }
}
