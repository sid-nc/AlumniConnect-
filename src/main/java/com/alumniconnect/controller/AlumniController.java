package com.alumniconnect.controller;

import com.alumniconnect.model.*;
import com.alumniconnect.repository.DataRepository;
import com.alumniconnect.observer.EmailNotifier;
import com.alumniconnect.observer.JobPostObserver;
import com.alumniconnect.strategy.*;

import java.time.LocalDate;

import jakarta.annotation.PostConstruct; // You can use javax.annotation.PostConstruct if using Java EE

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlumniController {

    DataRepository repo = DataRepository.getInstance();
    JobSortingStrategy strategy = new TitleSortStrategy();

    public AlumniController() {
        repo.addObserver(new EmailNotifier("admin@college.edu"));
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("alumniList", repo.getAllAlumni());
        model.addAttribute("jobList", strategy.sort(repo.getAllJobs()));
        return "home";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("alumni", new Alumni());
        return "register";
    }

    @PostMapping("/register")
    public String registerAlumni(@ModelAttribute Alumni alumni) {
        repo.addAlumni(alumni);
        return "redirect:/";
    }

    @GetMapping("/job")
    public String showJobForm(Model model) {
        model.addAttribute("jobPost", new JobPost());
        return "job";
    }

    @PostMapping("/job")
    public String postJob(@ModelAttribute JobPost jobPost) {
        repo.addJob(jobPost); // Ensure you have an `addJob()` method for JobPost in your DataRepository
        return "redirect:/";
    }

    @PostConstruct
    public void loadSampleData() {
        repo.addAlumni(new Alumni("Alice Johnson", "2018", "B.Tech CSE", "alice@gmail.com"));
        repo.addAlumni(new Alumni("Brian Lee", "2019", "B.Tech ECE", "brian.lee@example.com"));
        repo.addAlumni(new Alumni("Carol Smith", "2020", "B.Sc IT", "carol_smith@example.com"));
        repo.addAlumni(new Alumni("David Rao", "2021", "MCA", "david.rao@alumni.edu"));

        JobPostObserver observer = new EmailNotifier("admin@college.edu");

        JobPost job1 = new JobPost("Software Developer", "Work on Spring Boot backend", "Infosys",
                LocalDate.of(2024, 4, 15));
        JobPost job2 = new JobPost("Frontend Intern", "React-based UI development", "Wipro", LocalDate.of(2024, 3, 28));
        JobPost job3 = new JobPost("AI Research Intern", "Work on NLP models", "TCS Research",
                LocalDate.of(2024, 4, 5));

        job1.addObserver(observer);
        job2.addObserver(observer);
        job3.addObserver(observer);

        repo.addJob(job1);
        repo.addJob(job2);
        repo.addJob(job3);
    }
}
