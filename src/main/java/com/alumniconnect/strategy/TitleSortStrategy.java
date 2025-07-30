package com.alumniconnect.strategy;

import com.alumniconnect.model.JobPost;
import java.util.*;

public class TitleSortStrategy implements JobSortingStrategy {
    public List<JobPost> sort(List<JobPost> jobs) {
        jobs.sort(Comparator.comparing(JobPost::getTitle));
        return jobs;
    }
}
