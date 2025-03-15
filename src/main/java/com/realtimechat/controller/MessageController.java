package com.realtimechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realtimechat.model.Message;
import com.realtimechat.repositary.MessageRepositary;

@RestController
public class MessageController {

    @Autowired
    private MessageRepositary messageRepository;

    // Handle new messages and save them
    @MessageMapping("/messages")
    @SendTo("/topic/return-to")
    public Message getcontent(Message message) {  // ✅ No @RequestBody here
        System.out.println("Received message: " + message); // Debugging log

        // Save message to MongoDB
        messageRepository.save(message);

        return message;
    }

    // Endpoint to fetch old messages
    @GetMapping("/messages/history")
    public List<Message> getChatHistory() {
        return messageRepository.findAll(); // Retrieve all messages
    }
}
