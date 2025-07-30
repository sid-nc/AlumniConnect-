package com.alumniconnect.repository;

import com.alumniconnect.model.*;
import com.alumniconnect.observer.*;

import java.util.*;

public class DataRepository {
    private static DataRepository instance;

    private List<Alumni> alumniList = new ArrayList<>();
    private List<JobPost> jobPosts = new ArrayList<>();
    private List<JobPostObserver> observers = new ArrayList<>();

    private DataRepository() {
    }

    public static synchronized DataRepository getInstance() {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }

    public void addObserver(JobPostObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String title) {
        for (JobPostObserver obs : observers) {
            obs.notify(title);
        }
    }

    public void addAlumni(Alumni a) {
        alumniList.add(a);
    }

    public List<Alumni> getAllAlumni() {
        return alumniList;
    }

    public void addJob(JobPost j) {

        jobPosts.add(j);
        notifyObservers(j.getTitle());
    }

    public List<JobPost> getAllJobs() {
        return jobPosts;
    }
}
