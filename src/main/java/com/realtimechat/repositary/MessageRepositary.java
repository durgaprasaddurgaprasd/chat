package com.realtimechat.repositary;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.realtimechat.model.Message;
import java.util.List;

public interface MessageRepositary extends MongoRepository<Message, String> {
    // Fetch messages by name
    List<Message> findByName(String name);
}
