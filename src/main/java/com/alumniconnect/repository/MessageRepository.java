package com.alumniconnect.repository;

import com.alumniconnect.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByToUser(String toUser);
}
