package com.alumniconnect.strategy;

import com.alumniconnect.model.JobPost;
import java.util.*;

public interface JobSortingStrategy {
    List<JobPost> sort(List<JobPost> jobs);
}
