package com.alumniconnect.controller;

import com.alumniconnect.model.Message;
import com.alumniconnect.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository msgRepo;

    @GetMapping("/message")
    public String messageForm(Model model) {
        model.addAttribute("message", new Message());
        return "message";
    }

    @PostMapping("/message")
    public String sendMessage(@ModelAttribute Message message, Authentication auth) {
        message.setFromUser(auth.getName());
        msgRepo.save(message);
        return "redirect:/";
    }

    @GetMapping("/inbox")
    public String inbox(Model model, Authentication auth) {
        model.addAttribute("messages", msgRepo.findByToUser(auth.getName()));
        return "inbox";
    }
}
