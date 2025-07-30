package com.alumniconnect.model;

import com.alumniconnect.observer.JobPostObserver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobPost {
    private Long id;
    private String title;
    private String description;
    private String postedBy;
    private LocalDate postedDate;

    private List<JobPostObserver> observers = new ArrayList<>();

    public JobPost() {
    }

    public JobPost(String title, String description, String postedBy, LocalDate postedDate) {
        this.title = title;
        this.description = description;
        this.postedBy = postedBy;
        this.postedDate = postedDate;
    }

    public void addObserver(JobPostObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (JobPostObserver obs : observers) {
            obs.notify(this.title);
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }
}
