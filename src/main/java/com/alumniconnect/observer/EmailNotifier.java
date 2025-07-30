package com.alumniconnect.observer;

public class EmailNotifier implements JobPostObserver {
    private String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void notify(String jobTitle) {
        System.out.println("[EMAIL] Notified " + email + " about job: " + jobTitle);
    }
}
