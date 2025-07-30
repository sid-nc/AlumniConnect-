package com.alumniconnect.strategy;

import com.alumniconnect.model.JobPost;
import java.util.*;

public class DateSortStrategy implements JobSortingStrategy {
    public List<JobPost> sort(List<JobPost> jobs) {
        return jobs; // Stub: Assuming jobs are pre-sorted by date
    }
}
