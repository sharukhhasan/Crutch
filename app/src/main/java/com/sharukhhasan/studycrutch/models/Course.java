package com.sharukhhasan.studycrutch.models;

import java.util.ArrayList;

/**
 * Created by sharukhhasan on 5/25/16.
 */
public class Course {
    private String professor;
    private String courseName;
    private ArrayList<User> classmates;
    private ArrayList<WallPost> courseWall;

    public Course(String courseName)
    {
        this.courseName = courseName;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
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
