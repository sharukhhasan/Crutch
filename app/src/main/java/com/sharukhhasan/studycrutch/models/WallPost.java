package com.sharukhhasan.studycrutch.models;

import java.util.Date;

/**
 * Created by sharukhhasan on 5/25/16.
 */
public class WallPost {
    private String title;
    private String postBody;
    private Date datePosted;
    private User userPosted;
    private Course coursePosted;

    public WallPost() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public User getUserPosted() {
        return userPosted;
    }

    public void setUserPosted(User userPosted) {
        this.userPosted = userPosted;
    }

    public Course getCoursePosted() {
        return coursePosted;
    }

    public void setCoursePosted(Course coursePosted) {
        this.coursePosted = coursePosted;
    }
}
