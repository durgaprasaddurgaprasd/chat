package com.realtimechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.realtimechat.model.Message;
import com.realtimechat.repositary.MessageRepositary;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageRepositary messageRepository;

    // Handle new messages and save them
    @MessageMapping("/messages")
    @SendTo("/topic/return-to")
    public Message getcontent(Message message) {
        messageRepository.save(message);
        return message;
    }

    // Endpoint to fetch messages by user name
    @GetMapping("/messages/history/{name}")
    public List<Message> getChatHistory(@PathVariable String name) {
        return messageRepository.findByName(name);  // Fetch messages by user name
    }
}
