package com.alumniconnect.factory;

import com.alumniconnect.model.Alumni;

public class AlumniFactory {
    public static Alumni createAlumni(String name, String email, String batch) {
        Alumni a = new Alumni();
        a.setName(name);
        a.setEmail(email);
        a.setBatch(batch);
        return a; // Factory Pattern
    }
}
